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
public class Day implements Serializable {

	@SerializedName("avgvis_km")
	public double avgvisKm;

	@SerializedName("uv")
	public double uv;

	@SerializedName("avgtemp_f")
	public double avgtempF;

	@SerializedName("avgtemp_c")
	public double avgtempC;

	@SerializedName("daily_chance_of_snow")
	public int dailyChanceOfSnow;

	@SerializedName("maxtemp_c")
	public double maxtempC;

	@SerializedName("maxtemp_f")
	public double maxtempF;

	@SerializedName("mintemp_c")
	public double mintempC;

	@SerializedName("avgvis_miles")
	public double avgvisMiles;

	@SerializedName("daily_will_it_rain")
	public int dailyWillItRain;

	@SerializedName("mintemp_f")
	public double mintempF;

	@SerializedName("totalprecip_in")
	public double totalprecipIn;

	@SerializedName("totalsnow_cm")
	public double totalsnowCm;

	@SerializedName("avghumidity")
	public double avghumidity;

	@SerializedName("condition")
	public Condition condition;

	@SerializedName("maxwind_kph")
	public double maxwindKph;

	@SerializedName("maxwind_mph")
	public double maxwindMph;

	@SerializedName("daily_chance_of_rain")
	public int dailyChanceOfRain;

	@SerializedName("totalprecip_mm")
	public double totalprecipMm;

	@SerializedName("daily_will_it_snow")
	public int dailyWillItSnow;
}