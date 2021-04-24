package pages;

import controls.Button;
import controls.Label;
import controls.TextBox;

public class LoginPage extends BasePage {
    private final TextBox emailTxt = new TextBox("id=username");
    private final TextBox passwordTxt = new TextBox("id=password");
    private final Button loginBtn = new Button("css=.form-actions input");
    private final Label welcomeTitleLbl = new Label("css=#content h1");
    private final Label errorMessageLbl = new Label("//div[@id='content']/form//ol/li[@class='%s']/label[@class='validation-error']");
    private final Label errorMessageFormLbl = new Label("css=#content .message");

    public void login(String email, String password) {
        emailTxt.clear();
        emailTxt.enter(email);
        passwordTxt.clear();
        passwordTxt.enter(password);
        loginBtn.click();
    }

    public String getWelcomePageTitle() {
        return welcomeTitleLbl.getText();
    }

    public String getErrorMessageLbl(String pathMessage) {
        errorMessageLbl.setDynamicValue(pathMessage);
        return errorMessageLbl.getText();
    }

    public String getErrorMessageFormLbl() {
        return errorMessageFormLbl.getText();
    }
}
