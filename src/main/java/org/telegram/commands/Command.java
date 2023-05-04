package org.telegram.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Command {
    private final SchemeKeyboard schemeKeyboard = new SchemeKeyboard();
    
    private final String unknownCommandText = "<b>Такой команды не существует</b>\n" +
            "Список поддерживаемых команд:\n/start\n/scheme";
    
    private final String schemeChangeText = "<b>Выберите одну из предложенных схем:\n</b>";
    
    private final String startCommandText = "<i>Отправьте текст, который нужно перевести.</i>\n" +
                                          "\nЧтобы изменить схему, нажмите /scheme";

    
    public SendMessage commandsHandler(Message message) {
        switch(message.getText()) {
            case "/start":
                return startMessage(message);
            case "/scheme":
                return schemeMessage(message);
            default:
                return unknownCommand(message);
        }
    }
    
    private SendMessage startMessage(Message message) {
        SendMessage sendMessage = SendMessage.builder()
                                          .text(startCommandText).parseMode("HTML")
                                          .chatId(message.getChatId())
                                          .build();
        return sendMessage;
    }
    
    private SendMessage schemeMessage(Message message) {
        SendMessage sendMessage = SendMessage.builder()
                                          .text(schemeChangeText).parseMode("HTML")
                                          .chatId(message.getChatId())
                                          .replyMarkup(schemeKeyboard.getKeyboardScheme()).build();
    
        return sendMessage;
    }
    
    private SendMessage unknownCommand(Message message) {
        SendMessage sendMessage = SendMessage.builder()
                                          .text(unknownCommandText).parseMode("HTML")
                                          .chatId(message.getChatId())
                                          .build();
        return sendMessage;
    }
}
