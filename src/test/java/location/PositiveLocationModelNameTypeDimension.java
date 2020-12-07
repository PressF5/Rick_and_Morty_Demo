package location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utilityTest.BaseMethodAPI.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import results.ResultsLocation;

public class PositiveLocationModelNameTypeDimension {

	private Response response;
	private ResultsLocation result;

	@Given("Open the end point {string} with the valid {string} equal {string} and {string} equal {string} and {string} equal {string}.")
	public void openEndPoint(String endPoint, String name, String nameValue, String type, String typeValue,
			String dimension, String dimensionValue) {

		response = methodGETwithThreeQueryParam(endPoint, name, nameValue, type, typeValue, dimension, dimensionValue);
	}

	@When("Get the result with the name, type, dimension.")
	public void getResult() {

		result = getBody(response, ResultsLocation.class);
	}

	@Then("The name should be {string}, the type should be {string}, the dimension should be {string}, the status code should be {int}, the content type should be {string}.")
	public void check(String nameLocation, String typeLocation, String dimensionLocation, Integer statusCode,
			String contentType) {

		if (nameLocation != "")
			for (Location resultLocation : result.getResults())
				assertThat(resultLocation.getName().toLowerCase(), containsString(nameLocation.toLowerCase()));

		if (typeLocation != "")
			for (Location resultLocation : result.getResults())
				assertThat(resultLocation.getType().toLowerCase(), containsString(typeLocation.toLowerCase()));

		if (dimensionLocation != "")
			for (Location resultLocation : result.getResults())
				assertThat(resultLocation.getDimension().toLowerCase(),
						containsString(dimensionLocation.toLowerCase()));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
