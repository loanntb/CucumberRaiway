package pageobjects;

import helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //Locators
    private final By EMAIL_TEXTBOX = By.id("username");
    private final By PASSWORD_TEXTBOX = By.id("password");
    private final By LOGIN_BUTTON = By.cssSelector(".LoginForm input[title='Login']");
    private final By LOGOUT_TAB = By.xpath("//div[@id='menu']/ul//span[.='Log out']");
    private final By ERROR_MESSAGE_FORM = By.cssSelector("#content .message");

    //Element
    private WebElement getLoginButton() {
        return Driver.getWebDriver().findElement(LOGIN_BUTTON);
    }

    private WebElement getEmail() {
        return Driver.getWebDriver().findElement(EMAIL_TEXTBOX);
    }

    private WebElement getPassword() {
        return Driver.getWebDriver().findElement(PASSWORD_TEXTBOX);
    }

    private WebElement getERROR_MESSAGE_FORM() {
        return Driver.getWebDriver().findElement(ERROR_MESSAGE_FORM);
    }

    private WebElement getLOGOUT_TAB() {
        return Driver.getWebDriver().findElement(LOGOUT_TAB);
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
        return getText(getERROR_MESSAGE_FORM());
    }

    /***
     * Check ChangePassword is displayed once user logged in
     * @return
     */
    public Boolean isLogoutTabDisplayed() {
        try {
            return getLOGOUT_TAB().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
