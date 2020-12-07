package location;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Location{

	@SerializedName("id")
	@Expose
	private int id;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("type")
	@Expose
	private String type;
	
	@SerializedName("dimension")
	@Expose
	private String dimension;
	
	@SerializedName("residents")
	@Expose
	private List<String> residents;
	
	@SerializedName("url")
	@Expose
	private String url;
	
	@SerializedName("created")
	@Expose
	private String created;
}
