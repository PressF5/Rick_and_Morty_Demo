package location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import error.Error;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class NegativeLocationModelNameTypeDimension {

	private Response response;
	private Error error;

	@Given("Open the end point {string} with the invalid {string} equal {string} and {string} equal {string} and {string} equal {string}.")
	public void openEndPoint(String endPoint, String name, String nameValue, String type, String typeValue,
			String dimension, String dimensionValue) {

		response = methodGETwithThreeQueryParam(endPoint, name, nameValue, type, typeValue, dimension, dimensionValue);
	}

	@When("Get the error with the name, type, dimension.")
	public void getResult() {

		error = getBody(response, Error.class);
	}

	@Then("The error should be {string}, the status code should be {int}, the content type should be {string} with the invalid name, type, dimension.")
	public void check(String errors, Integer statusCode, String contentType) {

		assertThat(error.getError(), equalTo(errors));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
