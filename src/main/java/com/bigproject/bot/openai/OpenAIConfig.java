package com.bigproject.bot.openai;

import com.bigproject.bot.openai.api.OpenAIClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OpenAIConfig {

    @Bean
    public OpenAIClient openAIClient(
            @Value("${ProxyApi}") String token,
            RestClient restClient
    ){
        return new OpenAIClient(token, restClient);
    }

}
