package ru.panyukovnn.telegramsingleresponsibility.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.panyukovnn.telegramsingleresponsibility.config.TgBotApi;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TgBotListener {

    private final TgBotApi botApi;

    @EventListener(Update.class)
    public void onUpdate(Update update) {
        Long userId = Optional.ofNullable(update.getMessage())
                .map(Message::getFrom)
                .map(User::getId)
                .orElse(0L);
        String messageText = Optional.ofNullable(update.getMessage())
                .map(Message::getText)
                .orElse("Не удалось извлечь текст сообщения");

        log.info("Received message from user: {}. Text: {}", userId, messageText);

        try {
            Long chatId = Optional.ofNullable(update.getMessage())
                    .map(Message::getChatId)
                    .orElseThrow();

            botApi.execute(SendMessage.builder()
                    .chatId(chatId)
                    .text("Message received")
                    .build());
        } catch (TelegramApiException e) {
            log.error(e.getMessage(), e);
        }
    }
}
