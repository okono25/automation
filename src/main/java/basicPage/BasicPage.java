package basicPage;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class BasicPage {

    protected WebDriver driver;
    protected ActionsWithElements actionsWithElements;
    protected Logger logger = Logger.getLogger(LoginPage.class);

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.actionsWithElements = new ActionsWithElements(driver);
        PageFactory.initElements(driver,this);
    }
}
