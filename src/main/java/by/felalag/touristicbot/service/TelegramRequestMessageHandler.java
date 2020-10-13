package by.felalag.touristicbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class TelegramRequestMessageHandler extends TelegramMessageHandler {

    @Autowired
    private CityService cityService;

    private static final String MENU_BUTTON = "Info about this bot";
    private static final String BOT_INFO = "This bot aims at helping tourists to investigate smth fun in a city. " +
            "All the info you get from here is just somebody's opinion, don't take it too serious" +
            "and follow your heart, of course.";
    private static final String NO_CITY_INFO_FOUND = "No info found for this city. Sorry \ud83d\ude1e";

    @Override
    SendMessage getResponseMessage(SendMessage message, String request) {
        String text;
        if (request.equals(MENU_BUTTON)) {
            text = BOT_INFO;
        } else {
            String info = cityService.findInfoByName(request);
            text = info == null ? NO_CITY_INFO_FOUND : info;
        }
        return message
                .setText(text);
    }

}
