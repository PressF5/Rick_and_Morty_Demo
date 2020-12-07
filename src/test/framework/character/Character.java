package character;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Character{

	@SerializedName("id")
	@Expose
	private int id;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("status")
	@Expose
	private String status;
	
	@SerializedName("species")
	@Expose
	private String species;
	
	@SerializedName("type")
	@Expose
	private String type;
	
	@SerializedName("gender")
	@Expose
	private String gender;
	
	@SerializedName("origin")
	@Expose
	private Origin origin;
	
	@SerializedName("location")
	@Expose
	private Location location;
	
	@SerializedName("image")
	@Expose
	private String image;
	
	@SerializedName("episode")
	@Expose
	private List<String> episode;
	
	@SerializedName("url")
	@Expose
	private String url;
	
	@SerializedName("created")
	@Expose
	private String created;
}
