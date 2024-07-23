package steps;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.SignupSource;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class signUPsteps {
    SignupSource o = new SignupSource();

private  Boolean Repatedpass;
    private String Emailusedd;
    private String VaildUserNames;
    private String vaildEmail;
    private String vaildPassword;
    private boolean isValidrole;
    private String confirmPass;
    private boolean clickSignButton;
    private boolean IamONsignUP;

    public String getEmailusedd() {
        return Emailusedd;
    }

    public void setEmailusedd(String emailusedd) {
        Emailusedd = emailusedd;
    }

    public String getVaildUserNames() {
        return VaildUserNames;
    }

    public void setVaildUserNames(String vaildUserNames) {
        VaildUserNames = vaildUserNames;
    }

    public String getVaildEmail() {
        return vaildEmail;
    }

    public void setVaildEmail(String vaildEmail) {
        this.vaildEmail = vaildEmail;
    }

    public String getVaildPassword() {
        return vaildPassword;
    }

    public void setVaildPassword(String vaildPassword) {
        this.vaildPassword = vaildPassword;
    }

    public boolean isValidrole() {
        return isValidrole;
    }

    public void setValidrole(boolean validrole) {
        isValidrole = validrole;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public boolean isClickSignButton() {
        return clickSignButton;
    }

    public void setClickSignButton(boolean clickSignButton) {
        this.clickSignButton = clickSignButton;
    }

    public boolean isIamONsignUP() {
        return IamONsignUP;
    }

    public void setIamONsignUP(boolean iamONsignUP) {
        IamONsignUP = iamONsignUP;
    }

    @Given("I am on the sign-up page")
    public void i_am_on_the_sign_up_page() {
        IamONsignUP = true;


    }

    @When("I enter a valid username {string}")
    public void i_enter_a_valid_username(String username) {
        VaildUserNames = username;
    }

    @When("I enter a valid email {string}")
    public void i_enter_a_valid_email(String email) {
        vaildEmail = email;
        Emailusedd=email;
    }

    @When("I enter a valid role {string}")
    public void i_enter_a_valid_role(String role) {
        isValidrole = o.isValidRole(role);

    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String password) {

        vaildPassword = password;

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
        assertTrue(o.validUserInputData(VaildUserNames, vaildEmail, vaildPassword, confirmPass) );
    }

    @When("I enter an invalid username {string}")
    public void i_enter_an_invalid_username(String username) {
        VaildUserNames = username;
    }

    @Then("I should see Invalid username {string}")
    public void i_should_see_invalid_username(String errorMessage) {
        assertFalse(o.validUserInputData(VaildUserNames, vaildEmail, vaildPassword, confirmPass));
    }

    @Then("I should see Email address is already in use {string}")
    public void i_should_see_email_address_is_already_in_use(String errorMessage) {

        assertFalse( o.Emailused(Emailusedd));
    }


    @Then("I should see Passwords do not match {string}")
    public void i_should_see_passwords_do_not_match(String errorMessage) {
        assertFalse(o.validUserInputData(VaildUserNames, vaildEmail, vaildPassword, confirmPass) );

    }

   //when user enter wrong role  but i name it like this to reduce  functions
    @Then("I should see Invalid role {string}")
    public void iShouldSeeInvalidRole(String arg0) {

        assertFalse(  isValidrole );

    }

    @And("I enter a repated pass password {string}")
    public void iEnterARepatedPassPassword(String arg0) {

       o.checkForRepatedpass(arg0);
      Repatedpass =o.getRepatedpass();
    }

    @Then("I should see invalid pass address is already in use")
    public void iShouldSeeInvalidPassAddressIsAlreadyInUse() {

        assertTrue(Repatedpass);
    }
}