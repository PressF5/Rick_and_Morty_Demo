package utilityTest;

public class TransformParameter {

	public static String transParamNull(String value) {
		if (value.equals("null"))
			return null;
		else
			return value;
	}
}
