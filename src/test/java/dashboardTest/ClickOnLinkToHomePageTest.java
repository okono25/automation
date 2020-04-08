package dashboardTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class ClickOnLinkToHomePageTest extends AbstractBasicTest {

    @Test
    public void clickOnLinkToHomepage(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        checkCurrentUrl("False url is displayed",dashboardPage.getDashboardPageUrl());
    }
}
