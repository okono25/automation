package apparatTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class BasicApparatTest extends AbstractBasicTest {

    @Test
    public void apparatBaseOpening(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        apparatPage.openApparatPage();
        apparatPage.isApparatHeaderDisplayed();
    }
}
