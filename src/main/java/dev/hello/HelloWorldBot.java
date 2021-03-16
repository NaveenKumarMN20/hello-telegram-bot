package dev.hello;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelloWorldBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage().getText().equals("/hello")) {
            try {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Hello " + update.getMessage().getFrom().getUserName());
                System.err.println(update.getMessage().getChatId());
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
