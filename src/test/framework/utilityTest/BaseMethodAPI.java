package utilityTest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseMethodAPI {

	public static void checkStatusCodeAndContentType(Response response, Integer statusCode, String contentType) {
		response.then().statusCode(statusCode).contentType(contentType);
	}

	public static <T> T getBody(Response response, Class<T> classBody) {
		return response.getBody().as(classBody);
	}

	private static RequestSpecification given() {
		return RestAssured.given()
				.filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")
						.setResponseTemplate("http-response.ftl"));
	}

	public static Response methodGET() {
		return given().get();
	}

	public static Response methodGET(String endPoint) {
		return given().get(endPoint);
	}

	public static Response methodGETwithPathParam(String endPoint, Object param) {
		return given().pathParam("param", param).get(endPoint + "/{param}");
	}

	private static RequestSpecification queryParam(String paramName, Object paramValue) {
		return given().queryParam(paramName, paramValue);
	}

	public static Response methodGETwithOneQueryParam(String endPoint, String paramName, Object paramValue) {
		return queryParam(paramName, paramValue).get(endPoint);
	}

	public static Response methodGETwithTwoQueryParam(String endPoint, String paramNameOne, Object paramValueOne,
			String paramNameTwo, Object paramValueTwo) {
		return queryParam(paramNameOne, paramValueOne).queryParam(paramNameTwo, paramValueTwo).get(endPoint);
	}

	public static Response methodGETwithThreeQueryParam(String endPoint, String paramNameOne, Object paramValueOne,
			String paramNameTwo, Object paramValueTwo, String paramNameThree, Object paramValueThree) {
		return queryParam(paramNameOne, paramValueOne).queryParam(paramNameTwo, paramValueTwo)
				.queryParam(paramNameThree, paramValueThree).get(endPoint);
	}

	public static Response methodGETwithFourQueryParam(String endPoint, String paramNameOne, Object paramValueOne,
			String paramNameTwo, Object paramValueTwo, String paramNameThree, Object paramValueThree,
			String paramNameFour, Object paramValueFour) {
		return queryParam(paramNameOne, paramValueOne).queryParam(paramNameTwo, paramValueTwo)
				.queryParam(paramNameThree, paramValueThree).queryParam(paramNameFour, paramValueFour).get(endPoint);
	}

	public static Response methodGETwithFiveQueryParam(String endPoint, String paramNameOne, Object paramValueOne,
			String paramNameTwo, Object paramValueTwo, String paramNameThree, Object paramValueThree,
			String paramNameFour, Object paramValueFour, String paramNameFive, Object paramValueFive) {
		return queryParam(paramNameOne, paramValueOne).queryParam(paramNameTwo, paramValueTwo)
				.queryParam(paramNameThree, paramValueThree).queryParam(paramNameFour, paramValueFour)
				.queryParam(paramNameFive, paramValueFive).get(endPoint);
	}

}
