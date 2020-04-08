package pages;

import basicPage.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealsPage extends BasicPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement dealsPageHeader;

    @FindBy(xpath = "//a[@href='http://v3.test.itpmgroup.com/deal/edit']")
    private WebElement addDealButton;

    public DealsPage(WebDriver driver){
        super(driver);
    }
}
