package testrunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepDefinitions",
        features = {"src/test/java/features/Login.feature"}
)

public class RunnerTest {

}
