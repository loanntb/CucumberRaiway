package stepDefinitions;

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

        When("^Enter the Username \"([^\"]*)\" and Password \"([^\"]*)\"$", (String username, String password) -> {
            Log.info("Fill Login form");
            loginPage.login(username, password);
        });

        Then("^Login successfully$", () -> {
            Log.info("Check Logout Tab Displayed tab is displayed.");
            Assert.assertTrue(loginPage.isLogoutTabDisplayed());
        });


        Log.info("Login with a username and an invalid password");
        When("^Open Login tab$", () -> {
            Log.info("Click on Login tab");
            loginPage.clickOnMenuTab(Constant.LOGIN);
        });
        When("^Enter the Username \"([^\"]*)\" and an invalid Password \"([^\"]*)\"$", (String username, String password) -> {
            Log.info("Fill Login form");
            loginPage.login(username, password);
        });
        Then("^User gets login failed error message$", () -> {
            Log.info("Check error messages");
            Assert.assertEquals(loginPage.errorFormMessage(), "Invalid username or password. Please try again.");
        });


    }

}
