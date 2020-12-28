package automation.pageactions;


import automation.pageobjects.HomePage;
import automation.utilities.Asserts;
import automation.utilities.Constants;
import automation.utilities.Pojo;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

import static automation.utilities.Asserts.expectToBeTrue;


public class HomePageActions extends CommonPageActions {
    Pojo pojo = Pojo.getInstance();
    HomePage homePage = new HomePage();
    static Logger logger = Logger.getLogger("HomePageActions");

    public HomePageActions() {
        super();
    }

    /**
     * search for an item in home page
     *
     * @param item
     * @return the search item
     */
    public String searchForAnItem(String item) {
        logger.info("*****************Search for an item*********************");
        utils.safeClick(homePage.searchBox, "Clicked on Search Box", Constants.MEDIUMWAIT);
        utils.safeClearAndType(homePage.searchBox, item, "Search Box", Constants.MEDIUMWAIT);
        utils.safeClick(homePage.searchButton, "Clicked on Search Button", Constants.MEDIUMWAIT);
        return item;
    }

    /**
     * Method to sort thr elements in ascending order
     *
     * @param list
     * @param <T>
     * @return boolean value (true/false)
     */
    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list) {
        logger.info("******************Compare lists whether they are in ascending order or not*********************");
        for (int i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public void enterPincode(String pinCode) {
        utils.safeClick(homePage.pinCodeValue, "Select Your Address is clicked", Constants.MEDIUMWAIT);
        utils.safeClearAndType(homePage.pinCodeTextBox, pinCode, "Text Entered", Constants.MEDIUMWAIT);
        utils.safeJavaScriptClick(homePage.applyButton, "Clicked On Apply Button", Constants.MEDIUMWAIT);
    }

    public void verifyPincode() {
        utils.elementWait(homePage.pinCodeValue, Constants.LONGWAIT);
        expectToBeTrue(pojo.getPinCode().contains(utils.safeGetText(homePage.pinCodeTextBox, "Pin code text box", Constants.MEDIUMWAIT)), "PinCode text is not verified");
    }

    public void languageSettings() {
        utils.safeJavaScriptClick(homePage.languageRadioButtons, "Language radio button", Constants.MEDIUMWAIT);
        utils.elementWait(homePage.englishTranslationText, Constants.MEDIUMWAIT);
        pojo.setEnglishTranslationText(utils.safeGetText(homePage.englishTranslationText, "English Translation Text", Constants.MEDIUMWAIT));
        expectToBeTrue(pojo.getEnglishTranslationText().equalsIgnoreCase("Translation"), "Language Translation Text is not Verified");
        utils.isAttributePresent(homePage.languageRadioButtons, "checked");
    }

    public String selectLanguage(String lang) {
        String[] language = lang.split("");
        String result = language[0] + language[1];
        System.out.println(language[0] + language[1]);
        utils.safeClick(webDriver.findElement(By.xpath(homePage.settings + language[0] + language[1] + homePage.language)), "",Constants.MEDIUMWAIT);
        utils.safeClick(homePage.save, "Save Changes", Constants.MEDIUMWAIT);
        return result;
    }

    public void verifyLanguageChange(String result) {
        String url = webDriver.getCurrentUrl();
        System.out.println(url);
        Asserts.expectToBeTrue(url.contains(result),"" );
    }

    public void navigateToLanguageSettings() {
        utils.safeClick(homePage.languageSettings, "Clicked On Language Settings", Constants.MEDIUMWAIT);
        utils.elementWait(homePage.languageSettingsText, Constants.MEDIUMWAIT);
        pojo.setLanguageSettings(utils.safeGetText(homePage.languageSettingsText, "Language Settings", Constants.MEDIUMWAIT));
        expectToBeTrue(pojo.getLanguageSettings().equals("Language Settings"), "Language Settings text is not Displayed");
    }
}
