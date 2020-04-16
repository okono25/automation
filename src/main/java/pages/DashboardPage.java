package pages;

import basicPage.BasicPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DashboardPage extends BasicPage {

  @FindBy(xpath = "//section[@class='content-header']//h1")
  private WebElement dashboardPageHeader;

  @FindBy(xpath = "//div[@class='pull-left image']")
  private WebElement userAvatar;

  @FindBy(xpath = "//div[@class='content-wrapper']//p")
  private List<WebElement> contentList;

  String titleLogged = "Учет запчастей";

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public void clickOnLinkToHomePage(){
        actionsWithElements.clickLink(linkToHomePage);
    }

    public boolean isAvatarDisplayed(){
        return actionsWithElements.isElementDisplayed(userAvatar);
    }

    public boolean isDashboardHeaderDisplayed(){
       String dashboardHeader = "Главная";
       return (actionsWithElements.isElementDisplayed(dashboardPageHeader) && dashboardPageHeader.getText().contains(dashboardHeader));
  }

  public void checkLoggedTitle(){
        Assert.assertEquals(driver.getTitle(),titleLogged);
    }

    public int returnContentListCount(){
        return contentList.size();
    }

  public void logOut(){
        actionsWithElements.clickButton(dropdownLoginToggle);
        actionsWithElements.clickButton(logOutButton);
  }

  public String getDashboardPageUrl(){
        return DashboardPageUrl;
    }
}
