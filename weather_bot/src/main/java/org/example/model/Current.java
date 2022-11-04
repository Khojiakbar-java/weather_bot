package org.example.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.model.AirQuality;
import org.example.model.Condition;

import java.io.Serializable;
@Getter
@Setter
@ToString
@Generated("com.asif.gsonpojogenerator")
public class Current implements Serializable {

	@SerializedName("feelslike_c")
	public double feelslikeC;

	@SerializedName("uv")
	public double uv;

	@SerializedName("last_updated")
	public String lastUpdated;

	@SerializedName("feelslike_f")
	public double feelslikeF;

	@SerializedName("wind_degree")
	public int windDegree;

	@SerializedName("last_updated_epoch")
	public int lastUpdatedEpoch;

	@SerializedName("is_day")
	public int isDay;

	@SerializedName("precip_in")
	public double precipIn;

	@SerializedName("air_quality")
	public AirQuality airQuality;

	@SerializedName("wind_dir")
	public String windDir;

	@SerializedName("gust_mph")
	public double gustMph;

	@SerializedName("temp_c")
	public double tempC;

	@SerializedName("pressure_in")
	public double pressureIn;

	@SerializedName("gust_kph")
	public double gustKph;

	@SerializedName("temp_f")
	public double tempF;

	@SerializedName("precip_mm")
	public double precipMm;

	@SerializedName("cloud")
	public int cloud;

	@SerializedName("wind_kph")
	public double windKph;

	@SerializedName("condition")
	public Condition condition;

	@SerializedName("wind_mph")
	public double windMph;

	@SerializedName("vis_km")
	public double visKm;

	@SerializedName("humidity")
	public int humidity;

	@SerializedName("pressure_mb")
	public double pressureMb;

	@SerializedName("vis_miles")
	public double visMiles;
}