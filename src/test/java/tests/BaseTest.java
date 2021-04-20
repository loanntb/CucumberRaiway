package tests;

import drivers.DriverManager;
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
            DriverManager.startBrowser(DriverManager.DriverType.CHROME);
        } else if (FIREFOX.equals(browser)) {
            DriverManager.startBrowser(DriverManager.DriverType.FIREFOX);
        } else {
            DriverManager.startBrowser(DriverManager.DriverType.EDGE);
        }
    }
}