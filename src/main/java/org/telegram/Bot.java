package org.telegram;

import org.telegram.command.StartCommand;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    StartCommand startCommand;
    
    Bot() {
        startCommand = new StartCommand();
    }
    
    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        
        if (msg.isCommand()) {
            try {
                if (msg.getText().equals("/start")) {
                    execute(startCommand.sendStartMsg(update));
                }
            } catch (TelegramApiException exc) {
                exc.printStackTrace();
            }
        }
        
        return;
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
