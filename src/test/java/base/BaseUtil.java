package base;

import helper.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BaseUtil extends AbstractTestNGCucumberTests {
    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
        if (CHROME.equals(browser)) {
            Driver.startBrowser(Driver.DriverType.CHROME);
        } else if (FIREFOX.equals(browser)) {
            Driver.startBrowser(Driver.DriverType.FIREFOX);
        } else {
            Driver.startBrowser(Driver.DriverType.EDGE);
        }
    }
    public ExtentReports extent;

    public static ExtentTest scenarioDef;

    public static ExtentTest features;

    public static String reportLocation = "";
}
