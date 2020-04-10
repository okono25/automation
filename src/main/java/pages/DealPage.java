package pages;

import basicPage.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealPage extends BasicPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement dealHeader;

    @FindBy(xpath = "//a[@href='http://v3.test.itpmgroup.com/deal/edit']")
    private WebElement addDealButton;

    @FindBy(id = "deal_dealType")
    private WebElement dealType;

    @FindBy(id = "deal_customer")
    private WebElement customer;

    @FindBy(id = "deal_provider")
    private WebElement provider;

    @FindBy(name = "add")
    private WebElement createDealButton;

    public DealPage(WebDriver driver){
        super(driver);
    }

    public boolean isDealHeaderDisplayed(){
        return actionsWithElements.isElementDisplayed(dealHeader);
    }

    public void openDealPage(){
        actionsWithElements.clickLink(deals);
    }
}
