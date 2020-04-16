package apparatTest;

import org.junit.Test;

public class ClickOnLinkToDictionaryPageTest extends AddNewDictionaryTest {

    @Test
    public void clickOnLinkToDictionaryPage() {
        loginPage.openUrl();
        loginPage.loginToSite("Student", "909090");
        apparatPage.openApparatPage();
        apparatPage.clickOnDictionaryLink();
        checkExpectedResult("Dictionary header isn't displayed",dictionaryPage.isDictionaryHeaderDisplayed());
        checkCurrentUrl("False page is opened",dictionaryPage.getDictionaryUrl());
    }
}
