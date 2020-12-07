package baseUrl;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class BaseUrl {

	@SerializedName("characters")
	@Expose
	private String characters;
	
	@SerializedName("locations")
	@Expose
	private String locations;
	
	@SerializedName("episodes")
	@Expose
	private String episodes;
}
