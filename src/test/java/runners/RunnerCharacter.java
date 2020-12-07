package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/character", 
				 glue = { "character", "utilityTest" }, 
				 monochrome = true, 
				 snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerCharacter extends TestNGCucumber {
}
