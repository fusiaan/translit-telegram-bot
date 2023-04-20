package org.telegram.transliterator;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.homyakin.iuliia.Schemas;
import ru.homyakin.iuliia.Translator;

import java.util.ArrayList;
import java.util.List;


public class Transliterator {
    private List<Translator> schemas = new ArrayList<>(27);
    private static int indexScheme;
    
    
    static {
        indexScheme = 24;
    }
    private Transliterator() {
        indexScheme = 24;
    }
    
    public static void changeScheme(int index) {
        if (index < 0 || index > 26) return;
        indexScheme = index;
    }
    
    public SendMessage translateText(Update update) {
        String translated = translit(update.getMessage().getText());
        if (translated.equals(""))
            translated = "400 Bad Request";
        
        SendMessage sm = SendMessage.builder()
                                 .text(translated).chatId(update.getMessage().getChatId())
                                 .build();
        
        return sm;
    }
    
    private String translit(String str) {
        return schemas.get(indexScheme).translate(str);
    }
    
    public static Transliterator createTransliterator() {
        Transliterator tr = new Transliterator();
        for (Schemas schem : Schemas.values())
            tr.schemas.add(new Translator(schem));
        
        return tr;
    }
    
}