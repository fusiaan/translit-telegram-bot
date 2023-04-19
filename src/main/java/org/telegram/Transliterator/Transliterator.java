package org.telegram.Transliterator;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.homyakin.iuliia.Schemas;
import ru.homyakin.iuliia.Translator;

import java.util.ArrayList;
import java.util.List;


public class Transliterator {
    public List<Translator> schemas = new ArrayList<>(28);
    
    
    private Transliterator() {}
    
    public SendMessage translateText(Update update) {
        String translated = translit(update.getMessage().getText());
        if (translated.equals(""))
            translated = "Ошибка: в результате перевода сообщения получилась пустая строка.";
        
        SendMessage sm = SendMessage.builder()
                                 .text(translated).chatId(update.getMessage().getChatId())
                                 .build();
        
        return sm;
    }
    
    private String translit(String str) {
        return schemas.get(26).translate(str);
    }
    
    public static Transliterator createTransliterator() {
        Transliterator tr = new Transliterator();
        for (Schemas schem : Schemas.values())
            tr.schemas.add(new Translator(schem));
        
        return tr;
    }
    
}