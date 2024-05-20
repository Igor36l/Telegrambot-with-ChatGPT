package com.bigproject.telegrambot.openai.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient RestClient(){
        return RestClient.builder()
                .baseUrl("https://api.proxyapi.ru/openai/")
                .build();
    }
}
