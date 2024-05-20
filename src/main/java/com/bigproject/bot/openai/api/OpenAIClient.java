package com.bigproject.bot.openai.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;


@RequiredArgsConstructor
public class OpenAIClient {

    private final String TOKEN;

    private final RestClient restClient;

    public ChatCompletionResponse createChatCompletion(
            ChatCompletionRequest request
    ) {
        ResponseEntity<ChatCompletionResponse> responseEntity = restClient.post()
                .body(request).contentType(MediaType.APPLICATION_JSON)
//                .header("Authorization", "Bearer " + TOKEN)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(TOKEN))
                .retrieve()
                .toEntity(ChatCompletionResponse.class);
        return responseEntity.getBody();
    }



}
