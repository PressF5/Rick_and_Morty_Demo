package episode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import error.Error;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class NegativeEpisodeModelPage {

	private Response response;
	private Error error;

	@Given("Open the end point {string} with the invalid {string} equal {int}.")
	public void openEndPoint(String endPoint, String paramName, Integer paramValue) {

		response = methodGETwithOneQueryParam(endPoint, paramName, paramValue);
	}

	@When("Get the error with the page.")
	public void getError() {

		error = getBody(response, Error.class);
	}

	@Then("The error should be {string}, the status code should be {int}, the content type should be {string} with the invalid page.")
	public void check(String errors, Integer statusCode, String contentType) {

		assertThat(error.getError(), equalTo(errors));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
