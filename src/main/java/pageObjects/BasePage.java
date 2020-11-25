package pageObjects;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private String menuTab = "//div[@id='menu']//ul/li/a/span[contains(text(), '%s')]";
    private String errorMessage = "//div[@id='content']/form//ol/li[@class='%s']/label[@class='validation-error']";

    private WebElement getMenuTab(String text) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuTab, text)));
    }

    private WebElement getErrorMessage(String text) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(errorMessage, text)));
    }

    /***
     * Choose Menu
     * @param text
     */
    public void clickOnMenuTab(String text){
        getMenuTab(text).click();
    }

    public String errorMessages(String text){
        return getText(getErrorMessage(text));
    }

    /***
     * Get text and trim space
     * @param element
     * @return
     */
    public String getText(WebElement element) {
        return element.getText().trim();
    }

}
