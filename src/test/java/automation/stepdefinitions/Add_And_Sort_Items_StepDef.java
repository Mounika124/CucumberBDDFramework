package automation.stepdefinitions;


import automation.pageactions.CommonPageActions;
import automation.pageactions.HomePageActions;
import automation.pageactions.ProductPageActions;
import automation.pageobjects.HomePage;
import automation.pageobjects.ProductPage;
import automation.utilities.Constants;
import automation.utilities.Pojo;
import automation.utilities.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static automation.utilities.Asserts.expectToBeTrue;

public class Add_And_Sort_Items_StepDef {
    HomePageActions homePageActions = new HomePageActions();
    Pojo pojo = Pojo.getInstance();
    HomePage homePage = new HomePage();
    ProductPageActions productPageActions = new ProductPageActions();
    Logger logger = Logger.getLogger("AddItemsAndSortItemsStepDef");
    CommonPageActions commonPageActions=new CommonPageActions();
    Utils utils;
    private WebDriver webDriver;

    public Add_And_Sort_Items_StepDef() {
        utils = Utils.getInstance();
        webDriver = utils.getDriver();
    }

    /**
     * Search for an item in amazon
     *
     * @param arg0
     */
    @When("^User search for an item with \"([^\"]*)\"$")
    public void userSearchForAnItemWith(String arg0) {
        logger.info("********************Search for an item*********************");
        pojo.setValue(homePageActions.searchForAnItem(arg0));

    }

    /**
     * Sort products by prices
     */
    @Then("^Sort items by applying filters$")
    public void sortItemsByApplyingFilters() {
        logger.info("**********************Sort items*******************");
        utils.elementWait(homePage.sortFeature, Constants.MEDIUMWAIT);
        utils.safeSelectOptionByVisibleText(homePage.sortFeature, "Price: Low to High", Constants.MEDIUMWAIT);
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = homePage.priceList;
        System.out.println(elementList);
        for (WebElement we : elementList) {
            obtainedList.add(utils.safeGetText(we, "Price list", Constants.MEDIUMWAIT));
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        System.out.println(sortedList);
        expectToBeTrue(sortedList.equals(obtainedList), "Both lists are not equal");
        homePageActions.isSorted(obtainedList);
    }

    /**
     * Verify the entered product name and displayed product name are equal
     */
    @Then("^Verify the product name$")
    public void verifyTheProductName() {
        logger.info("********************Verify product name*********************");
        productPageActions.verifyProduct();
    }

    /**
     * Add the item to the wish list
     */
    @And("^Add the product to wish list$")
    public void addTheProductToWishList() {
        productPageActions.selectWishList();
    }

    @Given("^Login in to the application$")
    public void loginInToTheApplication(List<Map<String, String>> userCredentials) {
        commonPageActions.user_login(userCredentials.get(0).get("UserName"),userCredentials.get(0).get("Password"));
    }

    @Then("^Verify The WishList$")
    public void verifyTheWishList() {
    }
}
