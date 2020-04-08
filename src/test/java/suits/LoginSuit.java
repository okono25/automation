package suits;

import loginTest.InvalidLoginTest;
import loginTest.ValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InvalidLoginTest.class,
        ValidLoginTest.class
})

public class LoginSuit {

}
