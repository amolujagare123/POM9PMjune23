package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class OpenURL {

    public static WebDriver driver;

    @BeforeClass
    public void openUrl()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");
    }
}
