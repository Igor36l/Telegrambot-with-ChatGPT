package com.bigproject.bot.openai;

import com.bigproject.bot.openai.api.Message;
import lombok.Builder;

import java.util.List;

@Builder
public record ChatHistory(
        List<Message> messageList
) {
}
