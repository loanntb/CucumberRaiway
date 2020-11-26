package stepDefinitions;

import helper.DriverHelper;
import io.cucumber.java.After;

public class Hook extends DriverHelper {
//    @Before
//    public void setUpBrowser() {
//        DriverHelper.startBrowser(DriverHelper.DriverType.CHROME);
//        DriverHelper.navigateToUrl(Constant.RAILWAY_URL);
//
//    }

    @After
    public void cleanUpAll() {
        DriverHelper.quitWebDriver();
    }

}
