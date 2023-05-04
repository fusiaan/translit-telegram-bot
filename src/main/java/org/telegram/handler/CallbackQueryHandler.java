package org.telegram.handler;

import org.telegram.services.TelegramService;
import org.telegram.services.TransliterationService;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

class CallbackQueryHandler implements Handler {
    private final String changeSettings = "<b><i>Настройки были изменины</i></b>";
    
    private final TelegramService telegramService = TelegramService.getInstance();
    
    @Override
    public boolean support(Update update) {
        if (update.hasCallbackQuery()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void handle(Update update) {
        telegramService.sendEditMessage(changeScheme(update));
        telegramService.sendAnswerCallbackQuery(closeCallbackQuery(update));
    }
    
    private EditMessageText changeScheme(Update update) {
        TransliterationService.changeScheme(Integer.parseInt(update.getCallbackQuery().getData()));
        
        EditMessageText msg = EditMessageText.builder()
                                      .text(changeSettings)
                                      .chatId(update.getCallbackQuery().getMessage().getChatId())
                                      .messageId(update.getCallbackQuery().getMessage().getMessageId())
                                      .parseMode("HTML").build();
        
        return msg;
    }
    
    private AnswerCallbackQuery closeCallbackQuery(Update update) {
        AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                                                          .callbackQueryId(update.getCallbackQuery().getId())
                                                          .build();
        return answerCallbackQuery;
    }
}
