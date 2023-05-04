package org.telegram.services;

import org.telegram.core.Bot;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramService{
    private final TelegramSender sender = new TelegramSender();
    private static final TelegramService INSTANCE = new TelegramService();
    private TelegramService() {
    }
    
    public static TelegramService getInstance(){
        return INSTANCE;
    }
    
    public void sendMessage(SendMessage sm) {
        try {
            sender.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    public void sendEditMessage(EditMessageText editMessageText) {
        try {
            sender.execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    public void sendAnswerCallbackQuery(AnswerCallbackQuery acq) {
        try {
            sender.execute(acq);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
    }
    private class TelegramSender extends DefaultAbsSender {
        TelegramSender() {
            super(new DefaultBotOptions(), Bot.BOT_TOKEN_CONFIG);
        }
    }
    
}
