package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BasePage {
    private String menuTab = "//div[@id='menu']//ul/li/a/span[contains(text(), '%s')]";
    private String errorMessage = "//div[@id='content']/form//ol/li[@class='%s']/label[@class='validation-error']";
    private final static By errorMessageForm = By.cssSelector("#content .message");
    private String pageLink = "//div[@id='content']/ul//li/a[contains(text(),'%s')]";

    private WebElement getMenuTab(String text) {
        return DriverManager.getWebDriver().findElement(By.xpath(String.format(menuTab, text)));
    }

    private WebElement getErrorMessage(String text) {
        return DriverManager.getWebDriver().findElement(By.xpath(String.format(errorMessage, text)));
    }

    private WebElement getPageLink(String text) {
        return DriverManager.getWebDriver().findElement(By.xpath(String.format(pageLink, text)));
    }

    private WebElement getErrorMessageForm() {
        return DriverManager.getWebDriver().findElement(errorMessageForm);
    }

    /***
     * Choose Menu
     * @param text
     */
    public void clickOnMenuTab(String text) {
        getMenuTab(text).click();
    }

    public void clickOnPageLink(String text) {
        getPageLink(text).click();
    }

    public String errorMessages(String text) {
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

    public String errorFormMessage() {
        return getText(getErrorMessageForm());
    }

    /***
     * Check Logout is displayed once user logged in
     * @return
     */
    public Boolean isMenuTabDisplayed(String text) {
        try {
            return getMenuTab(text).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
