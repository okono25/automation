package pages;

import basicPage.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ApparatPage extends BasicPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement apparatPageHeader;

    @FindBy(xpath = "//a[@data-original-title='Add']")
    private WebElement addApparatButton;

    @FindBy(id="apparat_apparatNumber")
    private WebElement apparatNumber;

    @FindBy(id = "apparat_apparatComment")
    private WebElement apparatComment;

    @FindBy(name="add")
    private WebElement createDictionaryButton;

    @FindBy(xpath = "//tbody//tr/td[1]")
    private List<WebElement> numbersColumn;

    @FindBy(xpath = "//tbody//tr/td[2]")
    private List<WebElement> commentsColumn;

    @FindBy(xpath = "//a[@href = \"/dictionary\"]")
    private  WebElement dictionaryLink;

    public ApparatPage(WebDriver driver) {
        super(driver);
    }

    public void openApparatPage(){
        actionsWithElements.clickOnElementsFromTheTreeMenu(dictionaries,dictionaryMenu,"Аппарат");
    }

    public boolean isApparatHeaderDisplayed(){
        return actionsWithElements.isElementDisplayed(apparatPageHeader);
    }

    public void inputApparatNumber(String number){
        actionsWithElements.inputTextToField(apparatNumber,number);
    }

    public void inputApparatComment(String comment){
        actionsWithElements.inputTextToField(apparatComment,comment);
    }

    public void clickCreateButton(){
        actionsWithElements.clickButton(createDictionaryButton);
    }

    public void clickAddDictionaryButon(){
        actionsWithElements.clickButton(addApparatButton);
    }

    public void clickOnLinkToHomePage(){
        actionsWithElements.clickLink(linkToHomePage);
    }

    public void clickOnDictionaryLink(){
        actionsWithElements.clickLink(dictionaryLink);
    }

    public void createDictionary(String number, String comment){
        clickAddDictionaryButon();
        inputApparatNumber(number);
        inputApparatComment(comment);
        clickCreateButton();
    }

    public boolean isNewApparatDisplayed(String number, String column){
        return actionsWithElements.getMatchingFromTwoColumns(numbersColumn, commentsColumn, number, column);
    }
}
