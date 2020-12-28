package automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends MasterPage {


    public HomePage() {
        super();
    }

    @FindBy(className = "nav-logo-link")
    public WebElement amazonText;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = "input[value='Go']")
    public WebElement searchButton;

    @FindBy(css = "span[class='a-color-state a-text-bold']")
    public WebElement searchItemDisplayedText;

    @FindBy(css = "span[class='a-size-medium a-color-base a-text-normal']")
    public WebElement selectedItemText;

    @FindBy(css = "div[class='a-section aok-relative s-image-fixed-height']")
    public WebElement selectedItem;

    @FindBy(css = "select[id='s-result-sort-select']")
    public WebElement sortFeature;

    @FindBy(xpath = "(//*[@class='a-price-whole'])")
    public List<WebElement> priceList;

    @FindBy(id = "glow-ingress-line2")
    public WebElement pinCodeValue;


    public String settings = "//input[@value='";

    public String language = "_IN']//following-sibling::i";

    @FindBy(className = "a-button-input")
    public WebElement save;

    @FindBy(css = "input[name='LOP']")
    public WebElement languageRadioButtons;

    @FindBy(css = "span[id='icp-sl-t-title']")
    public WebElement englishTranslationText;
    @FindBy(id = "icp-nav-flyout")
    public WebElement languageSettings;

    @FindBy(id = "lop-heading")
    public WebElement languageSettingsText;

    @FindBy(id = "GLUXZipUpdateInput")
    public WebElement pinCodeTextBox;

    @FindBy(id = "GLUXZipUpdate-announce")
    public WebElement applyButton;

    @FindBy(css = "[id='ap_email']")
    public WebElement loginEmail;

    @FindBy(css = "[id='continue']")
    public WebElement continueButton;

    @FindBy(css = "[id='ap_password']")
    public WebElement loginPassword;

    @FindBy(id = "signInSubmit")
    public WebElement signIn;


}
