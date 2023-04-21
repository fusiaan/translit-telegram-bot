package org.telegram.command;

import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.transliterator.Transliterator;

public class Command {
//    /scheme variables
    private SchemeKeyboard schemeKeyboard = new SchemeKeyboard();
    
    private final String schemeChangeTxt = "<b>Выберите одну из предложенных схем:\n</b>";
    
    
//    /start variables
    private final String startTxt = "<i>Отправьте текст, который нужно перевести.</i>\n" +
                                          "\nЧтобы изменить схему, нажмите /scheme";
    private final String changeSettings = "<b><i>Настройки были изменины</i></b>";
    
    //    //scheme methods
    public SendMessage schemeMessage(Update update) {
        SendMessage sendMessage = SendMessage.builder()
                                          .text(schemeChangeTxt).parseMode("HTML")
                                          .chatId(update.getMessage().getChatId())
                                          .replyMarkup(schemeKeyboard.getKeyboardScheme()).build();
    
        return sendMessage;
    }
    
    public EditMessageText editSchemeText(Update update) {
        Integer.getInteger("dsds");
        Transliterator.changeScheme(Integer.parseInt(update.getCallbackQuery().getData()));
        
        EditMessageText msg = EditMessageText.builder()
                                      .text(changeSettings)
                                      .chatId(update.getCallbackQuery().getMessage().getChatId())
                                      .messageId(update.getCallbackQuery().getMessage().getMessageId())
                                      .parseMode("HTML").build();
        
        return msg;
    }
    
    public AnswerCallbackQuery closeCallbackQuery(Update update) {
        AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                                                          .callbackQueryId(update.getCallbackQuery().getId())
                                                          .build();
        return answerCallbackQuery;
    }
    
    
    //    /start methods
    public SendMessage startMessage(Update update) {
        SendMessage sendMessage = SendMessage.builder()
                                          .text(startTxt).parseMode("HTML")
                                          .chatId(update.getMessage().getChatId())
                                          .build();
        return sendMessage;
    }
}
