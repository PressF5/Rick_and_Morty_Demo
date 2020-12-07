package character;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import results.ResultsCharacter;
import utilityTest.TransformParameter;

public class PositiveCharacterModelPage {

	private Response response;
	private ResultsCharacter result;

	@Given("Open the end point {string} with the valid {string} equal {int}.")
	public void openEndPoint(String endPoint, String paramName, Integer paramValue) {
		
		response = methodGETwithOneQueryParam(endPoint, paramName, paramValue);
	}

	@When("Get the result with the page.")
	public void getResult() {
		
		result = getBody(response, ResultsCharacter.class);
	}

	@Then("The next page should be {string}, the previous should be {string}, the status code should be {int}, the content type should be {string}.")
	public void check(String nextPage, String prevPage, Integer statusCode,	String contentType) {
		
		assertThat(result.getInfo().getNext(), equalTo(TransformParameter.transParamNull(nextPage)));
		assertThat(result.getInfo().getPrev(), equalTo(TransformParameter.transParamNull(prevPage)));
		
		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
