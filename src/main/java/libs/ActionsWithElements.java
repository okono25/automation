package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ActionsWithElements {

    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithElements(WebDriver driver){
        this.driver = driver;
    }

    public void inputTextToField(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("Text was inputted successfully");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error with text inputting");
        }
    }

    public void clickButton(WebElement element){
        try {
            element.click();
            logger.info("Button was clicked ");
        }catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Error has happened during button clicking");
        }
    }

    public void clickLink(WebElement element){
        try{
            element.click();
            logger.info("Link was clicked ");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.info("Error happened during clicking on link");
        }
    }

    public boolean isElementDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during displaying checking");
            return false;
        }
    }

    public boolean isElementVisible(WebElement element){
        try{
            return element.isDisplayed();
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during visibility checking");
            return false;
        }
    }

    public void setCheckbox(WebElement element, boolean state){
        try {
            if (element.isEnabled() != state) {
                element.click();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during checkbox state changes");
        }
    }

    public void selectElementFromDropdownByText(WebElement element, String text){
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info("Dropdown item - " + text + " is selected");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error happened during dropdown element selection");
        }
    }

    public void waitForInvisibility(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
           wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void printWebElementsFromTheList(List<WebElement> list){
        try {
            for (int i = 0; i < list.size(); i++) {
               logger.info(list.get(i).getText());
            }
            logger.info("Elements were printed");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Printing error has happened");
        }
    }

    public int findElementsCount(WebDriver driver, By locator){
       return driver.findElements(locator).size();
    }


}
