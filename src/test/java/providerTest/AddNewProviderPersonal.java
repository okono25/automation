package providerTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class AddNewProviderPersonal extends AbstractBasicTest {

    @Test
    public void addNewProviderPrivate() {
        loginPage.openUrl();
        loginPage.loginToSite("Student", "909090");
        providerPage.openProviderPage();
        providerPage.createProviderOwn("Student2","Potapova 12","096213456785");
        checkExpectedResult("New provider isn't displayed",providerPage.isNewProviderDisplayed("Student2","Potapova 12","096213456785"));
        checkExpectedResult("False provider state" ,providerPage.isProviderPrivate(false));
    }
}
