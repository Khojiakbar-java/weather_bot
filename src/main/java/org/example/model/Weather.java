package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;
import java.io.Serializable;
@Getter
@Setter
@ToString
@Generated("com.asif.gsonpojogenerator")
public class Weather implements Serializable {

	@SerializedName("current")
	public Current current;

	@SerializedName("location")
	public Location location;
}