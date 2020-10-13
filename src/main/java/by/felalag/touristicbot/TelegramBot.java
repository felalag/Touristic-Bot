package by.felalag.touristicbot;

import by.felalag.touristicbot.helper.TelegramMessageHelper;
import by.felalag.touristicbot.service.TelegramBotCommandHandler;
import by.felalag.touristicbot.service.TelegramRequestMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private TelegramBotCommandHandler botCommandHandler;

    @Autowired
    private TelegramRequestMessageHandler requestMessageHandler;

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    private static final String UNSUPPORTED_ACTION_TEXT = "Heeeeeeeeey, I guess you got confused, you should either " +
            "enter a command starting with '/' or a name of the city, that's all I can do for now \ud83d\ude05";

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage responseMessage;
        switch(TelegramMessageHelper.getMessageType(update)) {
            case BOT_COMMAND:
                responseMessage = botCommandHandler.handleRequest(update);
                break;
            case REQUEST_MESSAGE:
                responseMessage = requestMessageHandler.handleRequest(update);
                break;
            case UNSUPPORTED_ACTION:
            default:
                responseMessage = new SendMessage()
                        .setChatId(TelegramMessageHelper.getChatId(update))
                        .setText(UNSUPPORTED_ACTION_TEXT);
                break;
        }
        try {
            execute(responseMessage);
        } catch(TelegramApiException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

}
