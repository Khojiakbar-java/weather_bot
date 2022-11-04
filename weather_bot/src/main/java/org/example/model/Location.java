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
public class Location implements Serializable {

	@SerializedName("localtime")
	public String localtime;

	@SerializedName("country")
	public String country;

	@SerializedName("name")
	public String name;

	@SerializedName("lon")
	public double lon;

	@SerializedName("region")
	public String region;

	@SerializedName("lat")
	public double lat;

	@SerializedName("tz_id")
	public String timeZoneId;
}