package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.TrackSOurce;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrackSteps {

Boolean complete;

TrackSOurce tr=new TrackSOurce();
boolean zeroitem;

    @When("I complete the checkout process {string}")
    public void i_complete_the_checkout_process(String numberOfItems) {

        tr.setDurationChoice(numberOfItems);
        zeroitem=tr.isStat();

    }

    @Then("i want to see how many days left to be done")
    public void i_want_to_see_how_many_days_left_to_be_done() {
assertTrue(zeroitem);

    }

    @When("i want to update my order")
    public void i_want_to_update_my_order() {

    }

    @Then("new receipt must appers")
    public void new_receipt_must_appers() {
        // Write code here that turns the phrase above into concrete actions

    }

}
