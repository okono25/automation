package pages;

import basicPage.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProviderPage extends BasicPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement providersPageHeader;

    @FindBy(xpath = "//a[@data-original-title='Add']")
    private WebElement addProviderButton;

    @FindBy(id = "prov_cus_proCustName")
    private WebElement proCustomerName;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement proCustomerAddress;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement proCustomerPhone;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privateCustomerCheckbox;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement isOurFirmCheckbox;

    @FindBy(name = "add")
    private WebElement createProviderButton;

    @FindBy(xpath = "//tr")
    private List<WebElement> list;

    private String headerName = "Стороны сделок";

    public ProviderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProviderHeaderDisplayed() {
        return (actionsWithElements.isElementDisplayed(providersPageHeader) && providersPageHeader.getText().contains(headerName));
    }

    public void inputCustomerName(String customerName) {
        actionsWithElements.inputTextToField(proCustomerName, customerName);
    }

    public void inputCustomerAddress(String customerAddress) {
        actionsWithElements.inputTextToField(proCustomerAddress, customerAddress);
    }

    public void inputCustomerPhone(String customerPhone) {
        actionsWithElements.inputTextToField(proCustomerPhone, customerPhone);
    }

    public void setPrivateCustomerCheckbox() {
        actionsWithElements.setCheckbox(privateCustomerCheckbox, true);
    }

    public void setIsOurFirmCheckbox() {
        actionsWithElements.setCheckbox(isOurFirmCheckbox, true);
    }

    public void clickCreateProviderButton() {
        actionsWithElements.clickButton(createProviderButton);
    }

    public void createProviderPrivate(String customerName, String customerAddress, String customerPhone) {
        clickOnAddProviderButton();
        inputCustomerName(customerName);
        inputCustomerAddress(customerAddress);
        inputCustomerPhone(customerPhone);
        setPrivateCustomerCheckbox();
        clickCreateProviderButton();
    }

    public void createProviderOwn(String customerName, String customerAddress, String customerPhone) {
        clickOnAddProviderButton();
        inputCustomerName(customerName);
        inputCustomerAddress(customerAddress);
        inputCustomerPhone(customerPhone);
        setIsOurFirmCheckbox();
        clickCreateProviderButton();
    }

    public void openProviderPage() {
        actionsWithElements.clickOnElementsFromTheTreeMenu(dictionaries, dictionaryMenu, "Стороны сделок");
    }

    public void clickOnAddProviderButton() {
        actionsWithElements.clickButton(addProviderButton);
    }

    public boolean getMatchingFromTheProviderPage(List<WebElement> list, String customerName, String customerAddress, String customerPhone) {
        try {
            int listSize = actionsWithElements.getListSize(list) - 1;
            List<WebElement> webElementList = driver.findElements(By.xpath("//tr[" + listSize + "]/td"));
            int counter = 0;
            for (int i = 0; i < webElementList.size()-1; i++) {
                if (webElementList.get(i).getText().equals(customerName) || webElementList.get(i).getText().equals(customerAddress) || webElementList.get(i).getText().equals(customerPhone)) {
                    counter++;
                }
            }
            return counter == webElementList.size()-1;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Error has happened during matching");
            return false;
        }
    }

    public boolean isNewProviderDisplayed(String customerName, String customerAddress, String customerPhone){
        return getMatchingFromTheProviderPage(list, customerName, customerAddress, customerPhone);
    }

    public boolean checkProviderState(List<WebElement> list, boolean privateState){
        int listSize = actionsWithElements.getListSize(list) - 1;
        WebElement privateColumn = driver.findElement(By.xpath("//tr[" + listSize + "]/td/span"));
        return (privateColumn.getText().equals("1") == privateState);
    }

    public boolean isProviderPrivate(boolean privateState){
        return checkProviderState(list, privateState);
    }
}
