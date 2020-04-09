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

    public void clickOnElementsFromTheTreeMenu(WebElement menuHeader, List<WebElement> elementsList, String text){
        try{
            menuHeader.click();
            for(int i=0; i<elementsList.size(); i++){
                if(elementsList.get(i).getText().equals(text)){
                    elementsList.get(i).click();
                    logger.info("Element was found and clicked");
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Element isn't clicked");
        }
    }

    public int getListSize(List<WebElement> list){
        try {
            return list.size();
        }catch (Exception ex){
            logger.error("Error happened during size returning");
        }
        return -1;
    }

    public boolean checklistFromTwoColumns(List<WebElement> column1, List<WebElement> column2, String column1Value, String column2Value){
        try {
            String lastColumn1element = column1.get(column1.size() - 1).getText();
            String lastColumn2element = column2.get(column2.size() - 1).getText();
            return lastColumn1element.equals(column1Value) && lastColumn2element.equals(column2Value);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
