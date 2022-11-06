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
public class Astro implements Serializable {

	@SerializedName("moonset")
	public String moonset;

	@SerializedName("moon_illumination")
	public String moonIllumination;

	@SerializedName("sunrise")
	public String sunrise;

	@SerializedName("moon_phase")
	public String moonPhase;

	@SerializedName("sunset")
	public String sunset;

	@SerializedName("moonrise")
	public String moonrise;
}