package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private ActionsWithElements actionsWithElements;
    private LoginPage loginPage;
    private Logger logger = Logger.getLogger(DashboardPage.class);
    By dashboardHeader = By.xpath("//section[@class='content-header']//h1");
    By studentName = By.xpath("//span[@class='hidden-xs']");
    By linkToHomePage = By.xpath("//a[@href='/']");
    String DashboardPageUrl = "http://v3.test.itpmgroup.com/";
    By textOnTheDashboardPage = By.xpath("//div[@class='content-wrapper']/p");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.actionsWithElements = new ActionsWithElements(driver);
        this.loginPage = new LoginPage(driver);
    }

    public void clickOnLinkToHomePage(){
        Assert.assertTrue(actionsWithElements.clickLink(linkToHomePage,DashboardPageUrl));
    }
    public void checkText(int rowsCount){
        Assert.assertEquals(actionsWithElements.findElementsCount(driver,textOnTheDashboardPage),rowsCount);
    }


}
