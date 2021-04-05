package stepdefinitions;

import helper.Driver;
import io.cucumber.java.After;

public class Hook extends Driver {
    @After
    public void cleanUpAll() {
        Driver.quitWebDriver();
    }
}
