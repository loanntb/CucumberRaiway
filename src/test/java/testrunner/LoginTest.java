package testrunner;

import base.BaseUtil;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/Login.feature"},
        glue = {"stepdefinitions"},
        plugin = {
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "progress",
                "summary"
        }
)
public class LoginTest extends BaseUtil {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
