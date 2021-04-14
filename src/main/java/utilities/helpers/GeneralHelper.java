package utilities.helpers;

import drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class GeneralHelper extends DriverManager {
    public static byte[] getByteScreenshot() throws IOException {
        File src = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }
}
