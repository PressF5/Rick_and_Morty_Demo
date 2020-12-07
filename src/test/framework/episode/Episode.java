package episode;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Episode{

	@SerializedName("id")
	@Expose
	private int id;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("air_date")
	@Expose
	private String air_date;
	
	@SerializedName("episode")
	@Expose
	private String episode;
	
	@SerializedName("characters")
	@Expose
	private List<String> characters;
	
	@SerializedName("url")
	@Expose
	private String url;
	
	@SerializedName("created")
	@Expose
	private String created;
}
