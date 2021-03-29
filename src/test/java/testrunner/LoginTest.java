package testrunner;

import base.BaseUtil;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/Login.feature"},
        glue = {"stepdefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports" }
)
public class LoginTest extends BaseUtil {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
