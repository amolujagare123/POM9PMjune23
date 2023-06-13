package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.text.ParseException;

public class AddClientTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");
        Login login = new Login(driver);
        login.login("amolujagare@gmail.com","admin123");
    }

    @Test
    public void addClientTest() throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

      //  addClient.setDate("02/03/2019"); // dd/MM/yyyy
        // dd/MM/yyyy




        addClient.enterClientName("A1m2o3l");
        addClient.enterClientSurname("Ujagare");
        addClient.setLanguage("English");//
        addClient.enterClientAddress1("123 Main Street");
        addClient.enterClientAddress2("Apt 4B");
        addClient.enterClientCity("New York");
        addClient.enterClientState("NY");
        addClient.enterClientZip("10001");
        addClient.setCountry("India"); //
        addClient.setContainerGender("Female"); //
         addClient.setDate2("02/03/2019");
        addClient.enterClientPhone("555-123-4567");
        addClient.enterClientFax("555-987-6543");
        addClient.enterClientMobile("555-555-5555");
        addClient.enterClientEmail("john.doe@example.com");
        addClient.enterClientWeb("www.example.com");
        addClient.enterClientVatId("123456789");
        addClient.enterClientTaxCode("ABC123");
        addClient.clickButtonSubmit();


    }
}
