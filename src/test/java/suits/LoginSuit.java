package suits;

import loginTest.InvalidLoginTest;
import loginTest.ValidLoginTest;
import loginTest.ValidLoginTestWithExcel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InvalidLoginTest.class,
        ValidLoginTest.class,
        ValidLoginTestWithExcel.class
})

public class LoginSuit {

}
