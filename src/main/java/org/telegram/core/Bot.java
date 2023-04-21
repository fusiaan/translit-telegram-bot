package org.telegram.core;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.transliterator.Transliterator;
import org.telegram.command.Command;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Properties;

public class Bot extends TelegramLongPollingBot {
    private static final ConfigReader CONFIG = ConfigReader.getInstance();
    private static final String BOT_TOKEN_CONFIG = CONFIG.get("BOT_TOKEN");
    private static final String BOT_USERNAME_CONFIG = CONFIG.get("BOT_USERNAME");
    
    private Command command = new Command();
    private Transliterator transliterator = Transliterator.createTransliterator();
    
    
    public Bot() {}
    
    @Override
    public void onUpdateReceived(Update update) {
        try {
            
            if (update.hasMessage()) {
                var msg = update.getMessage();
                if (msg.isCommand()) {
                    switch (msg.getText()) {
                        case "/start":
                            execute(command.startMessage(update));
                            break;
                        case "/scheme":
                            execute(command.schemeMessage(update));
                            break;
                    }
                    return;
                }
                if (msg.hasText()) {
                    execute(transliterator.translateText(update));
                }
                
            } else if (update.hasCallbackQuery()) {
                if(isNumeric(update.getCallbackQuery().getData()))
                    pressButton(update);
            }
            
        } catch (TelegramApiException e) {
            try {
                e.printStackTrace();
                execute(SendMessage.builder().text("500 Internal Server Error")
                                .chatId(update.getMessage().getChatId()).build());
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void pressButton(Update update) throws TelegramApiException {
        execute(command.editSchemeText(update));
        execute(command.closeCallbackQuery(update));
    }
    
    private boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        
        try {
            double d = Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    @Override
    public String getBotUsername() {
        return BOT_USERNAME_CONFIG;
    }
    
    @Override
    public String getBotToken() {
        return BOT_TOKEN_CONFIG;
    }
}