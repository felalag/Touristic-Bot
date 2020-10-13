package by.felalag.touristicbot.helper;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class DefaultMenuKeyboardMarkup extends ReplyKeyboardMarkup {

    private static DefaultMenuKeyboardMarkup defaultMenuKeyboardMarkup;

    private static final String MENU_BUTTON = "Info about this bot";

    private DefaultMenuKeyboardMarkup() {
        setSelective(true);
        setResizeKeyboard(true);
        setOneTimeKeyboard(true);
        setKeyboard(getDefaultKeyboard());
    }

    public static ReplyKeyboardMarkup getInstance() {
        if (defaultMenuKeyboardMarkup == null) {
            defaultMenuKeyboardMarkup = new DefaultMenuKeyboardMarkup();
        }
        return defaultMenuKeyboardMarkup;
    }

    private List<KeyboardRow> getDefaultKeyboard() {
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(MENU_BUTTON);
        keyboard.add(keyboardFirstRow);
        return keyboard;
    }

}
