package pages;

import basicPage.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparatPage extends BasicPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement apparatPageHeader;

    @FindBy(xpath = "//a[@href='http://v3.test.itpmgroup.com/dictionary/apparat/edit")
    private WebElement addApparatButton;

    public ApparatPage(WebDriver driver) {
        super(driver);
    }

    public void openApparatPage(){
        actionsWithElements.selectElementFromDropdownByText(dropdownDictionaries,"Аппарат");
    }

    public void isApparatHeaderDisplayed(){
        actionsWithElements.isElementDisplayed(apparatPageHeader);
    }

}
