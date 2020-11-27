package stepDefinitions;

import helper.DriverHelper;
import io.cucumber.java.After;

public class Hook extends DriverHelper {

    @After
    public void cleanUpAll() {
        DriverHelper.quitWebDriver();
    }

}
