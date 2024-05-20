package com.bigproject.telegrambot.openai.api;

import lombok.Builder;

import java.io.File;

@Builder
public record CreateTranscriptionRequest(
        File audioFile,
        String model
) {}
