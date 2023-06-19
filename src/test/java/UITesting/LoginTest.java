package UITesting;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenURL;

import static UITesting.methodUtil.UITestMethods.*;


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

    @Test
    public void txtpasswordVisibilityCheck() {
        boolean expected = true;
        boolean actual = checkVisibility(login.txtPassword);
  /*      System.out.println("expected="+expected);
        System.out.println("actual="+actual);*/
        Assert.assertEquals(actual, expected, "password text box is not present");
    }

    @Test
    public void txtUsernameEnabilityCheck()
    {
        boolean expected = true;
        boolean actual = checkEnability(login.txtEmail);
        Assert.assertEquals(actual, expected, "email/username text box is not enabled");
    }

    @Test
    public void txtPasswordEnabilityCheck()
    {
        boolean expected = true;
        boolean actual = checkEnability(login.txtPassword);
        Assert.assertEquals(actual, expected, "password text box is not enabled");
    }
    @Test
    public void lblEmailSpellCheck()
    {
        String expected ="Email";
        String actual = spellCheck(login.lblEmail);
        Assert.assertEquals(actual, expected, "wrong spelling or" +
                "Element not present");
    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected ="Password";
        String actual = spellCheck(login.lblPassword);
        Assert.assertEquals(actual, expected, "wrong spelling or" +
                "Element not present");
    }

    @Test
    public void lblForgotPasswordSpellCheck()
    {
        String expected ="I forgot my password";
        String actual = spellCheck(login.lnkForgotPass);
        Assert.assertEquals(actual, expected, "wrong spelling or" +
                "Element not present");
    }

    @Test
    public void txtUsernameWatermarkCheck()
    {
        String expected ="Email";
        String actual = getElementAttributeValue(login.txtEmail,"placeholder");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual, expected, "wrong watermark" +
                "Element not present");

    }

    @Test
    public void txtPasswordWatermarkCheck()
    {
        String expected ="Password";
        String actual = getElementAttributeValue(login.txtPassword,"placeholder");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual, expected, "wrong watermark" +
                "Element not present");

    }

    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected = "14px";
        String actual = getElementCssValue(login.lblPassword,"font-size");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual, expected, "wrong font" +
                "Element not present");


    }

    @Test
    public void lblPasswordFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = getElementCssValue(login.lblPassword,"font-family");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual, expected, "wrong font" +
                "Element not present");


    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";
        String actual = getElementColor(login.btnLogin,"background-color");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual, expected, "wrong font" +
                "Element not present");

    }
}
