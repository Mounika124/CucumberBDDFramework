package automation.stepdefinitions;

import automation.pageactions.HomePageActions;
import automation.pageactions.ProductPageActions;
import automation.pageobjects.HomePage;
import automation.utilities.Constants;
import automation.utilities.Pojo;
import automation.utilities.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static automation.utilities.Asserts.expectToBeTrue;


public class Search_Products_And_Language_Setting_StepDef {
    HomePageActions homePageActions = new HomePageActions();
    Logger logger = Logger.getLogger("SearchItemAndLanguageChangingStepDef");
    Pojo pojo = Pojo.getInstance();
    ProductPageActions productPageActions = new ProductPageActions();
    HomePage homePage = new HomePage();
    Utils utils;
    String result;
    WebDriver webDriver;

    public Search_Products_And_Language_Setting_StepDef() {
        utils = Utils.getInstance();
        webDriver = utils.getDriver();
    }

    /**
     * Verify whether user is on homepage or not
     */
    @Given("^User is on home page$")
    public void userIsOnHomePage() {
        logger.info("******************Verify home page**********************");
        utils.elementWait(homePage.amazonText, Constants.VERYLONGWAIT);
        expectToBeTrue(utils.isElementPresent(homePage.amazonText, "Amazon text", Constants.MEDIUMWAIT), "Amazon Text is not Displayed");
    }

    /**
     * User search for an product in home page
     *
     * @param arg0
     */
    @When("^Search for an item with \"([^\"]*)\"$")
    public void searchForAnItemWith(String arg0) {
        logger.info("*********************Search for am item*********************");
        pojo.setValue(homePageActions.searchForAnItem(arg0));
    }

    /**
     * Verify whether the products are displayed according to search criteria.
     */
    @Then("^Verify the items displayed$")
    public void verifyTheItemsDisplayed() {
        logger.info("************Verify the items*********************");
        productPageActions.verifyOptions();
    }

    /**
     * User Navigate to language settings page
     */
    @When("^User navigate to language settings$")
    public void userNavigateToLanguageSettings() {
        logger.info("*******************Language Settings**********************");
        homePageActions.navigateToLanguageSettings();
    }

    @And("^Select \"([^\"]*)\" Language$")
    public void selectLanguage(String arg0)  {
        homePageActions.languageSettings();
        result= homePageActions.selectLanguage(arg0);
    }

    /**
     * Verify whether language is changing or not according to selected language option
     */
    @Then("^Verify the items in language settings$")
    public void verifyTheItemsInLanguageSettings() {
        logger.info("*************Verify language radio button and language translation********************");
        homePageActions.verifyLanguageChange(result);
    }

}
