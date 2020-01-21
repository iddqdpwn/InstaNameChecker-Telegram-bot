package org.home.server;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());

        String titleCheck = Parser.getTitleFromUsername(update.getMessage().getText());


        if (titleCheck.startsWith("Page Not Found")) {
            sendMessage.setText("This name is free!");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            sendMessage.setText("This name is not available to change :\n" + titleCheck);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "@instaNameChecker";
    }

    public String getBotToken() {
        return "1038045385:AAFC1Jit3kgLFU1v8Gt6_4PIikN-natc5xk";
    }
}
