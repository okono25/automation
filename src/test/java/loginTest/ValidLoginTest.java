package loginTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class ValidLoginTest extends AbstractBasicTest {

    @Test
    public void validLogin(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        checkExpectedResult("Avatar ins't present", dashboardPage.isAvatarDisplayed());
        dashboardPage.checkLoggedTitle();
    }

    @Test
    public void validLoginWithCorrectLoginInUpperCase(){
        loginPage.openUrl();
        loginPage.loginToSite("STUDENT","909090");
        checkExpectedResult("Avatar is present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }
}
