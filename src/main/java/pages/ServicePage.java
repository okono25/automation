package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServicePage {

    private WebDriver driver;
    private ActionsWithElements actionsWithElements;
    private Logger logger = Logger.getLogger(LoginPage.class);
    By serviceHeader = By.xpath("//section[@class='content-header']//h1");
    By addWorkRecordButton = By.xpath("//section[@class='content-header']//h1");

    public ServicePage(WebDriver driver){
        this.driver = driver;
        this.actionsWithElements = new ActionsWithElements(driver);
    }
}
