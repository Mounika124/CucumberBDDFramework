package automation.pageactions;


import automation.pageobjects.HomePage;
import automation.utilities.Constants;
import automation.utilities.Pojo;
import org.apache.log4j.Logger;
import org.jruby.RubyProcess;

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
        expectToBeTrue(pojo.getPinCode().contains(utils.safeGetText(homePage.pinCodeTextBox,"Pin code text box",Constants.MEDIUMWAIT)), "PinCode text is not verified");
    }
}
