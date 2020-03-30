package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver driver;
    private ActionsWithElements actionsWithElements;
    private static Logger logger = Logger.getLogger(LoginPage.class);
    By inputLoginName = By.name("_username");
    By inputPasswordName = By.name("_password");
    By inputButtonXpath = By.xpath("//button[@type='submit']");
    String url = "http://v3.test.itpmgroup.com/login";
    String title = "Account of spare:Авторизация";

    public static WebDriver driverInit(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public void tearDown(){
        driver.close();
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.actionsWithElements = new ActionsWithElements(driver);
    }

    public void openUrl(){
        try{
            driver.get(url);
            Assert.assertEquals(driver.getTitle(), title);
            logger.info("Page is opened");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during page opening");
        }
    }

    public void inputLogin(String login){
        actionsWithElements.inputTextToField(inputLoginName,login);
    }

    public void inputPassword(String password){
        actionsWithElements.inputTextToField(inputPasswordName,password);
    }

    public void clickSubmit(){
        driver.findElement(inputButtonXpath).click();
    }

    public void loginToPage(String login, String password){
        openUrl();
        inputLogin(login);
        inputPassword(password);
        clickSubmit();
        tearDown();
    }
}
