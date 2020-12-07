package results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Info {

	@SerializedName("count")
	@Expose
	private int count;
	
	@SerializedName("pages")
	@Expose
	private int pages;
	
	@SerializedName("next")
	@Expose
	private String next;
	
	@SerializedName("prev")
	@Expose
	private String prev;
}
