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

    @Then("the store owner should receive an email about the special request")
    public void the_store_owner_should_receive_an_email_about_the_special_request() {
        Assertions.assertTrue(emailSentSuccessfully, "Email sending should be successful");
    }

    @Then("the email sending should fail")
    public void the_email_sending_should_fail() {
        Assertions.assertFalse(emailSentSuccessfully, "Email sending should fail");
    }
}

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import production_cods.NotificationSource;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class notificationStep {
//    private NotificationSource notificationSource;
//    private String subject;
//    private String message;
//
//    @Given("there exists a special request made by a user")
//    public void there_exists_a_special_request_made_by_a_user() {
//        notificationSource = new NotificationSource();
//        subject = "Special Request";
//        message = "I want a cake with extra honey";
//    }
//
//    @When("the system sends a notification email to the store owner {string}")
//    public void theSystemSendsANotificationEmailToTheStoreOwner(String arg0) {
//        notificationSource.sendEmail(arg0, subject, message);
//    }
//
//    @Then("the store owner should receive an email about the special request")
//    public void the_store_owner_should_receive_an_email_about_the_special_request() {
//        assertTrue(true, "Email sending should be successful");
//    }
//
//
//}
