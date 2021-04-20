package definitions;

import drivers.DriverManager;
import io.cucumber.java8.En;
import utilities.Constant;

public class CommonSteps implements En {
    public CommonSteps() {
        Given("I navigate to Raiway website", () -> {
            DriverManager.navigateToUrl(Constant.RAILWAY_URL);
        });
    }
}
