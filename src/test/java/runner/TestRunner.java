package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions"},
        plugin = {"pretty",
                "summary",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"},
        monochrome = false
)
public class TestRunner {
}