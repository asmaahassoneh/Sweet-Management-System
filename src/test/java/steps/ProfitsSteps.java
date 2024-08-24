package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.ProfitsSource;

import static org.junit.jupiter.api.Assertions.*;

public class ProfitsSteps {
double value;
ProfitsSource p=new ProfitsSource();




    @When("the store owner press profit button")
    public void the_store_owner_press_profit_button() {
        value = p.profitCalculated();
        System.out.println(value);
        assertTrue(value >= 0);
    }

    @Then("it should see the total incomes from sweet shop")
    public void it_should_see_the_total_incomes_from_sweet_shop() {
        assertTrue(p.isProfitCalculated());
    }

    @When("the store owner press most solded item button")
    public void the_store_owner_press_most_solded_item_button() {
        int maxFrequency = p.mostRepeated();
        System.out.println("Max Frequency: " + maxFrequency);
        // Assuming the method calls parseProductName indirectly
        assertTrue(maxFrequency >= 0);
    }

    @Then("it should see the name for the most solded item")
    public void it_should_see_the_name_for_the_most_solded_item() {
        assertTrue(p.isRepeated());
    }

    @When("the store owner press less solded item button")
    public void the_store_owner_press_less_solded_item_button() {
        int minFrequency = p.lessRepeated();
        System.out.println("Min Frequency: " + minFrequency);
        // Assuming the method calls parseProductName indirectly
        assertTrue(minFrequency >= 0);
    }

    @Then("it should see the name for the less solded item")
    public void it_should_see_the_name_for_the_less_solded_item() {
        assertTrue(p.isLessRepeat());
    }

    @When("the store owner press less or most solded item button")
    public void the_store_owner_press_less_or_most_solded_item_button() {
        int maxFrequency = p.mostRepeated();
        int minFrequency = p.lessRepeated();
        if (maxFrequency == minFrequency) {
            System.out.println("Both have the same frequency");
        }
    }


    @When("both are have the same number of sellings")
    public void both_are_have_the_same_number_of_sellings() {
        int maxFrequency = p.mostRepeated();
        int minFrequency = p.lessRepeated();
        assertEquals(maxFrequency, minFrequency);
    }




    @Then("we must show all the name of the solded items")
    public void we_must_show_all_the_name_of_the_solded_items() {

    }

    @When("the file does not exist")
    public void the_file_does_not_exist() {
        p.setFilePath("non-existent-file.txt");
    }

    @Then("it should handle the IOException")
    public void it_should_handle_the_ioexception() {
        p.profitCalculated();
        assertFalse(p.isProfitCalculated());
        p.mostRepeated();
        assertFalse(p.isRepeated());
        p.lessRepeated();
        assertFalse(p.isLessRepeat());
    }

    @When("the product detail contains an invalid profit value")
    public void the_product_detail_contains_an_invalid_profit_value() {
        p.setFilePath("invalid-profit.txt");
        double profit = p.profitCalculated();
        System.out.println("Calculated Profit: " + profit);
    }

    @Then("it should handle the NumberFormatException in profit calculation")
    public void it_should_handle_the_number_format_exception_in_profit_calculation() {
        assertFalse(p.isProfitCalculated());
    }

}
