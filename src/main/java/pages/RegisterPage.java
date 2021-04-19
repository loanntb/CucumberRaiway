package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.DriverManager.scrollToPageView;

public class RegisterPage extends BasePage {
    //Locators
    private static final By emailTXT = By.id("email");
    private static final By passwordTXT = By.id("password");
    private static final By confirmPasswordTXT = By.id("confirmPassword");
    private static final By pidTXT = By.id("pid");
    private static final By registerButton = By.cssSelector("#RegisterForm .form-actions input[title='Register']");
    private static final By infoMessageLabel = By.cssSelector("#content p");
    private static final By errorFormMessageLabel = By.cssSelector("#content .message");

    //Element

    private WebElement getRegisterButton() {
        return DriverManager.getWebDriver().findElement(registerButton);
    }

    private WebElement getEmail() {
        return DriverManager.getWebDriver().findElement(emailTXT);
    }

    private WebElement getPassword() {
        return DriverManager.getWebDriver().findElement(passwordTXT);
    }

    private WebElement getConfirmPassword() {
        return DriverManager.getWebDriver().findElement(confirmPasswordTXT);
    }

    private WebElement getPID() {
        return DriverManager.getWebDriver().findElement(pidTXT);
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
        return getText(DriverManager.getWebDriver().findElement(errorFormMessageLabel));
    }

    public String infoSuccessfulMessage() {
        return getText(DriverManager.getWebDriver().findElement(infoMessageLabel));
    }

}
