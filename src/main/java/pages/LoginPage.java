package pages;

import basicPage.BasicPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage{

    @FindBy(name = "_username")
            private WebElement inputLoginName;

    @FindBy(name = "_password")
            private WebElement inputPasswordName;

    @FindBy(xpath = "//button[@type='submit']")
            private WebElement inputButtonXpath;

    @FindBy(xpath = "//div[@class='login-box-body']")
            private WebElement loginBox;


    String url = "http://v3.test.itpmgroup.com/login";
    String titleUnlogged = "Account of spare:Авторизация";
    String emptyString = "";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void openUrl(){
        try{
            driver.get(url);
            checkPageIsLoaded();
            logger.info("Page is opened");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during page opening");
        }
    }

    public void checkPageIsLoaded(){
        Assert.assertTrue(actionsWithElements.isElementDisplayed(loginBox));
    }

    public void inputLogin(String login){
        actionsWithElements.inputTextToField(inputLoginName,login);
    }

    public void inputPassword(String password){
        actionsWithElements.inputTextToField(inputPasswordName,password);
    }

    public void clickSubmit(){
       inputButtonXpath.click();
    }

    public void checkUserIsntLogged(){
        Assert.assertEquals(inputPasswordName.getText(),emptyString);
        Assert.assertTrue(actionsWithElements.isElementDisplayed(loginBox));
    }

    public boolean isLoginBoxDisplayed(){
        return actionsWithElements.isElementDisplayed(loginBox);
    }

    public void loginToSite(String login, String password) {
        inputLogin(login);
        inputPassword(password);
        clickSubmit();
    }

    public void checkUnLoggedTitle(){
        Assert.assertEquals(driver.getTitle(),titleUnlogged);
    }

}
