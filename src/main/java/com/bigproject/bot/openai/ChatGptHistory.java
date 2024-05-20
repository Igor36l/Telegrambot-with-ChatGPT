package com.bigproject.bot.openai;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class ChatGptHistory {

    private final Map<Long, ChatHistory> chatHistoryMap = new ConcurrentHashMap<>();
}
