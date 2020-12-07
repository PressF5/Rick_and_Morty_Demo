package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/results", 
				 glue = { "results", "utilityTest" }, 
				 monochrome = true,
				 snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerResult extends TestNGCucumber {
}
