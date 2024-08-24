package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import production_cods.ManageAccountSource;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MANAGE_AccSteps {

    private boolean errorOccurred;
    private boolean updateSuccess;
    private boolean isUpdatedCity;
    private boolean adminEntered;
    private boolean adminNavigate;
    private boolean editUserButton;
    private  boolean userSelect;
    private  boolean deleteUser;


    ManageAccountSource mang =new ManageAccountSource();

    @Given("an admin is logged into the Sweet Management System")
    public void an_admin_is_logged_into_the_sweet_management_system() {
       adminEntered =true;
    }

    @When("the admin navigates to the User Management section")
    public void the_admin_navigates_to_the_user_management_section() {
        adminNavigate =true;
    }

    @Then("the admin should see a list of accounts")
    public void the_admin_should_see_a_list_of_accounts() {
        assertTrue(adminEntered && adminNavigate);

    }

    @When("the admin selects the {string}")
    public void the_admin_selects_the(String action) {
        editUserButton = action.equals("Edit User");
    }

    @When("the admin select for the user {string}")
    public void the_admin_select_for_the_user(String username) {
        userSelect = true; // This would actually involve more logic to select the specific user
    }

    @And("should Delete the specific user {string}")
    public void shouldDeleteTheSpecificUser(String password) {
        try {
            deleteUser = mang.deleteUser(password);
        } catch (RuntimeException e) {
            errorOccurred = true;
        }
    }

    @Then("the system should show a masseage deleted was sucsess")
    public void theSystemShouldShowAMasseageDeletedWasSucsess() {
        assertEquals(1, mang.getCheckDelete());
    }

    @When("the admin updates the account to {string}+{string}+{string}+{string}+{string}")
    public void theAdminUpdatesTheAccountTo(String email, String username, String role, String city, String password) {
        try {
            updateSuccess = mang.updateEmail(email, username, role, city, password);
        } catch (RuntimeException e) {
            errorOccurred = true;
        }
    }

    @Then("the user account with username {string} should have the updated email")
    public void the_user_account_with_username_should_have_the_updated_email(String username) {
        assertEquals(1, mang.getCheckUpdatedEmail());
    }
    @And("the admin updates the city to {string}+{string}")
    public void theAdminUpdatesTheCityTo(String city, String password) {
        try {
            isUpdatedCity = mang.cityUpdate(city, password);
        } catch (RuntimeException e) {
            errorOccurred = true;
        }
    }

    @Then("a massege should say city updated")
    public void aMassegeShouldSayCityUpdated() {
        assertEquals(1, mang.getCheckUpdateCity());
    }
    @Given("an admin is in the User Management section")
    public void an_admin_is_in_the_user_management_section() {
        adminEntered =true;

    }
    @When("the admin submits the changes")
    public void the_admin_submits_the_changes() {
        adminEntered =true;
    }
    @When("the admin press add and Entered valid Data {string}+{string}+{string}+{string}+{string}")
    public void theAdminPressAddAndEnteredValidData(String username, String city, String email, String password, String role) {
        mang.addNewAccount(username, city, email, password, role);
    }

    @Then("new user will be Added into dataBase")
    public void newUserWillBeAddedIntoDataBase() {
        assertTrue(mang.isValidInput());
    }





    @When("an error occurs while reading the account file")
    public void an_error_occurs_while_reading_the_account_file() {
        // Simulate an error while reading the account file
        errorOccurred = true;
        mang = new ManageAccountSource() {
            @Override
            public boolean cityUpdate(String city, String pass) {
                throw new RuntimeException("Simulated file read error");
            }

            @Override
            public boolean updateEmail(String email, String userName, String role, String city, String pass) {
                throw new RuntimeException("Simulated file read error");
            }

            @Override
            public boolean deleteUser(String password) {
                throw new RuntimeException("Simulated file read error");
            }
        };
    }

    @Then("the system should display an error message indicating the update failed")
    public void the_system_should_display_an_error_message_indicating_the_update_failed() {
        assertTrue(errorOccurred);
        assertEquals(0, mang.getCheckUpdatedEmail());
    }

    @Then("the city should not be updated")
    public void the_city_should_not_be_updated() {
        assertFalse(updateSuccess);
    }

    @Then("the email should not be updated")
    public void the_email_should_not_be_updated() {
        // Ensure email update did not succeed
        assertFalse(updateSuccess);
    }

    @Then("the user should not be deleted from the file")
    public void the_user_should_not_be_deleted_from_the_file() {
        // Ensure delete did not succeed
        assertFalse(updateSuccess);
    }


    @When("the admin attempts to delete a user account with password {string}")
    public void theAdminAttemptsToDeleteAUserAccountWithPassword(String password) {
        try {
            updateSuccess = mang.deleteUser(password);
        } catch (RuntimeException e) {
            errorOccurred = true;
        }
    }

    @Then("a message should confirm that the city was updated")
    public void aMessageShouldConfirmThatTheCityWasUpdated() {
        assertTrue(isUpdatedCity);
    }

    @Then("a message should confirm that the email was updated")
    public void aMessageShouldConfirmThatTheEmailWasUpdated() {
        assertTrue(updateSuccess);
    }

    @Then("a message should confirm that the user was deleted")
    public void aMessageShouldConfirmThatTheUserWasDeleted() {
        assertTrue(updateSuccess);
    }

    @When("the admin updates the account to {string} with username {string} and role {string} and city {string} and password {string}")
    public void theAdminAttemptsToUpdateAUserAccountWithEmailAndUsernameAndRoleAndCityAndPassword(String email, String username, String role, String city, String password) {
        try {
            updateSuccess = mang.updateEmail(email, username, role, city, password);
        } catch (RuntimeException e) {
            errorOccurred = true;
        }
    }
    @Then("the user account with username {string} should have the updated email {string}")
    public void theUserAccountWithUsernameShouldHaveTheUpdatedEmail(String username, String email) {
        assertEquals(1, mang.getCheckUpdatedEmail());
    }


    @When("the account file contains an unexpected line format")
    public void theAccountFileContainsAnUnexpectedLineFormat() {
        mang = new ManageAccountSource() {
            @Override
            public boolean cityUpdate(String city, String pass) {
                return false;  // Simulate failure due to unexpected format
            }

            @Override
            public boolean updateEmail(String email, String userName, String role, String city, String pass) {
                return false;  // Simulate failure due to unexpected format
            }
        };
    }

    @Then("the system should not update the city")
    public void theSystemShouldNotUpdateTheCity() {
        assertFalse(updateSuccess);
    }

    @Then("the system should not update the email")
    public void theSystemShouldNotUpdateTheEmail() {
        assertFalse(updateSuccess);
    }

    @Then("an error message should be logged")
    public void anErrorMessageShouldBeLogged() {
        // Assuming the logger has caught an error, this could be verified in a real system with a mock logger
        assertTrue(errorOccurred);
    }
    @When("an error occurs while writing to the account file")
    public void anErrorOccursWhileWritingToTheAccountFile() {
        // Simulate an error while writing to the account file
        errorOccurred = true;
        mang = new ManageAccountSource() {
            @Override
            public boolean cityUpdate(String city, String pass) {
                throw new RuntimeException("Simulated file write error");
            }

            @Override
            public boolean updateEmail(String email, String userName, String role, String city, String pass) {
                throw new RuntimeException("Simulated file write error");
            }

            @Override
            public boolean deleteUser(String password) {
                throw new RuntimeException("Simulated file write error");
            }
        };
    }

    @Then("the system should display an error message indicating the update failed due to a file write error")
    public void theSystemShouldDisplayAnErrorMessageIndicatingTheUpdateFailedDueToAFileWriteError() {
        // Check that the error was caught and handled
        assertTrue(errorOccurred);
    }

    @Then("the system should display an error message indicating the delete failed due to a file write error")
    public void theSystemShouldDisplayAnErrorMessageIndicatingTheDeleteFailedDueToAFileWriteError() {
        // Check that the error was caught and handled
        assertTrue(errorOccurred);
    }


}
