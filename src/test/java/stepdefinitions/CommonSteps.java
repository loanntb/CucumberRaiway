package stepdefinitions;

import utilities.Constant;
import drivers.DriverManager;
import io.cucumber.java8.En;
import pages.BasePage;

public class CommonSteps extends BasePage implements En {
    public CommonSteps() {
        Given("I navigate to Raiway website", () -> {
            DriverManager.navigateToUrl(Constant.RAILWAY_URL);
        });
        When("I click on {string} tab", this::clickOnMenuTab);
    }
}
