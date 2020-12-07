package results;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import episode.Episode;

@Data
public class ResultsEpisode {
	
	@SerializedName("info")
	@Expose
	private Info info;
	
	@SerializedName("results")
	@Expose
	private List<Episode> results;
}
