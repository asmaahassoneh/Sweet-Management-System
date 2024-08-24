package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.SignupSource;
import production_cods.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class signUPsteps {
    SignupSource o = new SignupSource();
    private User user;
    private Boolean repeatedPass;
    private String emailUsed;
    private String validUserNames;
    private String validEmail;
    private String validPassword;
    private boolean isValidRole;
    private String confirmPass;
    private boolean clickSignButton;
    private boolean inSignUp;
    private String city = "nablus";

    @Given("I am on the sign-up page")
    public void i_am_on_the_sign_up_page() {
        inSignUp = true;
    }

    @When("I enter a valid username {string}")
    public void i_enter_a_valid_username(String username) {
        validUserNames = username;
    }

    @When("I enter a valid email {string}")
    public void i_enter_a_valid_email(String email) {
        validEmail = email;
        emailUsed = email;
    }

    @When("I enter a valid role {string}")
    public void i_enter_a_valid_role(String role) {
        isValidRole = o.isValidRole(role);
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String password) {
        validPassword = password;
    }

    @When("I confirm the password {string}")
    public void i_confirm_the_password(String confirmPasswords) {
        confirmPass = confirmPasswords;
    }

    @When("I click the sign-up button")
    public void i_click_the_sign_up_button() {
        clickSignButton = true;
    }

    @Then("I should see Account created successfully")
    public void i_should_see_account_created_successfully() {
        assertTrue(o.validUserInputData(validUserNames, validEmail, validPassword, confirmPass));
        user = new User(validUserNames, city, validEmail, validPassword, "user");
        assertEquals(validUserNames, user.getUserName());
        assertEquals(city, user.getCity());
        assertEquals(validEmail, user.getEmail());
        assertEquals(validPassword, user.getPassWord());
        assertEquals("user", user.getRole());
    }

    @When("I enter an invalid username {string}")
    public void i_enter_an_invalid_username(String username) {
        validUserNames = username;
    }

    @Then("I should see Invalid username {string}")
    public void i_should_see_invalid_username(String errorMessage) {
        assertFalse(o.validUserInputData(validUserNames, validEmail, validPassword, confirmPass));
    }

    @Then("I should see Email address is already in use {string}")
    public void i_should_see_email_address_is_already_in_use(String errorMessage) {
        assertFalse(o.emailUsed(emailUsed));
    }

    @Then("I should see Passwords do not match {string}")
    public void i_should_see_passwords_do_not_match(String errorMessage) {
        assertFalse(o.validUserInputData(validUserNames, validEmail, validPassword, confirmPass));
    }

    @Then("I should see Invalid role {string}")
    public void iShouldSeeInvalidRole(String arg0) {
        assertFalse(isValidRole);
    }

    @And("I enter a repeated pass password {string}")
    public void iEnterARepeatedPassPassword(String arg0) {
        o.checkForRepeatedPass(arg0);
        repeatedPass = o.getRepeatedPass();
    }

    @Then("I should see invalid pass address is already in use")
    public void iShouldSeeInvalidPassAddressIsAlreadyInUse() {
        assertEquals(0, o.getCheckRepeated());
    }

    @Then("I should see the user details are correct")
    public void iShouldSeeTheUserDetailsAreCorrect() {
        user = new User("JohnDoe", "Nablus", "john.doe@gmail.com", "password123", "Admin");

        assertEquals("JohnDoe", user.getUserName());
        assertEquals("Nablus", user.getCity());
        assertEquals("john.doe@gmail.com", user.getEmail());
        assertEquals("password123", user.getPassWord());
        assertEquals("Admin", user.getRole());
    }

    @When("I update the email to {string}")
    public void iUpdateTheEmailTo(String newEmail) {
        user.email = newEmail;
    }

    @Then("I should see the updated email is {string}")
    public void iShouldSeeTheUpdatedEmailIs(String newEmail) {
        assertEquals(newEmail, user.getEmail());
    }

    @Then("The account should be saved in the file")
    public void theAccountShouldBeSavedInTheFile() throws IOException {
        String filePath = "Accounts.txt";

        List<String> lines = Files.lines(Paths.get(filePath)).toList();

        String expectedLine = "Mohammed,Nablus,mohammed@gmail.com,mohas1224,Admin";

        System.out.println("Expected line: " + expectedLine);

        // Print the file contents for debugging
        System.out.println("File contents:");
        lines.forEach(System.out::println);

        // Check if the expected line is in the file
        assertTrue("Expected line not found in file", lines.contains(expectedLine));
    }

}
