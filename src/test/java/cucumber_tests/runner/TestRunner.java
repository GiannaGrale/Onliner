package cucumber_tests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/***
 * TestRunner is used to build a communication between feature files and stepDefinition files
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber_tests",
        tags = "@Smoke")
public class TestRunner extends AbstractTestNGCucumberTests {
}
