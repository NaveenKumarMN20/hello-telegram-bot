package dev.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelloWorldBot extends TelegramLongPollingBot {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldBot.class);

    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage().getText().equals("/hello")) {
            log.info("/hello message from user id {} && user name is {}",update.getMessage().getFrom().getId(),update.getMessage().getFrom().getUserName());
            try {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Hello " + update.getMessage().getFrom().getUserName());
                sendMessage.setChatId(update.getMessage().getChatId().toString());
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "test-bot";
    }

    @Override
    public String getBotToken() {
        return "";
    }
}
