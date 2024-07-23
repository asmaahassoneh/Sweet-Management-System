package steps;

import najah.edu.Store;
import najah.edu.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class productManagingSteps {
    Store obj = new Store();
    private boolean isStoreOwner = false;
    private String errorMessage = "";

    @Before
    public void beforeEachScenario() {
        isStoreOwner = false;
        errorMessage = "";
    }

    @Given("I'm the store owner")
    public void i_m_the_store_owner() {
        isStoreOwner = true;
    }

    @When("the name is {string} and the price is {int} and the num of available is {int} and the description is {string} and the recipes is {string} and the cost is {int} and the discount is {int}")
    public void the_name_is_and_the_price_is_and_the_num_of_available_is_and_the_description_is(String string, Integer int1, Integer int2, String string2, String string3, Integer int3, Integer int4) {
        if (!isStoreOwner) {
            throw new IllegalStateException("Not a store owner");
        }
        if (obj.addProduct(new Product(string, int1, int2, string2, string3, int3, int4))) {
            errorMessage = "";
        } else {
            errorMessage = "Product name already exists";
        }
    }

    @Then("the product add successfully")
    public void the_product_add_successfully() {
        assertEquals(1, obj.getCheck());
    }

    @Given("there is a product named {string} in my store")
    public void there_is_a_product_named_in_my_store(String string) {
        obj.addProduct(new Product(string, 25, 1, "default description", "default recipes", 20,10));
    }

    @Then("an error message is displayed indicating the product name already exists")
    public void an_error_message_is_displayed_indicating_the_product_name_already_exists() {
//        Assert.assertEquals("Product name already exists", errorMessage);
        assertEquals(0, obj.getCheck());
    }

    @Then("the product is not added and an error message is displayed")
    public void the_product_is_not_added_and_an_error_message_is_displayed() {
        Assert.assertNotNull(errorMessage);
    }

    @When("I update the product with new price {int} and the num of available is {int} and description {string} and the recipes is {string} and the cost is {int} and the discount is {int}")
    public void i_update_the_product_with_new_price_and_the_num_of_available_is_and_description(Integer int1, Integer int2, String string, String string1, Integer int3, Integer int4) {
        if (obj.updateProduct("cheesecake", int1, int2, string, string1, int3, int4)) {
            errorMessage = "";
        } else {
            errorMessage = "Invalid product data";
        }
    }

    @Then("the product {string} is updated successfully")
    public void the_product_is_updated_successfully(String string) {
        Product product = obj.getProduct(string);
        Assert.assertNotNull(product);
        Assert.assertEquals(30, product.getPrice());
        Assert.assertEquals(2, product.getNumAvailable());
        Assert.assertEquals("delicious", product.getDescription());
        Assert.assertEquals(25, product.getCost());
        Assert.assertEquals(5, product.getDiscount());
        Assert.assertEquals("egg/milk/water", product.getRecipes());
    }

    @Then("the product is not updated and an error message is displayed")
    public void the_product_is_not_updated_and_an_error_message_is_displayed() {
        Assert.assertEquals("Product does not exist or invalid data", errorMessage);
    }

    @When("the name is {string} and the price is {string} and the num of available is {int} and the description is {string} and the recipes is {string} and the cost is {int} and the discount is {int}")
    public void the_name_is_and_the_price_is_and_the_num_of_available_is_and_the_description_is(String string, String string2, Integer int1, String string3, String string4, Integer int2, Integer int3) {
        try {
            int parsedPrice = Integer.parseInt(string2);
            if (!obj.addProduct(new Product(string, parsedPrice, int1, string3, string4,  int2,  int3))) {
                errorMessage = "Product name already exists";
            } else {
                errorMessage = "";
            }
        } catch (NumberFormatException e) {
            errorMessage = "Price must be a numeric value";
        }
    }

    @Then("the product is not added and an error message is displayed indicating the price must be a numeric value")
    public void the_product_is_not_added_and_an_error_message_is_displayed_indicating_the_price_must_be_a_numeric_value() {
        Assert.assertEquals("Price must be a numeric value", errorMessage);
    }

    @When("I remove the product from my store")
    public void i_remove_the_product_from_my_store() {
        if (!obj.removeProduct("cheesecake")) {
            errorMessage = "Product does not exist";
        } else {
            errorMessage = "";
        }
    }

    @Then("the product {string} is removed successfully")
    public void the_product_is_removed_successfully(String string) {
        Assert.assertNull(obj.getProduct(string));
    }

}