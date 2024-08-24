package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import production_cods.NotificationSource;

public class notificationStep {
    private NotificationSource notificationSource;
    private String subject;
    private String message;
    private String recipient;
    private boolean emailSentSuccessfully = false;

    @Given("there exists a special request made by a user")
    public void there_exists_a_special_request_made_by_a_user() {
        notificationSource = new NotificationSource();
        subject = "Special Request";
        message = "I want a cake with extra honey";
    }

    @Given("there exists a special request made by a user with empty subject and message")
    public void there_exists_a_special_request_made_by_a_user_with_empty_subject_and_message() {
        notificationSource = new NotificationSource();
        subject = "";
        message = "";
    }

    @Given("there exists a special request made by a user with special characters in subject and message")
    public void there_exists_a_special_request_made_by_a_user_with_special_characters_in_subject_and_message() {
        notificationSource = new NotificationSource();
        subject = "!@#$%^&*()";
        message = "Special characters !@#$%^&*() in message";
    }

    @Given("there exists a special request made by a user with a long subject and message")
    public void there_exists_a_special_request_made_by_a_user_with_a_long_subject_and_message() {
        notificationSource = new NotificationSource();
        subject = "Long Subject".repeat(20);
        message = "Long Message".repeat(50);
    }

    @When("the system sends a notification email to the store owner {string}")
    public void theSystemSendsANotificationEmailToTheStoreOwner(String recipient) {
        this.recipient = recipient;
        try {
            notificationSource.sendEmail(recipient, subject, message);
            emailSentSuccessfully = true;
        } catch (Exception e) {
            emailSentSuccessfully = false;
        }
    }

    @When("the system tries to send an email to an invalid email address")
    public void the_system_tries_to_send_an_email_to_an_invalid_email_address() {
        recipient = "invalid-email";
        try {
            notificationSource.sendEmail(recipient, subject, message);
            emailSentSuccessfully = true;
        } catch (Exception e) {
            emailSentSuccessfully = false;
        }
    }

    @Then("the store owner should receive an email about the special request")
    public void the_store_owner_should_receive_an_email_about_the_special_request() {
        Assertions.assertTrue(emailSentSuccessfully, "Email sending should be successful");
    }

    @Then("the email sending should fail")
    public void the_email_sending_should_fail() {
        Assertions.assertFalse(emailSentSuccessfully, "Email sending should fail");
    }
}
