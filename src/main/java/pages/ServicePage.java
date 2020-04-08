package pages;

import basicPage.BasicPage;
import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicePage extends BasicPage {


    @FindBy(xpath = "//section[@class='content-header']//h1")
            private WebElement serviceHeader;

    @FindBy(xpath = "//section[@class='content-header']//h1")
            private WebElement addWorkRecordButton;

    public ServicePage(WebDriver driver){
       super(driver);
    }


    public void isServiceHeaderDisplayed(){
         actionsWithElements.isElementDisplayed(serviceHeader);
    }
}
