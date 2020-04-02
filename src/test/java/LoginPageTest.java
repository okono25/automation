import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage = new LoginPage(driverInit());

    @Before
    public void openPage(){
        loginPage.openUrl();
    }

    @Test
    public void loginIsSuccessful(){
        loginPage.loginToPageSuccessfulResult("Student","909090");
    }

    @Test
    public void loginIsntSuccessful(){
        loginPage.loginToPageFalseResult("Student","909092");
    }

    @After
    public void closePage(){
        loginPage.tearDown();
    }
}
