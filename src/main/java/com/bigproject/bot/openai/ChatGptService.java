package com.bigproject.bot.openai;

import com.bigproject.bot.openai.api.ChatCompletionRequest;
import com.bigproject.bot.openai.api.Message;
import com.bigproject.bot.openai.api.OpenAIClient;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatGptService {

    private final OpenAIClient openAIClient;

    @NotNull
    public String getResponseChatForUser(
            Long userId,
            String userTextInput
    ){
        var request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(List.of(Message.builder()
                        .role("user")
                        .content(userTextInput)
                        .build()
                ))
                .build();
        var response= openAIClient.createChatCompletion(request);
        return response.choices().getFirst()
                .message().content();
    }
}
