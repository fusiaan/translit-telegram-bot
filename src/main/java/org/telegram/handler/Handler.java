package org.telegram.handler;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Handler {
    boolean support(Update update);
    void handle(Update update);
}
