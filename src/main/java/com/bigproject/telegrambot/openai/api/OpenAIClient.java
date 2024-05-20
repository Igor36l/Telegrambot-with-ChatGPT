package com.bigproject.telegrambot.openai.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class OpenAIClient {

    private final String token;
    private final RestClient restClient;

    public ChatCompletionResponse createChatCompletion(
            ChatCompletionRequest request
    ) {
        ResponseEntity<ChatCompletionResponse> responseEntity = restClient.post().uri("v1/chat/completions")
                .headers(httpHeaders -> httpHeaders.setBearerAuth(token)).contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .toEntity(ChatCompletionResponse.class);
        return responseEntity.getBody();
    }

    @SneakyThrows
    public TranscriptionResponse createTranscription(
            CreateTranscriptionRequest request
    ) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(request.audioFile()));
        body.add("model", request.model());

        ResponseEntity<TranscriptionResponse> responseEntity = restClient.post().uri("v1/audio/transcriptions")
                .headers(httpHeaders -> httpHeaders.setBearerAuth(token)).contentType(MediaType.MULTIPART_FORM_DATA)
                .body(body)
                .retrieve()
                .toEntity(TranscriptionResponse.class);
        return responseEntity.getBody();
    }
}
