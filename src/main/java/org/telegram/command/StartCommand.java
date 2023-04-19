package org.telegram.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand {
    private String startMessage = "<i>Отправьте текст, который нужно перевести.</i>\n" +
                                          "\nЧтобы изменить схему, нажмите /scheme";
    
    
    public SendMessage sendStartMsg(Update update) {
        SendMessage sendMessage = SendMessage.builder()
                                          .text(startMessage).parseMode("HTML")
                                          .chatId(update.getMessage().getChatId())
                                          .build();
        
        return sendMessage;
    }
    
}
