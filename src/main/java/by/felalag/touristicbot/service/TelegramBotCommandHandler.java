package by.felalag.touristicbot.service;

import by.felalag.touristicbot.helper.DefaultMenuKeyboardMarkup;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class TelegramBotCommandHandler extends TelegramMessageHandler {

    private static final String START_COMMAND = "/start";
    private static final String INFO_COMMAND = "/info";

    private static final String START_COMMAND_TEXT = "Hi there! I hope I'll be helpful \ud83d\ude03\nYou can get info" +
            " about this bot from menu down below. Or just type the name of the city you want to find fun places at!";
    private static final String INFO_COMMAND_TEXT = "This bot aims at helping tourists to investigate smth fun in " +
            "the city. All the info you get from here is just somebody's opinion, don't take it too serious and " +
            "follow your heart, of course.";
    private static final String UNKNOWN_COMMAND_TEXT = "Listen, buddy, I don't know this command \ud83d\ude1e";

    @Override
    SendMessage getResponseMessage(SendMessage message, String request) {
        String text;
        switch(request) {
            case START_COMMAND:
                message
                        .setReplyMarkup(DefaultMenuKeyboardMarkup.getInstance());
                text = START_COMMAND_TEXT;
                break;
            case INFO_COMMAND:
                text = INFO_COMMAND_TEXT;
                break;
            default:
                text = UNKNOWN_COMMAND_TEXT;
                break;
        }
        return message
                .setText(text);
    }

}
