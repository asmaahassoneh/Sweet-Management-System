package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.feedBackSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class feedBakeStep {

    boolean positive;
    boolean neg;
    feedBackSource ss=new feedBackSource();

    @When("I receive positive feedback")
    public void i_receive_positive_feedback() {

   positive=true;


    }



    @Then("I should send a thank you message {string}")

    public void iShouldSendAThankYouMessage(String arg0) {

assertTrue(ss.PositiveFeedBack(arg0)&&positive);

    }

    @When("I receive negative feedback")
    public void i_receive_negative_feedback() {

        neg=true;

    }


    @Then("I should send an apology for the inconvenience {string}")
    public void iShouldSendAnApologyForTheInconvenience(String arg0) {


        assertFalse(ss.negativeFeedBack(arg0)&&neg);
    }
}
