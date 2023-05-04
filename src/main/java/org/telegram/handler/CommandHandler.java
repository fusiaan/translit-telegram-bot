package org.telegram.handler;

import org.telegram.commands.Command;
import org.telegram.services.TelegramService;
import org.telegram.telegrambots.meta.api.objects.Update;

class CommandHandler implements Handler {
    private final Command command = new Command();
    private final TelegramService telegramService = TelegramService.getInstance();
    
    @Override
    public boolean support(Update update) {
        if (update.hasMessage() && update.getMessage().isCommand()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void handle(Update update) {
        try {
            telegramService.sendMessage(command.commandsHandler(update.getMessage()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
