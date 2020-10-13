package by.felalag.touristicbot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Configuration
public class TelegramBotConfig {

    @Autowired
    private LongPollingBot telegramBot;

    static {
        ApiContextInitializer.init();
    }

    @PostConstruct
    public void start() throws TelegramApiRequestException {
        TelegramBotsApi api = new TelegramBotsApi();
        api.registerBot(telegramBot);
    }

}
