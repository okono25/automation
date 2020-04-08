package dashboardTest;

import basicTest.AbstractBasicTest;
import org.junit.Assert;
import org.junit.Test;

public class BasicDashboardTest extends AbstractBasicTest {

    @Test
    public void dashboardBaseOpening(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        dashboardPage.isDashboardHeaderDisplayed();
        dashboardPage.clickOnLinkToHomePage();
        checkCurrentUrl("False page is opened", dashboardPage.getDashboardPageUrl());
        //Assert.assertEquals(5,dashboardPage.checkRowCount());
    }
}
