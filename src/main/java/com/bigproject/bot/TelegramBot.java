package com.bigproject.bot;

import com.bigproject.bot.openai.ChatGptService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final ChatGptService gptService;

    public TelegramBot(DefaultBotOptions options, String botToken, ChatGptService gptService) {
        super(options, botToken);
        this.gptService = gptService;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();

            var gptGeneratedText= gptService.getResponseChatForUser(chatId, text);


            SendMessage sendMessage = new SendMessage(chatId.toString(),gptGeneratedText);
            sendApiMethod(sendMessage);
        }
    }

    @Override
    public String getBotUsername() {
        return "ChatGPT-4.0-bigprojectbot";
    }
}
