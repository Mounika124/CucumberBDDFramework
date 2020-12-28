package automation.pageactions;

import automation.pageobjects.HomePage;
import automation.utilities.*;
import org.openqa.selenium.WebDriver;


public class CommonPageActions {

    protected Utils utils;
    protected WebDriver webDriver;
    protected FileUtils fileUtils;
    HomePage homePage = new HomePage();

    public CommonPageActions() {
        utils = Utils.getInstance();
        webDriver = utils.getDriver();
        fileUtils=new FileUtils();
    }
    public void user_login(String userName,String password){
        utils.elementWait(homePage.loginEmail, Constants.MEDIUMWAIT);
        utils.safeClearAndType(homePage.loginEmail,userName,"UserName",Constants.MEDIUMWAIT);
        utils.safeClick(homePage.continueButton,"Continue",Constants.MEDIUMWAIT);
        utils.elementWait(homePage.loginPassword, Constants.MEDIUMWAIT);
        utils.safeClearAndType(homePage.loginPassword,password,"password",Constants.MEDIUMWAIT);
        utils.safeClick(homePage.signIn,"login",Constants.MEDIUMWAIT);

    }

}
