package stepDefinitions;

import common.Constant;
import helper.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.Parameters;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class Hook extends DriverHelper {
    @Before
    public void setUpBrowser() {
        startBrowser(DriverType.CHROME);
        navigateToUrl(Constant.RAILWAY_URL);
    }
   // @Parameters("browser")
//    public void setUpBrowser(String browser) {
//        if (CHROME.equals(browser)) {
//            startBrowser(DriverType.CHROME);
//            navigateToUrl(Constant.RAILWAY_URL);
//        } else if (FIREFOX.equals(browser)) {
//            startBrowser(DriverType.FIREFOX);
//            navigateToUrl(Constant.RAILWAY_URL);
//        } else {
//            startBrowser(DriverType.EDGE);
//            navigateToUrl(Constant.RAILWAY_URL);
//        }
//    }

    @After(order = 1)
    public void closeBrowser() {
        DriverHelper.closeWebDriver();
    }

    @After(order = 0)
    public void cleanUpAll() {
        DriverHelper.quitWebDriver();
    }

}
