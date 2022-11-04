package org.example.model;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@ToString

//US - EPA standard.
//1 means Good
//2 means Moderate
//3 means Unhealthy for sensitive group
//4 means Unhealthy
//5 means Very Unhealthy
//6 means Hazardous
public class AirQuality implements Serializable {

	@SerializedName("no2")
	public double nitrogenDioxide;

	@SerializedName("o3")
	public double ozone;

	@SerializedName("us-epa-index")
	public int usEpaIndex;

	@SerializedName("so2")
	public double sulphurDioxide;

	@SerializedName("co")
	public double carbonMonoxide;

}