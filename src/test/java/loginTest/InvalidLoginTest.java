package loginTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class InvalidLoginTest extends AbstractBasicTest {

    @Test
    public void invalidLoginWithWrongPassword(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","9090902");
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }

    @Test
    public void invalidLoginWithEmptyPassword(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","");
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }

    @Test
    public void invalidLoginWithWrongLogin(){
        loginPage.openUrl();
        loginPage.loginToSite("tudent","909090");
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }

    @Test
    public void invalidLoginWithEmptyLogin(){
        loginPage.openUrl();
        loginPage.loginToSite("","909090");
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }

    @Test
    public void invalidLoginWithEmptyLoginAndPassword(){
        loginPage.openUrl();
        loginPage.loginToSite("","");
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }

    @Test
    public void invalidLoginWithCorrectLoginAndPAsswordInWrongPlaces(){
        loginPage.openUrl();
        loginPage.loginToSite("909090","Student");
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }
}
