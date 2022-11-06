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
public class Forecast implements Serializable {

	@SerializedName("forecastday")
	public List<ForecastdayItem> forecastday;
}