package org.telegram.handler;

import org.telegram.services.TelegramService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.services.TransliterationService;

class MessageHandler implements Handler {
    private final TransliterationService transliterationService = TransliterationService.createTransliterator();
    private final TelegramService telegramService = TelegramService.getInstance();
    
    @Override
    public boolean support(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() && !update.getMessage().isCommand()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void handle(Update update) {
        SendMessage sm = transliterationService.translateText(update);
        telegramService.sendMessage(sm);
    }
    
}
