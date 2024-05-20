package com.bigproject.bot.openai.api;

import java.util.List;


public record ChatCompletionResponse(
        List<Choice> choices
){}
