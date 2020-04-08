package serviceTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class BasicServiceTest extends AbstractBasicTest {


    @Test
    public void serviceBaseOpening(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        servicePage.isServiceHeaderDisplayed();
    }
}
