package character;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utilityTest.BaseMethodAPI.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import results.ResultsCharacter;

public class PositiveCharacterModelNameStatusSpeciesTypeGender {

	private Response response;
	private ResultsCharacter result;

	@Given("Open the end point {string} with the valid {string} equal {string}, {string} equal {string}, {string} equal {string}, {string} equal {string}, {string} equal {string}.")
	public void openEndPoint(String endPoint, String name, String nameValue, String status, String statusValue,
			String species, String speciesValue, String type, String typeValue, String gender, String genderValue) {

		response = methodGETwithFiveQueryParam(endPoint, name, nameValue, status, statusValue, species, speciesValue,
				type, typeValue, gender, genderValue);
	}

	@When("Get the result with the name, status, species, type, gender.")
	public void getResult() {

		result = getBody(response, ResultsCharacter.class);
	}

	@Then("The name should be {string}, the status should be {string}, the species should be {string}, the type should be {string}, the gender should be {string}, the status code should be {int}, the content type should be {string}.")
	public void check(String nameCharacter, String statusCharacter, String speciesCharacter, String typeCharacter,
			String genderCharacter, Integer statusCode, String contentType) {

		if (nameCharacter != "")
			for (Character resultCharacter : result.getResults())
				assertThat(resultCharacter.getName().toLowerCase(), containsString(nameCharacter.toLowerCase()));

		if (statusCharacter != "")
			for (Character resultCharacter : result.getResults())
				assertThat(resultCharacter.getStatus().toLowerCase(), containsString(statusCharacter.toLowerCase()));

		if (speciesCharacter != "")
			for (Character resultCharacter : result.getResults())
				assertThat(resultCharacter.getSpecies().toLowerCase(), containsString(speciesCharacter.toLowerCase()));

		if (typeCharacter != "")
			for (Character resultCharacter : result.getResults())
				assertThat(resultCharacter.getType().toLowerCase(), containsString(typeCharacter.toLowerCase()));

		if (genderCharacter != "")
			for (Character resultCharacter : result.getResults())
				assertThat(resultCharacter.getGender().toLowerCase(), containsString(genderCharacter.toLowerCase()));

		checkStatusCodeAndContentType(response, statusCode, contentType);
	}
}
