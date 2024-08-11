package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.AllergySource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllergySteps {

    AllergySource all = new AllergySource();
    boolean pressedOnce = false;

    @When("the user press Allergy button")
    public void the_user_press_allergy_button() {
        pressedOnce = !pressedOnce;
        if (pressedOnce) {
            all.SearchForAllergy();
        }
    }

    @Then("the market must filter the food")
    public void the_market_must_filter_the_food() {
        assertTrue(all.isCheckIfFindAllergy());
    }

    @When("the user press Allergy button two times")
    public void the_user_press_allergy_button_two_times() {
        pressedOnce = !pressedOnce;
        if (!pressedOnce) {
            all.resetAllergyFilter();
        }
    }

    @Then("return all products normally")
    public void return_all_products_normally() {
        assertFalse(all.isCheckIfFindAllergy());
    }
}
