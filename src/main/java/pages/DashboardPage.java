package pages;

import basicPage.BasicPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class DashboardPage extends BasicPage {

  @FindBy(xpath = "//section[@class='content-header']//h1")
  private WebElement dashboardHeader;

  @FindBy(xpath = "//div[@class='pull-left image']")
  private WebElement userAvatar;

 // @FindBy(xpath = "//a[@href='/']")
 // private WebElement linkToHomePage;

  @FindAll(@FindBy(xpath = "//div[@class='box-body']//div[@class='box-body']//p"))
  private ArrayList<String> rowList;

  //String DashboardPageUrl = "http://v3.test.itpmgroup.com/";
  String titleLogged = "Учет запчастей";
  int rowsCountForDashboardPage = 5;

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
      return actionsWithElements.isElementDisplayed(dashboardHeader);
  }

    public void checkLoggedTitle(){
        Assert.assertEquals(driver.getTitle(),titleLogged);
    }

    public int checkRowCount(){
        //Assert.assertEquals("Wrong rows count", rowList.size(), rowsCountForDashboardPage);
      return rowList.size();
    }

    public String getDashboardPageUrl(){
      return DashboardPageUrl;
    }
}
