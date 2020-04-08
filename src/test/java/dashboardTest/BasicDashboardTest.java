package dashboardTest;

import basicTest.AbstractBasicTest;
import org.junit.Assert;
import org.junit.Test;

public class BasicDashboardTest extends AbstractBasicTest {

    @Test
    public void dashboardBaseOpening(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        checkExpectedResult("False header is displayed",dashboardPage.isDashboardHeaderDisplayed());
        checkRowsCount(5);
    }
}
