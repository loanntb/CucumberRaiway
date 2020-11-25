package testrunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepDefinitions",
        features = {"src/test/java/features"}
)

public class RunnerTest extends AbstractTestNGCucumberTests{

}
