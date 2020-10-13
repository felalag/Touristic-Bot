package by.felalag.touristicbot.helper;

import by.felalag.touristicbot.domain.model.MessageType;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class TelegramMessageHelper {

    private static final String BOT_COMMAND_TYPE_NAME = "bot_command";

    public static MessageType getMessageType(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            List<MessageEntity> messageEntities = message.getEntities();
            if (messageEntities != null && messageEntities.size() == 1
                    && messageEntities.get(0).getType().equals(BOT_COMMAND_TYPE_NAME)) {
                return MessageType.BOT_COMMAND;
            }
            if (messageEntities == null) {
                return MessageType.REQUEST_MESSAGE;
            }
        }
        return MessageType.UNSUPPORTED_ACTION;
    }

    public static String getMessageText(Update update) {
        return update.getMessage().getText();
    }

    public static Long getChatId(Update update) {
        return update.getMessage().getChatId();
    }

}
