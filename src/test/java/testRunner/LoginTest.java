package testRunner;

import base.BaseTest;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/java/features/Login.feature"},
        glue = {"stepDefinitions"}
)
public class LoginTest extends BaseTest {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
