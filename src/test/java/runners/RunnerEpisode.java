package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/episode", 
				 glue = { "episode", "utilityTest" }, 
				 monochrome = true, 
				 snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerEpisode extends TestNGCucumber {
}
