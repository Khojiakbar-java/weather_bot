package org.example.bot;

import org.example.botService.Weather_service;
import org.example.consta.Constants;
import org.example.model.ResWeather;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weather_bot extends TelegramLongPollingBot implements Constants {
    String[] list1 = {TASHKENT, SIRDARYO, JIZZAKH, SAMARQAND, QASHQADARYO, SURKHANDARYO};
    String[] list2 = {XORAZM, NAVOIY, ANDIJAN, NAMANGAN, FERGANA, QARAKALPAKSTAN};

    Weather_service weather_service = new Weather_service();

    private void handleCallBackQuery(CallbackQuery callbackQuery) throws TelegramApiException {
        Long chatId = callbackQuery.getMessage().getChatId();
        String param = callbackQuery.getData();
        switch (param){
            case TASHKENT -> {
                ResWeather resWeather = weather_service.runApiReq(TASH_LAT, TASH_LONG);
                execute(SendMessage.builder().text(resWeather.toString()).chatId(chatId).build());
            }
            case SIRDARYO -> {
                ResWeather resWeather = weather_service.runApiReq(SIR_LAT, SIR_LONG);
                execute(SendMessage.builder().text(resWeather.toString()).chatId(chatId).build());
            }
            case JIZZAKH -> {
                ResWeather resWeather = weather_service.runApiReq(JIZ_LAT, JIZ_LONG);
                execute(SendMessage.builder().text(resWeather.toString()).chatId(chatId).build());
            }
            case SAMARQAND -> {
                ResWeather resWeather = weather_service.runApiReq(SAM_LAT,SAM_LONG);
                execute(SendMessage.builder().text(resWeather.toString()).chatId(chatId).build());
            }
            case QASHQADARYO -> {

            }
        }


    }

    private void handleMessage(Message message) {
        String text = message.getText();
        Long chatId = message.getChatId();


        if (text.equals(START)) {
            System.out.println("Start bosildi");
            SendMessage onceSendMessage = new SendMessage();
            onceSendMessage.setText("Hello to WEATHER BOT \uD83C\uDF27☀️\uD83C\uDF27 ");
            startHeadBot(chatId, onceSendMessage);

        } else if (text.equals(CURRENT_WEATHER)) {
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
        else if (text.equals(ALL_REGIONS)) {
            List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

            for (int i = 0; i < 6; i++) {
                buttons.add(Arrays.asList(
                        InlineKeyboardButton.builder().text(list1[i]).callbackData(list1[i]).build(),
                        InlineKeyboardButton.builder().text(list2[i]).callbackData(list2[i]).build()
                ));
            }
            try {
                execute(
                        SendMessage.builder()
                                .text("Please choose Region")
                                .chatId(message.getChatId().toString())
                                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                                .build()
                );
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }


        }


    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            try {
                handleCallBackQuery(update.getCallbackQuery());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (update.getMessage().hasLocation()) {
            Location location = update.getMessage().getLocation();
            Long chatId = update.getMessage().getChatId();
            handleLocation(location, chatId);
        } else if (update.hasMessage()) {
            handleMessage(update.getMessage());
        }


    }

    private void handleLocation(Location location, Long chatId) {
        Double latitude = location.getLatitude();
        Double longitude = location.getLongitude();
        ResWeather resWeather = weather_service.runApiReq(latitude, longitude);
        try {
            execute( SendMessage.builder().text(resWeather.toString()).chatId(chatId).build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
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
