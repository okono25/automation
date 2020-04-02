package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private ActionsWithElements actionsWithElements;
    private Logger logger = Logger.getLogger(LoginPage.class);
    By inputLoginName = By.name("_username");
    By inputPasswordName = By.name("_password");
    By inputButtonXpath = By.xpath("//button[@type='submit']");
    By authorizationHeader = By.xpath("//p[@class='login-box-msg']");
    String url = "http://v3.test.itpmgroup.com/login";
    String titleUnlogged = "Account of spare:Авторизация";
    String titleLogged = "Учет запчастей";
    String emptyString = "";

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
            Assert.assertEquals(driver.getTitle(), titleUnlogged);
            Assert.assertTrue(actionsWithElements.isElementDisplayed(authorizationHeader));
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

    public void checkUserIsntLogged(){
        Assert.assertEquals(driver.findElement(inputPasswordName).getText(),emptyString);
        Assert.assertTrue(actionsWithElements.isElementDisplayed(authorizationHeader));
    }
    public void checkUserIsLogged(){
        actionsWithElements.waitForInvisibility(driver,authorizationHeader);
        Assert.assertEquals(driver.getTitle(),titleLogged);
    }

    public void loginToPageSuccessfulResult(String login, String password) {
        inputLogin(login);
        inputPassword(password);
        clickSubmit();
        checkUserIsLogged();
    }

    public void loginToPageFalseResult(String login, String password){
        inputLogin(login);
        inputPassword(password);
        clickSubmit();
        checkUserIsntLogged();
    }
}
