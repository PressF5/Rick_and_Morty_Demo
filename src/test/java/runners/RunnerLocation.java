package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/location", 
				 glue = { "location", "utilityTest" }, 
				 monochrome = true, 
				 snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerLocation extends TestNGCucumber {
}
