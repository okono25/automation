package providerTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class AddNewProviderPrivate extends AbstractBasicTest {

    @Test
    public void addNewProviderPrivate() {
        loginPage.openUrl();
        loginPage.loginToSite("Student", "909090");
        providerPage.openProviderPage();
        providerPage.createProviderPrivate("Student","Shevchenka 30","0631234567894");
        checkExpectedResult("New provider isn't displayed",providerPage.isNewProviderDisplayed("Student","Shevchenka 30","0631234567894"));
        checkExpectedResult("False provider state" ,providerPage.isProviderPrivate(true));
    }
}
