package pageObjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    //Locators
    private By emailID = By.id("username");
    private By passwordID = By.id("password");
    private By loginButton = By.cssSelector(".LoginForm input[title='Login']");
    private By logOutTab = By.xpath("//div[@id='menu']/ul//span[.='Log out']");
    private By errorFormMessage = By.cssSelector("#content .message");
    private String errorMessage = "//div[@id='content']/form//ol/li[@class='%s']/label[@class='validation-error']";

    //Element
    private WebElement getLoginButton() {
        return DriverHelper.getWebDriver().findElement(loginButton);
    }
    private WebElement getEmail(){
        return DriverHelper.getWebDriver().findElement(emailID);
    }
    private WebElement getPassword(){
        return DriverHelper.getWebDriver().findElement(passwordID);
    }
    private WebElement getErrorFormMessage() {
        return DriverHelper.getWebDriver().findElement(errorFormMessage);
    }
    private WebElement getLogOutTab() {
        return DriverHelper.getWebDriver().findElement(logOutTab);
    }
    private void enterEmail(String email) {
        getEmail().sendKeys(email);
    }
    private void enterPassword(String password) {
        getPassword().sendKeys(password);
    }

    //Method
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void clickLoginButton()
    {
        getLoginButton().click();
    }

    public String errorFormMessage() {
        return getText(DriverHelper.getWebDriver().findElement(errorFormMessage));
    }

    /***
     * Check ChangePassword is displayed once user logged in
     * @return
     */
    public Boolean isLogoutTabDisplayed() {
        try {
            return getLogOutTab().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
