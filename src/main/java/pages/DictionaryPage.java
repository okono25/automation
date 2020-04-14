package pages;

import basicPage.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DictionaryPage extends BasicPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement dictionaryHeader;

    String dictionaryUrl = "http://v3.test.itpmgroup.com/dictionary";

    public DictionaryPage(WebDriver driver){
        super(driver);
    }

    public String getDictionaryUrl(){
        return dictionaryUrl;
    }

    public boolean isDictionaryHeaderDisplayed(){
        return actionsWithElements.isElementDisplayed(dictionaryHeader);
    }
}
