package logOutTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class ValidLogOutTest extends AbstractBasicTest {

    @Test
    public void validLogOutTest(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        loginPage.logOut();
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }
}
