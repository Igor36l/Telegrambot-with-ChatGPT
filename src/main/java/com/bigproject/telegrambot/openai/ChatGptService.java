package com.bigproject.telegrambot.openai;

import com.bigproject.telegrambot.openai.api.ChatCompletionRequest;
import com.bigproject.telegrambot.openai.api.Message;
import com.bigproject.telegrambot.openai.api.OpenAIClient;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatGptService {

    private final OpenAIClient openAIClient;
    private final ChatGptHistoryService chatGptHistoryService;

    @Nonnull
    public String getResponseChatForUser(
            Long userId,
            String userTextInput
    ) {
        chatGptHistoryService.createHistoryIfNotExist(userId);
        var history = chatGptHistoryService.addMessageToHistory(
                userId,
                Message.builder()
                        .content(userTextInput)
                        .role("user")
                        .build()
        );

        var request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(history.chatMessages())
                .build();
        var response = openAIClient.createChatCompletion(request);

        var messageFromGpt = response.choices().get(0)
                .message();

        chatGptHistoryService.addMessageToHistory(userId, messageFromGpt);

        return messageFromGpt.content();
    }


}
