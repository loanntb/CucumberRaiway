package stepDefinitions;

import base.BaseTest;
import common.Constant;
import common.Log;
import io.cucumber.java8.En;
import org.testng.Assert;
import pageObjects.LoginPage;

public class LoginSteps implements En  {
    private LoginPage loginPage = new LoginPage();

    public LoginSteps() {
        Log.info("Login with valid username and password");
        When("^Click Login tab$", () -> {
            Log.info("Click on Login tab");
            loginPage.clickOnMenuTab(Constant.LOGIN);
        });

        When("^Login with Username \"([^\"]*)\" and Password \"([^\"]*)\"$", (String username, String password) -> {
            Log.info("Login with username" + username + " and password" +  password);
            loginPage.login(username, password);
        });

        Then("^Login successfully$", () -> {
            Log.info("Check Logout Tab Displayed tab is displayed.");
            Assert.assertTrue(loginPage.isLogoutTabDisplayed());
        });


        Log.info("Login with a username and an invalid password");
        When("^Enter the Username \"([^\"]*)\" and an invalid Password \"([^\"]*)\"$", (String username, String password) -> {
            Log.info("Fill Login form");
            loginPage.login(username, password);
        });

        Then("^Getting login failed error message$", () -> {
            Log.info("Check error messages");
            Assert.assertEquals(loginPage.errorFormMessage(), "Invalid username or password. Please try again.", "Error message form");
        });

        Log.info("Login with all blank username and password");
        When("^Enter the empty Username \"([^\"]*)\" and empty Password \"([^\"]*)\"$", (String username, String password) -> {
            Log.info("Fill Login form");
            loginPage.login(username, password);
        });
        Then("^Getting login failed error messages$", () -> {
            Log.info("Check error messages");
            Assert.assertEquals(loginPage.errorFormMessage(), "There was a problem with your login and/or errors exist in your form.","Error message form");

            Log.info("Check an error email message");
            Assert.assertEquals(loginPage.errorMessages("username"), "You must specify a username.", "Invalid username");

            Log.info("Check an error password message");
            Assert.assertEquals(loginPage.errorMessages("password"), "You must specify a password.", "Invalid password");
        });



    }

}
