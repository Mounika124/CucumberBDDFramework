package automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MasterPage {


    public ProductPage(){
       super();
    }

    @FindBy(css = "span[id='productTitle']")
    public WebElement productTitle;

    @FindBy(css = "[id='add-to-cart-button']")
    public WebElement addToCart;

    @FindBy(css = "[id='buy-now-button']")
    public WebElement buyNow;

    @FindBy(css = "a[title='Add to Wish List']")
    public WebElement addToWishList;

    @FindBy(css = "[class='a-size-medium a-color-base a-text-normal']")
    public WebElement productSelect;




}
