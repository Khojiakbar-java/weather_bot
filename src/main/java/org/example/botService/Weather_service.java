package org.example.botService;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.bot.Weather_bot;
import org.example.model.Weather;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Weather_service implements Runnable{

  public  ArrayList<Weather> arrayList = new ArrayList<>();

    public static void register_bot() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
         telegramBotsApi.registerBot(new Weather_bot());
    }

    public ArrayList<Weather> getWeatherList(){
      return arrayList;
  }

    @Override
    public void run() {
        URL url;
        try {
            url = new URL("http://api.weatherapi.com/v1/current.json?key=31f3c48205cc48418d8125442220411&q=41.311081,69.240562&aqi=no");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Type type = new TypeToken<List<Weather>>(){}.getType();
            arrayList = gson.fromJson(bufferedReader, type);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
