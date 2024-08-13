package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production_cods.ProductManageSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProducrManagSteps {

private  boolean iamStoreOwner;
private  boolean iRequest;
    private  boolean addDone;
    private  boolean miss;
    private boolean updateDone;
    private  boolean deltedProd;
    ProductManageSource prod=new ProductManageSource();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Given("I'm the store owner")
    public void i_m_the_store_owner() {
       iamStoreOwner=true;
    }

    @When("i add new item to the SweetStore {string}+{string}+{string}+{string}+{string}+{string}+{string}+{string}")
    public void iAddNewItemToTheSweetStore(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6,String arg7) throws ParseException {

        addDone=prod.addNewProduct(arg0,arg1,arg2, arg3,Integer.parseInt(arg4),Integer.parseInt(arg5),Boolean.parseBoolean(arg6),arg7);


    }
    @Then("the product add successfully")
    public void the_product_add_successfully() {
assertTrue(addDone);
    }


    @When("i add a product with missing information {string}+{string}+{string}+{string}+{string}+{string}+{string}+{string}")
    public void i_add_a_product_with_missing_information(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6,String arg7) {
            miss=prod.addNewProduct(arg0,arg1,arg2, arg3,Integer.parseInt(arg4),Integer.parseInt(arg5),Boolean.parseBoolean(arg6),arg7);

    }

    @Then("the product is not added and an error message is displayed")
    public void the_product_is_not_added_and_an_error_message_is_displayed() {
assertFalse(miss);
    }


    @When("i choose a product with id for updating it {string}+{string}+{string}+{string}+{string}+{string}+{string}+{string}")
    public void iChooseAProductWithIdForUpdatingIt(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6,String arg7) {
        updateDone =prod.UpdateProduct(arg0,arg1,arg2,arg3,Integer.parseInt(arg4),Integer.parseInt(arg5),Boolean.parseBoolean(arg6),arg7);
    }
    @Then("the product is updated successfully")
    public void the_product_is_updated_successfully() {
assertTrue(updateDone);
    }

    @When("the id repated {string}")
    public void the_id_repated(String id) {
        prod.DuplicateID(id);
    }

    @Then("error message to change the id")
    public void error_message_to_change_the_id() {
        assertFalse(prod.isIdFound());
    }


    @When("I remove the product from my store {string}")
    public void iRemoveTheProductFromMyStore(String arg0) {
        System.out.println(arg0);
        deltedProd = prod.removeProduct(arg0);
    }

    @Then("the product  is removed successfully")
    public void the_product_is_removed_successfully() {
//        assertTrue(deltedProd);
        assertTrue(prod.getCheck() == 1);
    }
}
