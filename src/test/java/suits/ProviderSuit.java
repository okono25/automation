package suits;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import providerTest.AddNewProviderPersonal;
import providerTest.AddNewProviderPrivate;
import providerTest.BasicProviderTest;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            AddNewProviderPersonal.class,
            AddNewProviderPrivate.class,
            BasicProviderTest.class,
    })

    public class ProviderSuit {
    }

