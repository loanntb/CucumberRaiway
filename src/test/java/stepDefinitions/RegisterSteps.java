package stepDefinitions;

import common.Constant;
import common.Log;
import io.cucumber.java8.En;
import org.testng.Assert;
import pageObjects.RegisterPage;

public class RegisterSteps implements En {
    private RegisterPage registerPage = new RegisterPage();

    public RegisterSteps(){
        Log.info("Verify user can register with valid data");
        When("^Click on register tab$", () -> {
            Log.info("Click register tab");
            registerPage.clickOnMenuTab(Constant.REGISTER);
        });

        When("^Register the Email \"([^\"]*)\"  Password \"([^\"]*)\"  Confirm Password \"([^\"]*)\" PID \"([^\"]*)\"$", (String email, String password, String confirmPassword, String pid) -> {
            Log.info("Register account with username" + email + " password " + password + " and pid" + pid);
            registerPage.register(email,password,confirmPassword,pid);
        });

        Then("^Getting an information register successfully message$", () -> {
            Log.info("Check info message");
            Assert.assertEquals(registerPage.infoSuccessfulMessage(), "Registration Confirmed! You can now log in to the site.","User sign up Success");
        });
    }
}
