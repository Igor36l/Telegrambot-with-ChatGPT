package com.bigproject.bot;

import com.bigproject.bot.openai.ChatGptService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramBotConfiguration {

    @SneakyThrows
    @Bean
    public TelegramBot telegramBot(
            @Value("${bot.token}") String token,
            TelegramBotsApi telegramBotsApi,
            ChatGptService chatGptService) {
        var botOptions = new DefaultBotOptions();
       var bot = new TelegramBot(botOptions, token, chatGptService);
       telegramBotsApi.registerBot(bot);
       return bot;
    }

    @Bean
    @SneakyThrows
    public TelegramBotsApi telegramBotsApi(){
        return new TelegramBotsApi(DefaultBotSession.class);
    }
}
