package stepdefinitions;

import utilities.Log;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;
import pageobjects.RegisterPage;

import java.util.List;
import java.util.Map;

public class RegisterSteps implements En {
    private RegisterPage registerPage = new RegisterPage();
    private String email, password, confirmPassword, pid;

    public RegisterSteps() {

        When("^I register a new account form with the following data below$", (DataTable dt) -> {
            List<Map<String, String>> list = dt.asMaps(String.class, String.class);
            for (Map<String, String> fieldMap : list) {
                email = fieldMap.get("email");
                password = fieldMap.get("password");
                confirmPassword = fieldMap.get("confirmPassword");
                pid = fieldMap.get("pid");
                registerPage.register(email, password, confirmPassword, pid);
            }


        });

        Then("The information register successfully {string} message is displayed on the screen", (String message) -> {
            Log.info("Check info message");
            Assert.assertEquals(registerPage.infoSuccessfulMessage(), message, "User sign up Success");
        });


    }

}
