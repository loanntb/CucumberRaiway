package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BookTicketPage extends BasePage {
    private static final String bookTicketDropdown = "//select[@name='%s']";
    private static final By infoMessageLbl = By.xpath("//h1[contains(text(),'successfully')]");
    private static final By pidLbl = By.xpath("//li[contains(text(),'ID')]//strong[2]");

    private WebElement getInfoMessageLbl() {
        return DriverManager.getWebDriver().findElement(infoMessageLbl);
    }

    private WebElement getPidLbl() {
        return DriverManager.getWebDriver().findElement(pidLbl);
    }

    private Select selectOption(String text) {
        return new Select(DriverManager.getWebDriver().findElement(By.xpath(String.format(bookTicketDropdown, text))));
    }

    public String getTextInfoMessageLbl() {
        return getText(getInfoMessageLbl());
    }

    public String getTextPid() {
        return getText(getPidLbl());
    }

    List<String> selectDropDownOptions(String Dropdown) {
        List<String> options = new ArrayList<String>();
        for (WebElement option : selectOption(Dropdown).getOptions()) {
            if (option.getAttribute("value") != "") options.add(getText(option));
            option.click();
        }
        return options;
    }
}
