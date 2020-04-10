package loginTest;

import basicTest.AbstractBasicTest;
import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Test;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Map;

public class ValidLoginTestWithExcel extends AbstractBasicTest {

    @Test
    public void ValidLoginTest() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");
        loginPage.openUrl();
        loginPage.inputLogin(dataForValidLogin.get("login"));
        loginPage.inputPassword(dataForValidLogin.get("pass"));
        loginPage.clickSubmit();
        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
        loginPage.checkUnLoggedTitle();
    }
}
