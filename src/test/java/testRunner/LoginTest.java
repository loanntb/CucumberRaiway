package testRunner;

import base.BaseTest;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/java/features/Login.feature"},
        glue = {"stepDefinitions"}
)
public class LoginTest extends BaseTest {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
