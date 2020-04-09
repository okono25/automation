package apparatTest;

import basicTest.AbstractBasicTest;
import org.junit.Test;

public class AddNewDictionaryTest extends AbstractBasicTest {

    @Test
    public void addingNewDictionary(){
        loginPage.openUrl();
        loginPage.loginToSite("Student","909090");
        apparatPage.openApparatPage();
        apparatPage.createDictionary("12345","Comment");
        checkExpectedResult("New comment isn't added",apparatPage.isNewApparatDisplayed("12345","Comment"));
    }
}
