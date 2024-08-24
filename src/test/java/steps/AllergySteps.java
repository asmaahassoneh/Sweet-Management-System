package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.AllergySource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AllergySteps {

    AllergySource all = new AllergySource();
    boolean pressedOnce = false;

    @When("the user presses the Allergy button")
    public void the_user_presses_allergy_button() {
        pressedOnce = !pressedOnce;
        if (pressedOnce) {
            all.searchForAllergy();
        }
    }

    @Then("the market should filter the food")
    public void the_market_should_filter_the_food() {
        // Assuming the filter is applied if there is any 'true' in the file
        assertTrue(all.isCheckIfFindAllergy(), "The allergy filter should be applied.");
    }

    @When("the user presses the Allergy button two times")
    public void the_user_presses_allergy_button_two_times() {
        pressedOnce = !pressedOnce;
        if (pressedOnce) {
            all.searchForAllergy();
        }
        pressedOnce = !pressedOnce;
        if (!pressedOnce) {
            all.resetAllergyFilter();
        }
    }

    @Then("all products should be returned normally")
    public void all_products_should_be_returned_normally() {
        assertFalse(all.isCheckIfFindAllergy(), "The allergy filter should be reset.");
    }
}
