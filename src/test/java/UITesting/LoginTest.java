package UITesting;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenURL;

import static UITesting.methodUtil.UITestMethods.checkVisibility;

public class LoginTest extends OpenURL {

    Login login;

    @BeforeClass
    public void InitLogin()
    {
        login = new Login(driver);
    }



    @Test
    public void txtUsernameVisibilityCheck() {
        boolean expected = true;
        boolean actual = checkVisibility(login.txtEmail);
  /*      System.out.println("expected="+expected);
        System.out.println("actual="+actual);*/
        Assert.assertEquals(actual, expected, "email/username text box is not present");
    }

}
