package com.bigproject.telegrambot.openai;

import com.bigproject.telegrambot.openai.api.Message;
import lombok.Builder;

import java.util.List;

@Builder
public record ChatHistory(
        List<Message> chatMessages
) {
}
