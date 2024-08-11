package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.MANAGE_AccSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MANAGE_AccSteps {
    private boolean  AdminEntered;
    private boolean  AdminNavigate;
    private boolean EditUserButton;
    private  boolean UserSelect;
    private  boolean deleteUser;
    private  boolean Updated;
    private  boolean UpdatedCity;

    MANAGE_AccSource mang =new MANAGE_AccSource();

    @Given("an admin is logged into the Sweet Management System")
    public void an_admin_is_logged_into_the_sweet_management_system() {
       AdminEntered =true;
    }

    @When("the admin navigates to the User Management section")
    public void the_admin_navigates_to_the_user_management_section() {
        AdminNavigate=true;

    }

    @Then("the admin should see a list of accounts")
    public void the_admin_should_see_a_list_of_accounts() {
        assertTrue(AdminEntered&&AdminNavigate);

    }

    @When("the admin selects the {string}")
    public void the_admin_selects_the(String action) {
        EditUserButton = action.equals("Edit User");
    }

    @When("the admin select for the user {string}")
    public void the_admin_select_for_the_user(String username) {
        // Assuming UserSelect should match the intended user identifier, like username
        UserSelect = true; // This would actually involve more logic to select the specific user
    }

    @And("should Delete the specific user {string}")
    public void shouldDeleteTheSpecificUser(String password) {
        deleteUser = mang.DeleteUser(password);
    }

    @Then("the system should show a masseage deleted was sucsess")
    public void theSystemShouldShowAMasseageDeletedWasSucsess() {
//        assertTrue(deleteUser && UserSelect);
        assertTrue(mang.getCheckDelete() == 1);
    }

    @When("the admin updates the account to {string}+{string}+{string}+{string}+{string}")
    public void theAdminUpdatesTheAccountTo(String email, String username, String role, String city, String password) {
        Updated = mang.UpdateEmail(email, username, role, city, password);
    }

    @Then("the user account with username {string} should have the updated email")
    public void the_user_account_with_username_should_have_the_updated_email(String username) {
//        assertTrue(Updated);
        assertTrue(mang.getCheckUpdatedEmail() == 1);
    }
    @And("the admin updates the city to {string}+{string}")
    public void theAdminUpdatesTheCityTo(String city, String password) {
        UpdatedCity = mang.CityUpdate(city, password);
    }

    @Then("a massege should say city updated")
    public void aMassegeShouldSayCityUpdated() {
//        assertTrue(UpdatedCity);
        assertTrue(mang.getCheckUpdateCity() == 1);
    }



    @Given("an admin is in the User Management section")
    public void an_admin_is_in_the_user_management_section() {
        AdminEntered =true;

    }




    @When("the admin submits the changes")
    public void the_admin_submits_the_changes() {
        AdminEntered =true;
    }
    @When("the admin press add and Entered valid Data {string}+{string}+{string}+{string}+{string}")
    public void theAdminPressAddAndEnteredValidData(String username, String city, String email, String password, String role) {
        mang.ADDNewAccount(username, city, email, password, role);
    }

    @Then("new user will be Added into dataBase")
    public void newUserWillBeAddedIntoDataBase() {
        assertTrue(mang.isValidINput());
    }


}
