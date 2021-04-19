package testrunner;

import base.BaseTest;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/BookTicket.feature"},
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class BookTicketTest extends BaseTest {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
