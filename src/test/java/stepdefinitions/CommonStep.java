package stepdefinitions;

import utilities.Constant;
import helper.Driver;
import io.cucumber.java8.En;
import pageobjects.BasePage;

public class CommonStep extends BasePage implements En {
    public CommonStep() {
        Given("I navigate to Raiway website", () -> {
            Driver.navigateToUrl(Constant.RAILWAY_URL);
        });
        When("I click on {string} tab", this::clickOnMenuTab);
    }
}
