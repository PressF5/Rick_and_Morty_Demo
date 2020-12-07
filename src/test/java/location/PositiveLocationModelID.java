package location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class PositiveLocationModelID {

	private Response response;
	private Location result;

	@Given("Open the end point {string} with the valid parameter {int}.")
	public void openEndPoint(String endPoint, Integer param) {

		response = methodGETwithPathParam(endPoint, param);
	}

	@When("Get the result with the id.")
	public void getResult() {

		result = getBody(response, Location.class);
	}

	@Then("The id should be {int}, the status code should be {int}, the content type should be {string}.")
	public void check(Integer id, Integer statusCode, String contentType) {

		assertThat(result.getId(), equalTo(id));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
