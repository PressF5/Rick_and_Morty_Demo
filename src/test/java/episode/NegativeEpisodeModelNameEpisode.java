package episode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import error.Error;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class NegativeEpisodeModelNameEpisode {

	private Response response;
	private Error error;

	@Given("Open the end point {string} with the invalid {string} equal {string} and {string} equal {string}.")
	public void openEndPoint(String endPoint, String name, String nameValue, String episode, String episodeValue) {

		response = methodGETwithTwoQueryParam(endPoint, name, nameValue, episode, episodeValue);
	}

	@When("Get the error with the name and page.")
	public void getResult() {

		error = getBody(response, Error.class);
	}

	@Then("The error should be {string}, the status code should be {int}, the content type should be {string} with the invalid name and episode.")
	public void check(String errors, Integer statusCode, String contentType) {

		assertThat(error.getError(), equalTo(errors));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
