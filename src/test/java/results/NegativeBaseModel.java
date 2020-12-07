package results;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import error.Error;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class NegativeBaseModel {

	private Response response;
	private Error error;

	@Given("Open the end point {string}.")
	public void openEndPoints(String endPoint) {
		
		response = methodGET(endPoint);
	}

	@When("Get the error.")
	public void getError() {
		
		error = getBody(response, Error.class);
	}

	@Then("The error should be {string}, the status code should be {int}, the content type should be {string}.")
	public void check(String errors, Integer statusCode, String contentType) {
		
		assertThat(error.getError(), equalTo(errors));
		
		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
