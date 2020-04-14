package basicPage;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.util.List;

public class BasicPage {

    protected WebDriver driver;
    protected ActionsWithElements actionsWithElements;
    protected Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//a[@href='/']")
    protected WebElement linkToHomePage;

    @FindBy(xpath = "//li[@id='dictionary']")
    protected WebElement dictionaries;

    @FindBy(xpath = "//li[@id='deal']")
    protected WebElement deals;

    @FindBy(xpath = "//ul[@class='treeview-menu']/li/a")
    protected List<WebElement> dictionaryMenu;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    protected WebElement dropdownLoginToggle;

    @FindBy(xpath = "//a[@href='/logout']")
    protected WebElement logOutButton;

    protected String DashboardPageUrl = "http://v3.test.itpmgroup.com/";

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.actionsWithElements = new ActionsWithElements(driver);
        PageFactory.initElements(driver,this);
    }
}
