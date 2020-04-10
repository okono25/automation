package basicTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AbstractBasicTest {

    WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ServicePage servicePage;
    protected ApparatPage apparatPage;
    protected DealPage dealPage;
    protected Utils utils;
    protected String pathToScreenShot;


    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws Exception{

        pathToScreenShot = "..\\automation\\target\\screenshot\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName()
                + this.testName.getMethodName() + ".jpg";
        driver = driverInit();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        servicePage = new ServicePage(driver);
        apparatPage = new ApparatPage(driver);
        dealPage = new DealPage(driver);
        utils = new Utils();
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
        if(!actualResult){
            utils.screenShot(pathToScreenShot,driver);
        }
        Assert.assertEquals(message,true,actualResult);
    }

    public void checkCurrentUrl(String message, String actualResult){
        if(!actualResult.equalsIgnoreCase(driver.getCurrentUrl())){
            utils.screenShot(pathToScreenShot,driver);
        }
        Assert.assertEquals(message, driver.getCurrentUrl(), actualResult);
    }

    public void checkRowsCount(int expected){
        if(expected!= dashboardPage.returnContentListCount()){
            utils.screenShot(pathToScreenShot,driver);
            dashboardPage.printListCount();
        }
        Assert.assertEquals("Wrong row count", expected, dashboardPage.returnContentListCount());
    }


}
