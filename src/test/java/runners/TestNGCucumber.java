package runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestNGCucumber extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@AfterSuite
	public void afterSuite(ITestContext context) {

		File listAllureResults = new File("target/allure-results");

		for (File fileEntry : listAllureResults.listFiles())

			if (fileEntry.getName().endsWith("-result.json")) {

				File fileResult = new File(listAllureResults.getPath() + File.separator + fileEntry.getName());

				try {
					FileReader fileRead = new FileReader(fileResult);
					Reader read = new BufferedReader(fileRead);

					Gson gson = new Gson();

					JsonElement jElemont = gson.fromJson(read, JsonElement.class);
					JsonObject jObject = jElemont.getAsJsonObject();

					JsonElement arrayLabels = jObject.get("labels");
					JsonArray array = arrayLabels.getAsJsonArray();

					for (int i = 0; i < array.size(); i++) {
						if ("parentSuite".equals(array.get(i).getAsJsonObject().get("name").getAsString())
								&& context.getCurrentXmlTest().getSuite().getName()
										.equals(array.get(i).getAsJsonObject().get("value").getAsString())) {
							fileRead.close();
							read.close();

							fileResult.delete();
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
	}

}
