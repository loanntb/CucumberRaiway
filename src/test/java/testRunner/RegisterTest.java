package testRunner;

import base.BaseTest;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/Register.feature"},
        glue = {"stepDefinitions", "stepConfig"}
)
public class RegisterTest extends BaseTest {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
