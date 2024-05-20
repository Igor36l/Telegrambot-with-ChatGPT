package com.bigproject.bot.openai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient RestClient(){
        return RestClient.builder()
                .baseUrl("https://api.proxyapi.ru/openai/v1/chat/completions")
                .build();
    }
}
