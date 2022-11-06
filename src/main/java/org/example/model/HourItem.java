package org.example.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Generated("com.asif.gsonpojogenerator")
public class HourItem implements Serializable {

	@SerializedName("feelslike_c")
	public double feelslikeC;

	@SerializedName("feelslike_f")
	public double feelslikeF;

	@SerializedName("wind_degree")
	public int windDegree;

	@SerializedName("windchill_f")
	public double windchillF;

	@SerializedName("windchill_c")
	public double windchillC;

	@SerializedName("temp_c")
	public double tempC;

	@SerializedName("temp_f")
	public double tempF;

	@SerializedName("cloud")
	public int cloud;

	@SerializedName("wind_kph")
	public double windKph;

	@SerializedName("wind_mph")
	public double windMph;

	@SerializedName("humidity")
	public int humidity;

	@SerializedName("dewpoint_f")
	public double dewpointF;

	@SerializedName("will_it_rain")
	public int willItRain;

	@SerializedName("uv")
	public double uv;

	@SerializedName("heatindex_f")
	public double heatindexF;

	@SerializedName("dewpoint_c")
	public double dewpointC;

	@SerializedName("is_day")
	public int isDay;

	@SerializedName("precip_in")
	public double precipIn;

	@SerializedName("heatindex_c")
	public double heatindexC;

	@SerializedName("wind_dir")
	public String windDir;

	@SerializedName("gust_mph")
	public double gustMph;

	@SerializedName("pressure_in")
	public double pressureIn;

	@SerializedName("chance_of_rain")
	public int chanceOfRain;

	@SerializedName("gust_kph")
	public double gustKph;

	@SerializedName("precip_mm")
	public double precipMm;

	@SerializedName("condition")
	public Condition condition;

	@SerializedName("will_it_snow")
	public int willItSnow;

	@SerializedName("vis_km")
	public double visKm;

	@SerializedName("time_epoch")
	public int timeEpoch;

	@SerializedName("time")
	public String time;

	@SerializedName("chance_of_snow")
	public int chanceOfSnow;

	@SerializedName("pressure_mb")
	public double pressureMb;

	@SerializedName("vis_miles")
	public double visMiles;
}