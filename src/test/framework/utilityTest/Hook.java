package utilityTest;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hook {

	@Before
	public void beforeScenario() {
		RestAssured.baseURI = "https://rickandmortyapi.com/api/";
	}
}
