package org.example.bot;

import lombok.SneakyThrows;
import lombok.Value;
import org.checkerframework.checker.units.qual.K;
import org.example.consta.Constants;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonPollType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weather_bot extends TelegramLongPollingBot implements Constants {


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String text = update.getMessage().getText().trim();
            Long chatId = update.getMessage().getChatId();

            if (text.equals(START)) {
                SendMessage onceSendMessage = new SendMessage();
                onceSendMessage.setText("Hello to WEATHER BOT \uD83C\uDF27☀️\uD83C\uDF27 ");
                startHeadBot(chatId, onceSendMessage);

            }

            else if (text.equals(CURRENT_WEATHER)){
                SendMessage sendMessage = new SendMessage();
                ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
                markup.setResizeKeyboard(true);
                markup.setSelective(true);
                KeyboardButton button = new KeyboardButton();
                button.setRequestLocation(true);
                button.setText("Send location ");
                List<KeyboardRow> row = new ArrayList<>();
                row.add(new KeyboardRow(List.of(button)));
                markup.setKeyboard(row);
                sendMessage.setReplyMarkup(markup);
                sendMessage.setText(SEND_LOCATION);
                sendMessage.enableMarkdownV2(true);
                sendMessage.setChatId(chatId);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }


    private void startHeadBot(Long chatId, SendMessage onceSendMessage) {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setSelective(true);
        markup.setResizeKeyboard(true);
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardButton keyboardButt = new KeyboardButton();
        KeyboardButton keyboardButt1 = new KeyboardButton();
        KeyboardButton keyboardButt2 = new KeyboardButton();
        keyboardButt.setText(ALL_REGIONS);
        keyboardButt1.setText(CURRENT_WEATHER);
        keyboardButt2.setText(OTHER_REGIONS);
        rowList.add(new KeyboardRow(Arrays.asList(keyboardButt, keyboardButt1, keyboardButt2)));
        markup.setKeyboard(rowList);
        onceSendMessage.setReplyMarkup(markup);
        onceSendMessage.setChatId(chatId);
        try {
            execute(onceSendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
