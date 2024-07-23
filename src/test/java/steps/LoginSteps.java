package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.LoginSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private  boolean ONtheLoge;
    private  boolean clickButton;
    private  boolean loginpass;

    LoginSource log=new LoginSource();



    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        ONtheLoge=true;

    }


    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        // Write code here that turns the phrase above into concrete actions

clickButton=true;
    }



    @Then("the user should see an error message indicating incorrect credentials")
    public void the_user_should_see_an_error_message_indicating_incorrect_credentials() {
     assertFalse(loginpass);

    }

    @When("the user leaves the username or password field empty")
    public void the_user_leaves_the_username_or_password_field_empty() {

      //  log.CheckLoginVaildinFile("mohammed",null);
      //  loginpass=log.getFoundaccount();

    }

    @Then("the user should see an error message indicating that all fields are required")
    public void the_user_should_see_an_error_message_indicating_that_all_fields_are_required() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(loginpass);
    }


    @When("the user enters valid username and password {string}+{string}")
    public void theUserEntersValidUsernameAndPassword(String arg0, String arg1) {


        log.CheckLoginVaildinFile(arg0,arg1);
        loginpass=log.getFoundaccount();



    }


    @When("the user enters an invalid username or password {string}+{string}")
    public void theUserEntersAnInvalidUsernameOrPassword(String arg0, String arg1) {


        log.CheckLoginVaildinFile(arg0,arg1);
        loginpass=log.getFoundaccount();


    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        assertTrue(loginpass);

    }

}
