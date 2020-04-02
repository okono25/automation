package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.function.Function;

public class ActionsWithElements {

    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithElements(WebDriver driver){
        this.driver = driver;
    }

    public void inputTextToField(By element, String text){
        try {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(text);
            logger.info("Text was inputted successfully");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error with text inputting");
        }
    }

    public void clickButton(By element){
        try {
            driver.findElement(element).click();
            logger.info("Button was clicked ");
        }catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Error has happened during button clicking");
        }
    }

    public boolean clickLink(By element, String resultUrl){
        try{
            driver.findElement(element).click();
            if(driver.getCurrentUrl().equals(resultUrl)){
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            logger.info("Error happened during clicking on link");
        }
        return false;
    }

    public boolean isElementDisplayed(By element){
        try{
            return driver.findElement(element).isDisplayed();
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during displaying checking");
            return false;
        }
    }

    public boolean isElementVisible(By element){
        try{
            return driver.findElement(element).isDisplayed();
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during visibility checking");
            return false;
        }
    }

    public void setCheckbox(By element, boolean state){
        try {
            if (driver.findElement(element).isEnabled() != state) {
                driver.findElement(element).click();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during checkbox state changes");
        }
    }

    public void selectElementFromDropdownByText(By element, String text){
        try {
            Select select = new Select(driver.findElement(element));
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

    public int findElementsCount(WebDriver driver, By locator){
       return driver.findElements(locator).size();
    }

}
