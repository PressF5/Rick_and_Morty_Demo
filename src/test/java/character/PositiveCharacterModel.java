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

public class PositiveCharacterModel {

	private Response response;
	private ResultsCharacter result;

	@Given("Open the end point {string}.")
	public void openEndPoint(String endPoint) {
		
		response = methodGET(endPoint);
	}

	@When("Get the result with the end point /character.")
	public void getResult() {
		
		result = getBody(response, ResultsCharacter.class);
	}

	@Then("Count of characters should be {int}, the next page should be {string}, the previous should be {string}, the status code should be {int}, the content type should be {string}.")
	public void check1(Integer countOfCharacter, String nextPage, String prevPage, Integer statusCode, String contentType) {
		
		assertThat(result.getResults().size(), equalTo(countOfCharacter));
		assertThat(result.getInfo().getNext(), equalTo(nextPage));
		assertThat(result.getInfo().getPrev(), equalTo(TransformParameter.transParamNull(prevPage)));
		
		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
