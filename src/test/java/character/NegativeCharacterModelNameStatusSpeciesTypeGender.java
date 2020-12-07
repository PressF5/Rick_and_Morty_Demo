package character;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import error.Error;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class NegativeCharacterModelNameStatusSpeciesTypeGender {

	private Response response;
	private Error error;

	@Given("Open the end point {string} with the invalid {string} equal {string}, {string} equal {string}, {string} equal {string}, {string} equal {string}, {string} equal {string}.")
	public void openEndPoint(String endPoint, String name, String nameValue, String status, String statusValue,
			String species, String speciesValue, String type, String typeValue, String gender, String genderValue) {

		response = methodGETwithFiveQueryParam(endPoint, name, nameValue, status, statusValue, species, speciesValue,
				type, typeValue, gender, genderValue);
	}

	@When("Get the error with the name, status, species, type, gender.")
	public void getError() {

		error = getBody(response, Error.class);
	}

	@Then("The error should be {string}, the status code should be {int}, the content type should be {string} with the invalid name, status, species, type, gender.")
	public void check(String errors, Integer statusCode, String contentType) {

		assertThat(error.getError(), equalTo(errors));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
