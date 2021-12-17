package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/***
 * TestRunner is used to build a communication between feature files and stepDefinition files
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber",
        tags = "not @Ignore")
public class TestRunner extends AbstractTestNGCucumberTests {
}
