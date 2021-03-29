package pageobjects;

import helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.Driver.scrollToPageView;

public class RegisterPage extends BasePage {
    //Locators
    private final By EMAIL_TEXTBOX = By.id("email");
    private final By PASSSWORD_TEXTBOX = By.id("password");
    private final By CONFIRM_PASSWORD_TEXTBOX = By.id("confirmPassword");
    private final By PID_TEXTBOX = By.id("pid");
    private final By REGISTER_BUTTON = By.cssSelector("#RegisterForm .form-actions input[title='Register']");
    private final By INFO_SUCCESSFUL_MESSAGE_LABLE = By.cssSelector("#content p");
    private final By ERROR_FORM_MESSAGE = By.cssSelector("#content .message");

    //Element

    private WebElement getRegisterButton() {
        return Driver.getWebDriver().findElement(REGISTER_BUTTON);
    }

    private WebElement getEmail() {
        return Driver.getWebDriver().findElement(EMAIL_TEXTBOX);
    }

    private WebElement getPassword() {
        return Driver.getWebDriver().findElement(PASSSWORD_TEXTBOX);
    }

    private WebElement getConfirmPassword() {
        return Driver.getWebDriver().findElement(CONFIRM_PASSWORD_TEXTBOX);
    }

    private WebElement getPID() {
        return Driver.getWebDriver().findElement(PID_TEXTBOX);
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
        return getText(Driver.getWebDriver().findElement(ERROR_FORM_MESSAGE));
    }

    public String infoSuccessfulMessage() {
        return getText(Driver.getWebDriver().findElement(INFO_SUCCESSFUL_MESSAGE_LABLE));
    }

}
