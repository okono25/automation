package dealTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class AddDealTest extends AbstractBasicTest {

    @Test
    public void addDealTest(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        dealPage.openDealPage();
        dealPage.clickOnAddDealButton();
        dealPage.createDeal
                ("Продажа","test","QATestLab","01","мая","2022","10","23");
        checkExpectedResult("New deal isn't added", dealPage.isNewDealDisplayed
               ("Продажа","test","QATestLab","10","23"));

    }
}
