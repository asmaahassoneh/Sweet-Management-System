package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.ProfitsSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfitsSteps {

Boolean pressedButton;
double value;
ProfitsSource p=new ProfitsSource();
    @When("the store owner press profit button")
    public void the_store_owner_press_profit_button() {
        value=p.ProfitCalculated();
        System.out.println(value);
    }

    @Then("it should see the total incomes from sweet shop")
    public void it_should_see_the_total_incomes_from_sweet_shop() {
        assertTrue(p.isProfitCalculated());

    }




    @When("the store owner press most solded item button")
    public void the_store_owner_press_most_solded_item_button() {
        int repated=p.mostRepated();

    }

    @Then("it should see the name for the most solded item")
    public void it_should_see_the_name_for_the_most_solded_item() {
assertTrue(p.isRepated());
    }

    @When("the store owner press less solded item button")
    public void the_store_owner_press_less_solded_item_button() {
int less=p.lessRepated();
    }

    @Then("it should see the name for the less solded item")
    public void it_should_see_the_name_for_the_less_solded_item() {
assertTrue(p.isLessREapet());
    }

    @When("the store owner press less or most  solded item button")
    public void the_store_owner_press_less_or_most_solded_item_button() {

    }

    @When("both are have the same number of sellings")
    public void both_are_have_the_same_number_of_sellings() {

    }

    @Then("we must show all the name of the solded items")
    public void we_must_show_all_the_name_of_the_solded_items() {

    }
































}
