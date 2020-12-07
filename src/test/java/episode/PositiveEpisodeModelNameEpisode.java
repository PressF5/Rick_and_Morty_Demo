package episode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utilityTest.BaseMethodAPI.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import results.ResultsEpisode;

public class PositiveEpisodeModelNameEpisode {

	private Response response;
	private ResultsEpisode result;

	@Given("Open the end point {string} with the valid {string} equal {string} and {string} equal {string}.")
	public void openEndPoint(String endPoint, String name, String nameValue, String episode, String episodeValue) {

		response = methodGETwithTwoQueryParam(endPoint, name, nameValue, episode, episodeValue);
	}

	@When("Get the result with the name and episode.")
	public void getResult() {

		result = getBody(response, ResultsEpisode.class);
	}

	@Then("The name should be {string}, the episode should be {string}, the status code should be {int}, the content type should be {string}.")
	public void check(String nameEpisode, String numberEpisode, Integer statusCode, String contentType) {

		if (nameEpisode != "")
			for (Episode resultEpisode : result.getResults())
				assertThat(resultEpisode.getName().toLowerCase(), containsString(nameEpisode.toLowerCase()));

		if (numberEpisode != "")
			for (Episode resultEpisode : result.getResults())
				assertThat(resultEpisode.getEpisode().toLowerCase(), containsString(numberEpisode.toLowerCase()));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
