package testrunner;

import base.BaseUtil;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/Register.feature"},
        glue = {"stepdefinitions", "stepconfig"}
)
public class RegisterTest extends BaseUtil {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
