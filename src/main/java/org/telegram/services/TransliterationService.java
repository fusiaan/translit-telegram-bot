package org.telegram.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.homyakin.iuliia.Schemas;
import ru.homyakin.iuliia.Translator;

import java.util.ArrayList;
import java.util.List;


public class TransliterationService {
    private final List<Translator> schemas = new ArrayList<>(22);
    private static int indexScheme;
    
    private final String emptyMessage = "Я не могу перевести пустое сообщение:(";
    
    
    static {
        indexScheme = 1;
    }
    private TransliterationService() {
        indexScheme = 1;
    }
    
    public static void changeScheme(int index) {
        if (index < 0 || index > 21) return;
        indexScheme = index;
    }
    
    public SendMessage translateText(Update update) {
        String translated = translit(update.getMessage().getText());
        if (translated.equals(""))
            translated = emptyMessage;
    
        SendMessage sm = SendMessage.builder().text(translated)
                                 .chatId(update.getMessage().getChatId())
                                 .build();
        return sm;
    }
    
    private String translit(String str) {
        return schemas.get(indexScheme).translate(str);
    }
    
    public static TransliterationService createTransliterator() {
        TransliterationService tr = new TransliterationService();
        for (Schemas schem : Schemas.values())
            tr.schemas.add(new Translator(schem));
        
        return tr;
    }
    
}