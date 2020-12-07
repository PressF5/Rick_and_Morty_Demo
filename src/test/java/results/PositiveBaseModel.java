package results;

import baseUrl.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static utilityTest.BaseMethodAPI.*;

public class PositiveBaseModel {

	private Response response;
	private BaseUrl baseUrl;

	@Given("Open the base url.")
	public void openEndPoints() {
		
		response = methodGET();
	}
	
	@When("Get the values of characters, locations, episodes.")
	public void getResult() {
		
		baseUrl = getBody(response, BaseUrl.class);
	}
	
	@Then("The values should be {string}, {string}, {string}, status code should be {int}, content type should be {string}.")
	public void valuesShouldBe(String character, String location, String episode, Integer statusCode, String contentType) {
		
		assertThat(baseUrl.getCharacters(), equalTo(character));
		assertThat(baseUrl.getLocations(), equalTo(location));
		assertThat(baseUrl.getEpisodes(), equalTo(episode));
		
		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
