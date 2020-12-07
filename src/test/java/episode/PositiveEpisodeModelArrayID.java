package episode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utilityTest.BaseMethodAPI.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class PositiveEpisodeModelArrayID {

	private Response response;
	private Episode[] result;

	@Given("Open the end point {string} with the valid array of id parameter {string}.")
	public void openEndPoint(String endPoint, String param) {

		response = methodGETwithPathParam(endPoint, param);
	}

	@When("Get the result with the array of id.")
	public void getResult() {

		result = getBody(response, Episode[].class);
	}

	@Then("The id should be the from the array of id, the status code should be {int}, the content type should be {string}.")
	public void check(Integer statusCode, String contentType, DataTable dataTable) {

		for (int i = 0; i < result.length; i++)
			assertThat(result[i].getId(), equalTo(Integer.parseInt(dataTable.asList().get(i))));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
