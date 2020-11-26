package base;

import common.Constant;
import helper.DriverHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BaseTest extends AbstractTestNGCucumberTests {
    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
        if (CHROME.equals(browser)) {
            DriverHelper.startBrowser(DriverHelper.DriverType.CHROME);
            DriverHelper.navigateToUrl(Constant.RAILWAY_URL);
        } else if (FIREFOX.equals(browser)) {
            DriverHelper.startBrowser(DriverHelper.DriverType.FIREFOX);
            DriverHelper.navigateToUrl(Constant.RAILWAY_URL);
        } else {
            DriverHelper.startBrowser(DriverHelper.DriverType.EDGE);
            DriverHelper.navigateToUrl(Constant.RAILWAY_URL);
        }
    }
}
