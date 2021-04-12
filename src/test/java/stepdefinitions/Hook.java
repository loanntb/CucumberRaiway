package stepdefinitions;

import drivers.DriverManager;
import io.cucumber.java.After;

public class Hook extends DriverManager {
    @After
    public void cleanUpAll() {
        DriverManager.quitWebDriver();
    }
}
