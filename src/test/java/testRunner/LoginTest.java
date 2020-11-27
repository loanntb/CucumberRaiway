package testRunner;

import base.BaseTest;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/Login.feature"},
        glue = {"stepDefinitions"}
)
public class LoginTest extends BaseTest {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
