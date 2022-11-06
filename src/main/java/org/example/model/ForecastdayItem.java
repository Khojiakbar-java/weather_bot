package org.example.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Generated("com.asif.gsonpojogenerator")
public class ForecastdayItem implements Serializable {

	@SerializedName("date")
	public String date;

	@SerializedName("astro")
	public Astro astro;

	@SerializedName("date_epoch")
	public int dateEpoch;

	@SerializedName("hour")
	public List<HourItem> hour;

	@SerializedName("day")
	public Day day;
}