package org.telegram.command;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

class SchemeKeyboard {
    private InlineKeyboardButton ALA_LC = InlineKeyboardButton.builder().text("ALA-LC")
                                                      .callbackData("0").build();
    private InlineKeyboardButton ALA_LC_ALT = InlineKeyboardButton.builder().text("ALA-LC_ALT")
                                                      .callbackData("1").build();
    private InlineKeyboardButton BGN_PCGN = InlineKeyboardButton.builder().text("BGN/PCGN")
                                                      .callbackData("2").build();
    private InlineKeyboardButton BGN_PCGN_ALT = InlineKeyboardButton.builder().text("BGN/PCGN_ALT")
                                                      .callbackData("3").build();
    private InlineKeyboardButton BS_2979 = InlineKeyboardButton.builder().text("BS 2979:1958")
                                                      .callbackData("4").build();
    private InlineKeyboardButton BS_2979_ALT = InlineKeyboardButton.builder().text("BS 2979:1958_ALT")
                                                      .callbackData("5").build();
    private InlineKeyboardButton GOST_779 = InlineKeyboardButton.builder().text("ГОСТ 7.79-2000")
                                                      .callbackData("6").build();
    private InlineKeyboardButton GOST_779_ALT = InlineKeyboardButton.builder().text("ГОСТ 7.79-2000_ALT")
                                                      .callbackData("7").build();
    private InlineKeyboardButton GOST_7034 = InlineKeyboardButton.builder().text("ГОСТ Р 7.0.34-2014")
                                                      .callbackData("8").build();
    private InlineKeyboardButton GOST_16876 = InlineKeyboardButton.builder().text("ГОСТ 16876-71")
                                                      .callbackData("9").build();
    private InlineKeyboardButton GOST_16876_ALT = InlineKeyboardButton.builder().text("ГОСТ 16876-71_ALT")
                                                      .callbackData("10").build();
    private InlineKeyboardButton GOST_52290 = InlineKeyboardButton.builder().text("ГОСТ Р 52290-2004")
                                                      .callbackData("11").build();
    private InlineKeyboardButton GOST_52535 = InlineKeyboardButton.builder().text("ГОСТ Р 52535.1-2006")
                                                      .callbackData("12").build();
    private InlineKeyboardButton ICAO_DOC_9303 = InlineKeyboardButton.builder().text("ICAO DOC 9303")
                                                      .callbackData("13").build();
    private InlineKeyboardButton ISO_9_1954 = InlineKeyboardButton.builder().text("ISO/R 9:1954")
                                                      .callbackData("14").build();
    private InlineKeyboardButton ISO_9_1968 = InlineKeyboardButton.builder().text("ISO/R 9:1968")
                                                      .callbackData("15").build();
    private InlineKeyboardButton ISO_9_1968_ALT = InlineKeyboardButton.builder().text("ISO/R 9:1968_ALT")
                                                      .callbackData("16").build();
    private InlineKeyboardButton MOSMETRO = InlineKeyboardButton.builder().text("Мосметро")
                                                      .callbackData("17").build();
    private InlineKeyboardButton MVD_310 = InlineKeyboardButton.builder().text("МВД 310-1997")
                                                      .callbackData("18").build();
    private InlineKeyboardButton MVD_310_FR = InlineKeyboardButton.builder().text("МВД 310-1997_FR")
                                                      .callbackData("19").build();
    private InlineKeyboardButton MVD_782 = InlineKeyboardButton.builder().text("МВД 782-2000")
                                                      .callbackData("20").build();
    private InlineKeyboardButton SCIENTIFIC = InlineKeyboardButton.builder().text("Научная")
                                                      .callbackData("21").build();
    private InlineKeyboardButton TELEGRAM = InlineKeyboardButton.builder().text("Телеграммы")
                                                      .callbackData("22").build();
    private InlineKeyboardButton UNGEGN_1987 = InlineKeyboardButton.builder().text("UNGEGN 1987 V/18")
                                                      .callbackData("23").build();
    private InlineKeyboardButton WIKIPEDIA = InlineKeyboardButton.builder().text("Википедия")
                                                      .callbackData("24").build();
    private InlineKeyboardButton YANDEX_MAPS = InlineKeyboardButton.builder().text("Яндекс.Карты")
                                                      .callbackData("25").build();
    private InlineKeyboardButton YANDEX_MONEY = InlineKeyboardButton.builder().text("Яндекс.Деньги")
                                                      .callbackData("26").build();
    
    private InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
    
    public SchemeKeyboard() {
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(ALA_LC);
        row1.add(ALA_LC_ALT);
        row1.add(BGN_PCGN);
        
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(BGN_PCGN_ALT);
        row2.add(BS_2979);
    
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        row3.add(BS_2979_ALT);
        row3.add(GOST_779);
    
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        row4.add(GOST_779_ALT);
        row4.add(GOST_7034);
    
        List<InlineKeyboardButton> row5 = new ArrayList<>();
        row5.add(GOST_16876);
        row5.add(GOST_16876_ALT);
    
        List<InlineKeyboardButton> row6 = new ArrayList<>();
        row6.add(GOST_52290);
        row6.add(GOST_52535);
    
        List<InlineKeyboardButton> row7 = new ArrayList<>();
        row7.add(ICAO_DOC_9303);
        row7.add(ISO_9_1954);
    
        List<InlineKeyboardButton> row8 = new ArrayList<>();
        row8.add(ISO_9_1968);
        row8.add(ISO_9_1968_ALT);
    
        List<InlineKeyboardButton> row9 = new ArrayList<>();
        row9.add(MOSMETRO);
        row9.add(MVD_310);
        
        List<InlineKeyboardButton> row10 = new ArrayList<>();
        row10.add(MVD_310_FR);
        row10.add(MVD_782);
    
        List<InlineKeyboardButton> row11 = new ArrayList<>();
        row11.add(SCIENTIFIC);
        row11.add(TELEGRAM);
    
        List<InlineKeyboardButton> row12 = new ArrayList<>();
        row12.add(UNGEGN_1987);
        row12.add(WIKIPEDIA);
    
        List<InlineKeyboardButton> row13 = new ArrayList<>();
        row13.add(YANDEX_MAPS);
        row13.add(YANDEX_MONEY);
        
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        rowList.add(row7);
        rowList.add(row8);
        rowList.add(row9);
        rowList.add(row10);
        rowList.add(row11);
        rowList.add(row12);
        rowList.add(row13);

        keyboardMarkup.setKeyboard(rowList);
    }
    
    public InlineKeyboardMarkup getKeyboardScheme() {
        return keyboardMarkup;
    }
    
}
