package com.bigproject.telegrambot.openai;

import com.bigproject.telegrambot.openai.api.OpenAIClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OpenAIConfiguration {

    @Bean
    public OpenAIClient openAIClient(
            @Value("${Proxy.token}") String botToken,
            RestClient restClient
    ) {
        return new OpenAIClient(botToken, restClient);
    }

}