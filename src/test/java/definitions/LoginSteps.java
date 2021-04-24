package definitions;

import utilities.Log;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;
import pages.LoginPage;
import utilities.*;

import java.util.List;
import java.util.Map;

public class LoginSteps implements En {
    private LoginPage loginPage = new LoginPage();

    public LoginSteps() {
        When("I click on {string} tab", (String nameTab) -> {
            loginPage.selectOnTab(nameTab);
        });

        When("I Login with username {string} and password {string}", (String username, String password) -> {
            Log.info("Login with username" + username + " and password" + password);
            loginPage.login(username, password);
        });

        When("I Login with username {string} and a wrong password {string}", (String username, String password) -> {
            loginPage.login(username, password);
        });

        When("Login with username {string} and password {string}", (String username, String password) -> {
            loginPage.login(username, password);
        });

        When("I click on the hyperlink text {string}", (String linkPage) -> {
            loginPage.clickHyperLinkText(linkPage);
        });

        Then("{string} tab is displayed on the Login Page", (String title) -> {
            loginPage.getWelcomePageTitle();
        });

        Then("The error message {string} is displayed on the screen", (String errorMessage) -> {
            Assert.assertEquals(loginPage.getErrorMessageFormLbl(), errorMessage, "Error message form");
        });

        Then("The system displays the messages below", (DataTable dt) -> {
            List<Map<String, String>> list = dt.asMaps(String.class, String.class);
            for (Map<String, String> fieldMap : list) {
                String formMessage = fieldMap.get("Form Message");
                String userMessage = fieldMap.get("User Message");
                String passwordMessage = fieldMap.get("Password Message");
                Assert.assertEquals(loginPage.getErrorMessageFormLbl(), formMessage, "Error message form");
                Assert.assertEquals(loginPage.getErrorMessageLbl("username"), userMessage, "Invalid username");
                Assert.assertEquals(loginPage.getErrorMessageLbl("password"), passwordMessage, "Invalid password");
            }
        });

        Then("I should be on the REGISTER page", () -> {
            Assert.assertEquals(loginPage.getURLPage("register"), Constant.REGISTER_URL, "Actual URL is not same expected url");
        });
    }
}
