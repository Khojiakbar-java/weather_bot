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
public class Condition implements Serializable {

	@SerializedName("code")
	public int code;

	@SerializedName("icon")
	public String icon;

	@SerializedName("text")
	public String text;
}