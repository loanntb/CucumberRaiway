package stepDefinitions;

import common.Constant;
import helper.DriverHelper;
import io.cucumber.java.After;

public class Hook extends DriverHelper {
    @After
    public void closeBrowser() {
        DriverHelper.closeWebDriver();
    }

    @After
    public void cleanUpAll() {
        DriverHelper.quitWebDriver();
    }

}
