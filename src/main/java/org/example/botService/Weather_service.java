package org.example.botService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Since;
import org.example.bot.Weather_bot;
import org.example.consta.Constants;
import org.example.model.*;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Weather_service implements Constants {
    public static List<Weather> arrayList = new ArrayList<>();

    public static void register_bot() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new Weather_bot());
    }

    public List<Weather> getWeatherList() {
        return arrayList;
    }

    public ResWeather runApiReq(Double lat, Double lang) {
        URL url = null;
        try {
            url = new URL("http://api.weatherapi.com/v1/forecast.json?key=31f3c48205cc48418d8125442220411&q="+lat+','+lang);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder builder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();

        @Deprecated
        JsonParser parse = new JsonParser();
        @Deprecated
        JsonElement element = parse.parse(String.valueOf(builder));
        Weather weather = gson.fromJson(element, Weather.class);
        System.out.println(weather);
        String country = weather.getLocation().getCountry();
        String region = weather.getLocation().getRegion();
        String localtime = weather.getLocation().getLocaltime();
        List<ForecastdayItem> forecastday = weather.getForecast().getForecastday();
        String moonrise = "";
        String sunrise = "";
        List<HourItem> list = new ArrayList<>();
        for (ForecastdayItem it : forecastday) {
            moonrise += it.astro.getMoonset();
            sunrise += it.astro.getSunset();
            list = it.hour;
        break;
        }
        Double pressureMb = null;
        String temp ="";
        for (HourItem item:list) {
            pressureMb = item.getPressureMb();
            temp = String.valueOf(item.getTempC());
            break;
        }
        String cloud = weather.getCurrent().getCondition().getText();
        String humidity = String.valueOf(weather.getCurrent().getHumidity());
        String windmph = String.valueOf(weather.getCurrent().getWindMph());
        boolean isDay = false;
        int Day = weather.getCurrent().isDay;
        if (Day == 1){
            isDay = true;
        }
        String nameRegion = weather.getLocation().getName();
        region += "/"+nameRegion;

        String uv = String.valueOf(weather.getCurrent().getUv());
        ResWeather resWeather = new ResWeather(temp,country,region,localtime,sunrise,moonrise,cloud,humidity,windmph,
                "","",isDay,uv,pressureMb);
        //System.out.println(weather);
         return resWeather;

    }
}
