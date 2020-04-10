package dealTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;
import pages.DealPage;

public class BasicDealPageTest extends AbstractBasicTest {

    @Test
    public void dealBaseOpening() {
        loginPage.openUrl();
        loginPage.loginToSite("Student", "909090");
        dealPage.openDealPage();
        checkExpectedResult("False header is displayed",dealPage.isDealHeaderDisplayed());
    }
}
