package by.felalag.touristicbot.service;

import by.felalag.touristicbot.helper.TelegramMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class TelegramMessageHandler {

    public SendMessage handleRequest(Update update) {
        String request = getRequest(update);
        SendMessage message = getChatSpecificSendMessage(update);
        return getResponseMessage(message, request);
    }

    abstract SendMessage getResponseMessage(SendMessage message, String request);

    private String getRequest(Update update) {
        return TelegramMessageHelper.getMessageText(update);
    }

    private SendMessage getChatSpecificSendMessage(Update update) {
        return new SendMessage()
                .setChatId(TelegramMessageHelper.getChatId(update));
    }

}
