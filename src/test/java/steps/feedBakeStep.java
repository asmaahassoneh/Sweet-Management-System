package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import production_cods.FeedBackSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class feedBakeStep {
    boolean positive;
    boolean neg;
    FeedBackSource ss = new FeedBackSource();

    // Reset the flags before each scenario
    @Before
    public void setUp() {
        positive = false;
        neg = false;
    }

    // Positive Feedback Tests
    @When("I receive positive feedback as Excellent")
    public void i_receive_positive_feedback_excellent() {
        positive = true;
    }

    @Then("I should send a thank you message for Excellent")
    public void iShouldSendAThankYouMessageForExcellent() {
        assertTrue(ss.positiveFeedBack("Excellent") && positive);
    }

    @When("I receive positive feedback as good")
    public void i_receive_positive_feedback_good() {
        positive = true;
    }

    @Then("I should send a thank you message for good")
    public void iShouldSendAThankYouMessageForGood() {
        assertTrue(ss.positiveFeedBack("good") && positive);
    }

    @When("I receive positive feedback as Medium")
    public void i_receive_positive_feedback_medium() {
        positive = true;
    }

    @Then("I should send a thank you message for Medium")
    public void iShouldSendAThankYouMessageForMedium() {
        assertTrue(ss.positiveFeedBack("Medium") && positive);
    }

    // Negative Feedback Tests
    @When("I receive negative feedback as poor")
    public void i_receive_negative_feedback_poor() {
        neg = true;
    }

    @Then("I should send an apology for poor")
    public void iShouldSendAnApologyForPoor() {
        assertTrue(ss.negativeFeedBack("poor") && neg);
    }

    @When("I receive negative feedback as very bad")
    public void i_receive_negative_feedback_very_bad() {
        neg = true;
    }

    @Then("I should send an apology for very bad")
    public void iShouldSendAnApologyForVeryBad() {
        assertTrue(ss.negativeFeedBack("very bad") && neg);
    }
}
