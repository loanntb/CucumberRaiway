package stepdefinitions;

import utilities.Log;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;
import pageobjects.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginSteps implements En {
    private LoginPage loginPage = new LoginPage();

    public LoginSteps() {
        When("I Login with username {string} and password {string}", (String username, String password) -> {
            Log.info("Login with username" + username + " and password" + password);
            loginPage.login(username, password);
        });
        Then("Logout tab is displayed on the menu tab", () -> {
            Log.info("Check Logout Tab Displayed tab is displayed.");
            Assert.assertTrue(loginPage.isLogoutTabDisplayed());
        });

        When("I Login with username {string} and a wrong password {string}", (String username, String password) -> {
            loginPage.login(username, password);
        });
        Then("The error message {string} is displayed on the screen", (String errorMessage) -> {
            Log.info("Check error messages");
            Assert.assertEquals(loginPage.errorFormMessage(), errorMessage, "Error message form");
        });

        When("Login with username {string} and password {string}", (String username, String password) -> {
            loginPage.login(username, password);
        });

        Then("^The system displays the messages below$", (DataTable dt) -> {
            String formMessage, userMessage, passwordMessage;
            List<Map<String, String>> list = dt.asMaps(String.class, String.class);
            for (Map<String, String> fieldMap : list) {
                formMessage = fieldMap.get("formMessage");
                userMessage = fieldMap.get("usernameMessage");
                passwordMessage = fieldMap.get("passwordMessage");
                Log.info("Check error messages");
                Assert.assertEquals(loginPage.errorFormMessage(), formMessage, "Error message form");

                Log.info("Check an error email message");
                Assert.assertEquals(loginPage.errorMessages("username"), userMessage, "Invalid username");

                Log.info("Check an error password message");
                Assert.assertEquals(loginPage.errorMessages("password"), passwordMessage, "Invalid password");
            }
        });

    }
}
