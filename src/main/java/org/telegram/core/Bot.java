package org.telegram.core;

import org.telegram.handler.UpdateHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    private final UpdateHandler updateHandler = new UpdateHandler();
    
    private static final ConfigReader CONFIG = ConfigReader.getInstance();
    public static final String BOT_TOKEN_CONFIG = CONFIG.get("BOT_TOKEN");
    private static final String BOT_USERNAME_CONFIG = CONFIG.get("BOT_USERNAME");
    
    @Override
    public void onUpdateReceived(Update update) {
        if(updateHandler.support(update)) {
            updateHandler.handle(update);
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
