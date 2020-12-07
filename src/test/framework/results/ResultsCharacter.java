package results;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import character.Character;

@Data
public class ResultsCharacter {

	@SerializedName("info")
	@Expose
	private Info info;
	
	@SerializedName("results")
	@Expose
	private List<Character> results;
}
