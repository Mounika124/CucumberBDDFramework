package automation.pageactions;

import automation.pageobjects.HomePage;
import automation.pageobjects.ProductPage;
import automation.utilities.Asserts;
import automation.utilities.Constants;
import automation.utilities.Pojo;
import org.apache.log4j.Logger;

import static automation.utilities.Asserts.expectToBeTrue;

public class ProductPageActions extends CommonPageActions {
    Pojo pojo = Pojo.getInstance();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    static Logger logger = Logger.getLogger("HomePageActions");

    public ProductPageActions() {
        super();
    }

    public void verifyOptions() {
        logger.info("Verify the options in product page");
        utils.elementWait(homePage.searchItemDisplayedText, Constants.MEDIUMWAIT);
        pojo.setSearchItemText(utils.safeGetText(homePage.searchItemDisplayedText, "Search Item Displayed text", Constants.MEDIUMWAIT));
        expectToBeTrue(pojo.getSearchItemText().contains(pojo.getValue()), "Search Item text is not displayed");
    }

    public void verifyProduct() {
        utils.elementWait(homePage.selectedItemText, Constants.MEDIUMWAIT);
        pojo.setProductName(utils.safeGetText(homePage.selectedItemText, "Selected Item Text", Constants.MEDIUMWAIT));
        logger.info(pojo.getProductName());
        utils.safeClick(homePage.selectedItem, "Clicked On Selected Item", Constants.MEDIUMWAIT);
        utils.switchToChildWindow();
        utils.elementWait(productPage.productTitle, Constants.MEDIUMWAIT);
        pojo.setItemName(utils.safeGetText(productPage.productTitle, "product title", Constants.MEDIUMWAIT));
        logger.info(pojo.getItemName());
        expectToBeTrue(pojo.getProductName().equals(pojo.getItemName()), "Product name and item name are equal");
        Asserts.expectToBeTrue(productPage.addToCart.isDisplayed(), "Add to cart item displayed");
        utils.setFinalHighlight(productPage.buyNow);
        utils.setFinalHighlight(productPage.addToCart);
        utils.setFinalHighlight(productPage.addToWishList);
        Asserts.expectToBeTrue(productPage.buyNow.isDisplayed(), "Buy now button displayed");
        utils.isElementPresent(productPage.addToWishList, "add to cart element", Constants.MEDIUMWAIT);
        Asserts.expectToBeTrue(productPage.addToWishList.isDisplayed(), "Add to wish list displayed");
    }

}
