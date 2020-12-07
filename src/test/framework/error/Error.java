package error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Error {

	@SerializedName("error")
	@Expose
	private String error;
}
