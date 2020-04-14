package apparatTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class ClickOnLinkToHomePageTest extends AbstractBasicTest {

    @Test
    public void clickOnLinkToHomepage(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        apparatPage.openApparatPage();
        apparatPage.clickOnLinkToHomePage();
        checkCurrentUrl("False page is opened", dashboardPage.getDashboardPageUrl());
    }
}
