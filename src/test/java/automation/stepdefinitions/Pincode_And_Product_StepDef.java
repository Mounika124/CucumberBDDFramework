package automation.stepdefinitions;

import automation.pageactions.HomePageActions;
import automation.pageactions.ProductPageActions;
import automation.utilities.Pojo;
import automation.utilities.Utils;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Pincode_And_Product_StepDef {

    Logger logger = Logger.getLogger("Pincode_And_Product_StepDef");
    Pojo pojo = Pojo.getInstance();
    HomePageActions homePageActions = new HomePageActions();
    ProductPageActions productPageActions = new ProductPageActions();
    Utils utils;
    WebDriver webDriver;

    public Pincode_And_Product_StepDef() {
        utils = Utils.getInstance();
        webDriver = utils.getDriver();
    }

    /**
     * User add PinCode for the address
     */
    @When("^User select location by entering pincode$")
    public void userSelectLocationByEnteringPincode(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        logger.info("User add the address");
        pojo.setPinCode(list.get(0).get("pinCode"));
        homePageActions.enterPincode(list.get(0).get("pinCode"));
    }

    /**
     * Verify whether user entered PinCode displayed or not
     */
    @Then("^Verify the pincode is added or not$")
    public void verifyThePinCodeIsAddedOrNot() {
        logger.info("Verify the Pincode");
        homePageActions.verifyPincode();
    }

    /**
     * Search The Product
     */
    @And("^Search The Product$")
    public void searchTheProduct(List<Map<String, String>> product) {
        pojo.setValue(homePageActions.searchForAnItem(product.get(0).get("productName")));
    }

    /**
     * Verify the options in product page
     */
    @Then("^Verify Options in Product Page$")
    public void verifyOptionsInProductPage() {
        productPageActions.verifyOptions();
        productPageActions.verifyProduct();
    }
}
