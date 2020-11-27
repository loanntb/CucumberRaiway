package stepDefinitions;

import common.Log;
import io.cucumber.java8.En;
import org.testng.Assert;
import pageObjects.LoginPage;

public class LoginSteps implements En {
    private LoginPage loginPage = new LoginPage();

    public LoginSteps() {
        Log.info("Login with valid username and password");
        When("^I Login with username \"([^\"]*)\" and password \"([^\"]*)\"$", (String username, String password) -> {
            Log.info("Login with username" + username + " and password" + password);
            loginPage.login(username, password);
        });
        Then("^Logout tab is displayed on the menu tab$", () -> {
            Log.info("Check Logout Tab Displayed tab is displayed.");
            Assert.assertTrue(loginPage.isLogoutTabDisplayed());
        });

        Log.info("Login with a username and a  wrong password");
        When("^I Login with username \"([^\"]*)\" and a wrong password \"([^\"]*)\"$", (String username, String password) -> {
            loginPage.login(username, password);
        });
        Then("^The error message \"([^\"]*)\" is displayed on the screen$", (String errorMessage) -> {
            Log.info("Check error messages");
            Assert.assertEquals(loginPage.errorFormMessage(), errorMessage, "Error message form");
        });

        Log.info("Login with all blank username and password");
        When("^Login with username \"([^\"]*)\" and password \"([^\"]*)\"$", (String username, String password) -> {
            loginPage.login(username, password);
        });
        Then("^The error messages \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" are displayed on the screen$", (String formMessage, String usernameMessage, String passwordMessage) -> {
            Log.info("Check error messages");
            Assert.assertEquals(loginPage.errorFormMessage(), formMessage, "Error message form");

            Log.info("Check an error email message");
            Assert.assertEquals(loginPage.errorMessages("username"), usernameMessage, "Invalid username");

            Log.info("Check an error password message");
            Assert.assertEquals(loginPage.errorMessages("password"), passwordMessage, "Invalid password");
        });

    }

}
