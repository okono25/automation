package providerTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class BasicProviderTest extends AbstractBasicTest {

    @Test
    public void baseProviderOpening(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        providerPage.openProviderPage();
        checkExpectedResult("Provider header isn't displayed",providerPage.isProviderHeaderDisplayed());
    }
}
