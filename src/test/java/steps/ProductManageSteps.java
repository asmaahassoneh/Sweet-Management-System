package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.ProductManageSource;
import production_cods.Product;
import production_cods.ProductNotFoundException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductManageSteps {
    private  boolean iamStoreOwner;
    private  boolean addDone;
    private  boolean miss;
    private boolean updateDone;
    private  boolean deltedProd;
    ProductManageSource prod=new ProductManageSource();

    @Given("I'm the store owner")
    public void i_m_the_store_owner() {
       iamStoreOwner=true;
    }

    @When("i add new item to the SweetStore {string}+{string}+{string}+{string}+{string}+{string}+{string}+{string}")
    public void iAddNewItemToTheSweetStore(String productName, String productId, String description, String date, String quantity, String price, String allergies, String imagePath) {
        // Build the Product object using the ProductBuilder
        Product newProduct = new Product.ProductBuilder()
                .setProductName(productName)
                .setId(productId)
                .setDescription(description)
                .setDate(date)
                .setQuantity(Integer.parseInt(quantity))
                .setPrice(Double.parseDouble(price))
                .setAllergies(Boolean.parseBoolean(allergies))
                .setImagePath(imagePath)
                .build();

        addDone = prod.addNewProduct(newProduct);
    }
    @Then("the product add successfully")
    public void the_product_add_successfully() {
assertTrue(addDone);
    }


    @When("i add a product with missing information {string}+{string}+{string}+{string}+{string}+{string}+{string}+{string}")
    public void i_add_a_product_with_missing_information(String productName, String productId, String description, String date, String quantity, String price, String allergies, String imagePath) {
        Product newProduct = new Product.ProductBuilder()
                .setProductName(productName)
                .setId(productId)
                .setDescription(description)
                .setDate(date)
                .setQuantity(Integer.parseInt(quantity))
                .setPrice(Double.parseDouble(price))
                .setAllergies(Boolean.parseBoolean(allergies))
                .setImagePath(imagePath)
                .build();

        miss = prod.addNewProduct(newProduct);
    }

    @Then("the product is not added and an error message is displayed")
    public void the_product_is_not_added_and_an_error_message_is_displayed() {
assertFalse(miss);
    }


    @When("i choose a product with id for updating it {string}+{string}+{string}+{string}+{string}+{string}+{string}+{string}")
    public void iChooseAProductWithIdForUpdatingIt(String productName, String productId, String description, String date, String quantity, String price, String allergies, String imagePath) {
        try {
            prod.duplicateId(productId);
        } catch (ProductNotFoundException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        Product updatedProduct = new Product.ProductBuilder()
                .setProductName(productName)
                .setId(productId)
                .setDescription(description)
                .setDate(date)
                .setQuantity(Integer.parseInt(quantity))
                .setPrice(Double.parseDouble(price))
                .setAllergies(Boolean.parseBoolean(allergies))
                .setImagePath(imagePath)
                .build();
        updateDone = prod.updateProduct(updatedProduct);
    }
    @Then("the product is updated successfully")
    public void the_product_is_updated_successfully() {
assertTrue(updateDone);
    }

    @When("the id repated {string}")
    public void the_id_repated(String id) {
        try {
            prod.duplicateId(id);
        } catch (ProductNotFoundException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    @Then("error message to change the id")
    public void error_message_to_change_the_id() {
        assertEquals(1,prod.getCheckDup());
    }


    @When("I remove the product from my store {string}")
    public void iRemoveTheProductFromMyStore(String arg0) {
        System.out.println(arg0);
        deltedProd = prod.removeProduct(arg0);
    }

    @Then("the product  is removed successfully")
    public void the_product_is_removed_successfully() {
        assertEquals(0, prod.getCheck());
    }
}
