package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;
import pages.RegisterPage;

import java.util.List;
import java.util.Map;

public class RegisterSteps implements En {
    private RegisterPage registerPage = new RegisterPage();
    private String email, password, confirmPassword, pid;

    public RegisterSteps() {
        When("I register a new account form with the following data below", (DataTable dt) -> {
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
            Assert.assertEquals(registerPage.infoSuccessfulMessage(), message, "User sign up Success");
        });
        Then("The error message  {string} is displayed on the screen", (String message) -> {
            Assert.assertEquals(registerPage.errorFormMessage(), message, "User cannot register new account");
        });
        And("I register a create new account using Email that has been registered", (DataTable dt) -> {
            List<Map<String, String>> list = dt.asMaps(String.class, String.class);
            for (Map<String, String> fieldMap : list) {
                email = fieldMap.get("email");
                password = fieldMap.get("password");
                confirmPassword = fieldMap.get("confirmPassword");
                pid = fieldMap.get("pid");
                registerPage.register(email, password, confirmPassword, pid);
            }
        });
    }

}
