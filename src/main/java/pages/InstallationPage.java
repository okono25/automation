package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstallationPage {

    private WebDriver driver;
    private ActionsWithElements actionsWithElements;
    Logger logger = Logger.getLogger(InstallationPage.class);
    By installationHeader = By.xpath("//section[@class='content-header']//h1");
    By addWorkListButton = By.xpath("//a[@class='btn btn-info btn-sm']");

    public InstallationPage(WebDriver driver){
        this.driver = driver;
        actionsWithElements = new ActionsWithElements(driver);
    }

}
