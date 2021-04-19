package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //Locators
    private static final By emailTXT = By.id("username");
    private static final By passwordTXT = By.id("password");
    private static final By loginButton = By.cssSelector(".LoginForm input[title='Login']");
    private static final By logoutTab = By.xpath("//div[@id='menu']/ul//span[.='Log out']");


    //Element
    private WebElement getLoginButton() {
        return DriverManager.getWebDriver().findElement(loginButton);
    }

    private WebElement getEmail() {
        return DriverManager.getWebDriver().findElement(emailTXT);
    }

    private WebElement getPassword() {
        return DriverManager.getWebDriver().findElement(passwordTXT);
    }

    private WebElement getLogoutTab() {
        return DriverManager.getWebDriver().findElement(logoutTab);
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

    /***
     * Check Logout is displayed once user logged in
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
