package pages;

import basicPage.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealPage extends BasicPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement dealPageHeader;

    @FindBy(xpath = "//a[@href='http://v3.test.itpmgroup.com/deal/edit']")
    private WebElement addDealButton;

    @FindBy(id = "deal_dealDate_date_day")
    private WebElement dealDay;

    @FindBy(id = "deal_dealDate_date_month")
    private WebElement dealMonth;

    @FindBy(id = "deal_dealDate_date_year")
    private WebElement dealYear;

    @FindBy(id = "deal_dealDate_time_hour")
    private WebElement dealHour;

    @FindBy(id = "deal_dealDate_time_minute")
    private WebElement dealMinute;

    @FindBy(id = "deal_dealType")
    private WebElement dealType;

    @FindBy(id = "deal_customer")
    private WebElement customer;

    @FindBy(id = "deal_provider")
    private WebElement provider;

    @FindBy(name = "add")
    private WebElement createDealButton;

    @FindBy(xpath = "//tr")
    private List<WebElement> list;

    public DealPage(WebDriver driver){
        super(driver);
    }

    public boolean isDealHeaderDisplayed(){
        String dealHeader = "Сделки";
        return (actionsWithElements.isElementDisplayed(dealPageHeader) && dealPageHeader.getText().contains(dealHeader));
    }

    public void openDealPage(){
        actionsWithElements.clickLink(deals);
    }

    public void clickOnAddDealButton(){
        actionsWithElements.clickButton(addDealButton);
    }

    public void chooseDealType(String dealText){
        actionsWithElements.selectElementFromDropdownByText(dealType, dealText);
    }

    public void chooseCustomer(String customer){
        actionsWithElements.selectElementFromDropdownByText(this.customer, customer);
    }

    public void chooseProvider(String provider){
        actionsWithElements.selectElementFromDropdownByText(this.provider, provider);
    }

    public void chooseDealDate(String day, String month, String year, String hour, String minute){
        actionsWithElements.selectElementFromDropdownByText(this.dealDay, day);
        actionsWithElements.selectElementFromDropdownByText(this.dealMonth, month);
        actionsWithElements.selectElementFromDropdownByText(this.dealYear, year);
        actionsWithElements.selectElementFromDropdownByText(this.dealHour, hour);
        actionsWithElements.selectElementFromDropdownByText(this.dealMinute, minute);

    }
    public void clickOnCreateDealButton(){
        actionsWithElements.clickButton(createDealButton);
    }

    public void createDeal(String dealText, String customer, String provider, String day, String month, String year, String hour, String minute){
        chooseDealType(dealText);
        chooseCustomer(customer);
        chooseProvider(provider);
        chooseDealDate(day, month, year, hour, minute);
        clickOnCreateDealButton();
    }

    public boolean isNewDealDisplayed(String dealText, String customer, String provider, String hour, String minute){
       return getMatchingFromFourColumnsOfTheDealList(list, dealText, customer, provider, hour, minute);
    }

    public boolean getMatchingFromFourColumnsOfTheDealList(List<WebElement> list, String dealText, String customer, String provider, String hour, String minute){
        try {
            int listSize = actionsWithElements.getListSize(list) - 1;
            List<WebElement> webElementList = driver.findElements(By.xpath("//tr[" + listSize + "]/td"));
            String timeVariable = hour + ":" + minute;
            int counter = 0;
            for(int i = 0; i < webElementList.size(); i++){
                if(webElementList.get(i).getText().equals(dealText) || webElementList.get(i).getText().equals(customer) || webElementList.get(i).getText().equals(provider)
                        || webElementList.get(i).getText().contains(timeVariable)){
                    counter++;
                }
            }
            return counter == webElementList.size();

        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Error has happened during matching");
            return false;
        }
    }
}
