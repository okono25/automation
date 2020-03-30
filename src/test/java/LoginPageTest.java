import org.junit.Test;
import pages.LoginPage;

public class LoginPageTest {

    LoginPage loginPage = new LoginPage(LoginPage.driverInit());

    @Test
    public void loginTest(){
        loginPage.loginToPage("Student","909090");
    }
}
