package pages;

import controls.Button;
import controls.Label;
import controls.TextBox;
import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.DriverManager.scrollToPageView;

public class RegisterPage extends BasePage {
    private final TextBox emailTxt = new TextBox("id=email");
    private final TextBox passwordTxt = new TextBox("id=password");
    private final TextBox confirmPasswordTxt = new TextBox("id=confirmPassword");
    private final TextBox pidTxt = new TextBox("id=pid");
    private final Button registerBtn = new Button("css=.form-actions input");
    private final Label infoMessageLbl = new Label("css=#content h1");
    private final Label errorMessageLbl = new Label("css=#content p");
    private final Label errorFormMessageLbl = new Label("css=#content .message");

    public void fillRegisterForm(String email, String password, String confirmPassword, String pid) {
        emailTxt.enter(email);
        passwordTxt.enter(password);
        confirmPasswordTxt.enter(confirmPassword);
        pidTxt.enter(pid);
    }

    //Register with your email, password and PID
    public void register(String email, String password, String confirmPassword, String pid) {
        fillRegisterForm(email, password, confirmPassword, pid);
        scrollToPageView();
        registerBtn.click();
    }

    public String errorFormMessage() {
        return errorFormMessageLbl.getText();
    }

    public String infoSuccessfulMessage() {
        return infoMessageLbl.getText();
    }

}
