package org.example.model;

public class ResWeather {
    private String temp;
    private String country;
    private String region;
    private String localtime;
    private String sunset;
    private String moonrise;
    private String cloud;
    private String humidity;
    private String wind;
    private String day;
    private String night;
    private boolean isDay;
    private String uv;
    private Double pressureMb;

    public ResWeather(String temp, String country, String region, String localtime, String sunset,
                      String moonrise, String cloud, String humidity, String wind, String day, String night,
                      boolean isDay, String uv,Double pressureMb) {
        if (isDay){
            day += "✅";
        }
        else night += "✅";

        this.temp = temp;
        this.country = country;
        this.region = region;
        this.localtime = localtime;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.cloud = cloud;
        this.humidity = humidity;
        this.wind = wind;
        this.day = day;
        this.night = night;
        this.isDay = isDay;
        this.uv = uv;
        this.pressureMb = pressureMb;
    }


    @Override
    public String toString() {
        if (cloud.equals("Mist")){
            cloud += " \uD83C\uDF2B";
        }
         else if (cloud.equals("Light rain")) {
            cloud += "\uD83D\uDCA6";
        }
        return " \tCURRENT WEATHER " +'\n'+
                " Country : " + country + '\n' +
                " Region  : " + region + '\n' +
                " Temp : " + temp + "°C\n" +
                " Sunset : " + sunset + '\n' +
                " MoonSet : " + moonrise + '\n' +
                " Cloud : " + cloud + '\n' +
                " Humidity : " + humidity + "% \n"+
                " Pressure : " + pressureMb +"mb\n" +
                " UV index : " + uv + "\n" +
                " Wind : " + wind + "Mph \n" +
                " Day ☀ : " + day + "\n" +
                " Night \uD83C\uDF1A : " + night + "\n" +
                " Localtime : " + localtime ;
    }
}
