package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.Login;

public class DoLogin extends OpenURL{

    @BeforeClass
    public void doLogin()
    {
        Login login = new Login(driver);
        login.login("amolujagare@gmail.com","admin123");
    }
}
