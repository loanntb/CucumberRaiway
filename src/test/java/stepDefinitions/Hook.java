package stepDefinitions;

import common.Constant;
import helper.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void setupBrowser(){
        DriverHelper.startBrowser(DriverHelper.DriverType.CHROME);
        DriverHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @After(order = 1)
    public void closeBrowser() {
        DriverHelper.closeWebDriver();
    }

    @After(order = 0)
    public void cleanUpAll() {
        DriverHelper.quitWebDriver();
    }

}
