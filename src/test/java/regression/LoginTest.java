package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenURL;

public class LoginTest extends OpenURL {

    @Test
    public void loginTest()
    {

        Login login = new Login(driver);

    /*  login.setTxtEmail("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();*/

       login.login("amolujagare@gmail.com","admin123");
    }
}
