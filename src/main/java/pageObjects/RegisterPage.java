package pageObjects;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.DriverHelper.scrollToPageView;

public class RegisterPage extends BasePage{
    //Locators
    private By emailID = By.id("email");
    private By passwordID = By.id("password");
    private By confirmPasswordID = By.id("confirmPassword");
    private By pidID = By.id("pid");
    private By registerButton = By.cssSelector("#RegisterForm .form-actions input[title='Register']");
    private By infoSuccessfulMessage = By.cssSelector("#content p");
    private By errorFormMessage = By.cssSelector("#content .message");

    //Element

    private WebElement getRegisterButton() {
        return DriverHelper.getWebDriver().findElement(registerButton);
    }

    private WebElement getEmail() {
       return DriverHelper.getWebDriver().findElement(emailID);
    }

    private WebElement getPassword() {
        return  DriverHelper.getWebDriver().findElement(passwordID);
    }

    private WebElement getConfirmPassword() {
        return DriverHelper.getWebDriver().findElement(confirmPasswordID);
    }

    private WebElement getPID() {
        return DriverHelper.getWebDriver().findElement(pidID);
    }

    //method
    public void fillRegisterForm(String email,String password, String confirmPassword, String pid){
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getPID().sendKeys(pid);
    }

    //Register with your email, password and PID
    public void register(String email,String password, String confirmPassword, String pid) {
        fillRegisterForm(email, password, confirmPassword, pid);
        scrollToPageView();
        getRegisterButton().click();
    }
    public String errorFormMessage() {
        return getText(DriverHelper.getWebDriver().findElement(errorFormMessage));
    }

    public String infoSuccessfulMessage() {
        return getText(DriverHelper.getWebDriver().findElement(infoSuccessfulMessage));
    }

}
