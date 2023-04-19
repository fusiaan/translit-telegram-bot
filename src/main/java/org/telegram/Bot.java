package org.telegram;

import org.telegram.Transliterator.Transliterator;
import org.telegram.command.StartCommand;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    StartCommand startCommand;
    Transliterator transliterator;
    
    Bot() {
        startCommand = new StartCommand();
        transliterator = Transliterator.createTransliterator();
    }
    
    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        try {
    
    
            if (msg.isCommand()) {
                if (msg.getText().equals("/start"))
                    execute(startCommand.sendStartMsg(update));
                else if (msg.getText().equals("/scheme"))
                    return;
                
                return;
            }
    
            if (msg.hasText()) {
                execute(transliterator.translateText(update));
            }
    
    
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getBotUsername() {
        return "TranslitBot";
    }
    
    @Override
    public String getBotToken() {
        return "5995859635:AAGU74jrTa7xCAWbqdJrW9MOBJmpppMMd1U";
    }
}
