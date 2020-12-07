package character;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import error.Error;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class NegativeCharacterModelArrayID {

	private Response response;
	private Error error;

	@Given("Open the end point {string} with the invalid array of id parameter {string}.")
	public void openEndPoint(String endPoint, String param) {
		
		response = methodGETwithPathParam(endPoint, param);
	}

	@When("Get the error with the array of id.")
	public void getError() {
		
		error = getBody(response, Error.class);
	}

	@Then("The error should be {string}, the status code should be {int}, the content type should be {string} with the invalid array id.")
	public void check(String err, Integer statusCode, String contentType) {
		
		assertThat(error.getError(), equalTo(err));
		
		checkStatusCodeAndContentType(response, statusCode, contentType);
	}

}
