package automation.pageactions;

import automation.pageobjects.ProductPage;
import automation.utilities.Asserts;
import org.apache.log4j.Logger;

public class ProductPageActions extends CommonPageActions {

    ProductPage cartPage = new ProductPage();
    static Logger logger = Logger.getLogger("HomePageActions");

    public ProductPageActions() {
        super();
    }
    public void verifyOptions(){
        logger.info("Verify the options in product page");
        Asserts.expectToBeTrue(cartPage.addToCart.isDisplayed(),"Add to cart item displayed");
        Asserts.expectToBeTrue(cartPage.buyNow.isDisplayed(),"Buy now button displayed");
        Asserts.expectToBeTrue(cartPage.addToWishList.isDisplayed(),"Add to wish list displayed");

    }
}
