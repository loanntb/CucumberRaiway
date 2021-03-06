package tests;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/Register.feature"},
        glue = {"definitions", "stepconfig"},
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class RegisterTest extends BaseTest {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
