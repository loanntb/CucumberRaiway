package pageobjects;

import helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //Locators
    private final By emailTXT = By.id("username");
    private final By passwordTXT = By.id("password");
    private final By loginButton = By.cssSelector(".LoginForm input[title='Login']");
    private final By logoutTab = By.xpath("//div[@id='menu']/ul//span[.='Log out']");
    private final By errorMessageForm = By.cssSelector("#content .message");

    //Element
    private WebElement getLoginButton() {
        return Driver.getWebDriver().findElement(loginButton);
    }

    private WebElement getEmail() {
        return Driver.getWebDriver().findElement(emailTXT);
    }

    private WebElement getPassword() {
        return Driver.getWebDriver().findElement(passwordTXT);
    }

    private WebElement getErrorMessageForm() {
        return Driver.getWebDriver().findElement(errorMessageForm);
    }

    private WebElement getLogoutTab() {
        return Driver.getWebDriver().findElement(logoutTab);
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

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public String errorFormMessage() {
        return getText(getErrorMessageForm());
    }

    /***
     * Check ChangePassword is displayed once user logged in
     * @return
     */
    public Boolean isLogoutTabDisplayed() {
        try {
            return getLogoutTab().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
