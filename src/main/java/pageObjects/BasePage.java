package pageObjects;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private String menuTab = "//div[@id='menu']//ul/li/a/span[contains(text(), '%s')]";

    private WebElement getMenuTab(String text) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuTab, text)));
    }

    /***
     * Choose Menu
     * @param text
     */
    public void clickOnMenuTab(String text){
        getMenuTab(text).click();
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
