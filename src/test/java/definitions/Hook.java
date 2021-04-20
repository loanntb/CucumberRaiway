package definitions;

import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.helpers.GeneralHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hook extends DriverManager {
    @After
    public void cleanUpAll() {
        DriverManager.quitWebDriver();
    }

    @AfterStep
    public void as(Scenario scenario) throws IOException, InterruptedException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        if (scenario.isFailed()) {
            //  screenshotName = scenario.getName() + "_" + screenshotName + dateName;
            scenario.attach(GeneralHelper.getByteScreenshot(), "image/png", "screenshotName");
        }
    }
}
