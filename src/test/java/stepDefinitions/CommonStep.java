package stepDefinitions;

import common.Constant;
import helper.DriverHelper;
import io.cucumber.java8.En;
import pageObjects.BasePage;

public class CommonStep extends BasePage implements En {
    public CommonStep() {
        Given("^I navigate to Raiway website$", () -> {
            DriverHelper.navigateToUrl(Constant.RAILWAY_URL);
        });
        When("^I click on \"([^\"]*)\" tab$", this::clickOnMenuTab);
    }
}
