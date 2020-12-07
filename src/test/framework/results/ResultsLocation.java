package results;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import location.Location;
import lombok.Data;

@Data
public class ResultsLocation {

	@SerializedName("info")
	@Expose
	private Info info;
	
	@SerializedName("results")
	@Expose
	private List<Location> results;
}
