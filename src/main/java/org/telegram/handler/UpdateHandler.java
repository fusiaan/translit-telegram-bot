package org.telegram.handler;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

public class UpdateHandler implements Handler{
    private final MessageHandler messageHandler = new MessageHandler();
    private final CommandHandler commandHandler = new CommandHandler();
    private final CallbackQueryHandler callbackQueryHandler = new CallbackQueryHandler();
    
    private List<Handler> handlers = new ArrayList<>();
    public UpdateHandler() {
        handlers.add(messageHandler);
        handlers.add(commandHandler);
        handlers.add(callbackQueryHandler);
    }
    
    @Override
    public boolean support(Update update) {
        return true;
    }
    
    @Override
    public void handle(Update update) {
        Handler h;
        for (int i = 0; i < handlers.size(); i++) {
            h = handlers.get(i);
            if (h.support(update)) {
                h.handle(update);
                break;
            }
        }
    }
}
