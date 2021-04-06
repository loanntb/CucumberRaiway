package pageobjects;

import helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.Driver.scrollToPageView;

public class RegisterPage extends BasePage {
    //Locators
    private final By emailTXT = By.id("email");
    private final By passwordTXT = By.id("password");
    private final By confirmPasswordTXT = By.id("confirmPassword");
    private final By pidTXT = By.id("pid");
    private final By registerButton = By.cssSelector("#RegisterForm .form-actions input[title='Register']");
    private final By infoMessageLabel = By.cssSelector("#content p");
    private final By errorFormMessageLabel = By.cssSelector("#content .message");

    //Element

    private WebElement getRegisterButton() {
        return Driver.getWebDriver().findElement(registerButton);
    }

    private WebElement getEmail() {
        return Driver.getWebDriver().findElement(emailTXT);
    }

    private WebElement getPassword() {
        return Driver.getWebDriver().findElement(passwordTXT);
    }

    private WebElement getConfirmPassword() {
        return Driver.getWebDriver().findElement(confirmPasswordTXT);
    }

    private WebElement getPID() {
        return Driver.getWebDriver().findElement(pidTXT);
    }

    //method
    public void fillRegisterForm(String email, String password, String confirmPassword, String pid) {
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getPID().sendKeys(pid);
    }

    //Register with your email, password and PID
    public void register(String email, String password, String confirmPassword, String pid) {
        fillRegisterForm(email, password, confirmPassword, pid);
        scrollToPageView();
        getRegisterButton().click();
    }

    public String errorFormMessage() {
        return getText(Driver.getWebDriver().findElement(errorFormMessageLabel));
    }

    public String infoSuccessfulMessage() {
        return getText(Driver.getWebDriver().findElement(infoMessageLabel));
    }

}
