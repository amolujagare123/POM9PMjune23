package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import utility.OpenURL;

public class ForgotPasswordTest extends OpenURL {

    @Test
    public void forgotPasswordTest()
    {
        Login login = new Login(driver);
        login.clickForgotPass();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@gmail.com");
        forgotPassword.clickReset();
    }
}
