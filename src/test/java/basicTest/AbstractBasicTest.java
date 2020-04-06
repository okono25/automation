package basicTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class AbstractBasicTest {

    WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    @Before
    public void setUp(){
        driver = driverInit();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }


    public static WebDriver driverInit(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    public void checkExpectedResult(String message, boolean actualResult){
        Assert.assertTrue(message, actualResult);
    }

    public void checkCurrentUrl(String message, String actualResult){
        Assert.assertEquals(message, driver.getCurrentUrl(), actualResult);
    }

}
