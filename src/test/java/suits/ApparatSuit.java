package suits;

import apparatTest.AddNewDictionaryTest;
import apparatTest.BasicApparatTest;
import apparatTest.ClickOnLinkToDictionaryPageTest;
import apparatTest.ClickOnLinkToHomePageTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            AddNewDictionaryTest.class,
            BasicApparatTest.class,
            ClickOnLinkToDictionaryPageTest.class,
            ClickOnLinkToHomePageTest.class
    })

    public class ApparatSuit {
    }


