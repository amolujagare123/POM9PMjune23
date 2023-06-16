package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import utility.DoLogin;

import java.io.IOException;
import java.text.ParseException;

import static utility.ForDataProvider.getMyData;

public class AddClientDataProviderTest extends DoLogin {


    @Test (dataProvider = "getData")
    public void addClientTest(
            String name,String surname,String language,String address1,
            String address2,String city,String state,String zip,String country,
            String gender,String birthDate,String phone,String fax,String mobile,
            String email,String web,String vat,String tax,String expected,String xpathActual
    ) throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.enterClientName(name);
        addClient.enterClientSurname(surname);
        addClient.setLanguage(language);
        addClient.enterClientAddress1(address1);
        addClient.enterClientAddress2(address2);
        addClient.enterClientCity(city);
        addClient.enterClientState(state);
        addClient.enterClientZip(zip);
        addClient.setCountry(country);
        addClient.setContainerGender(gender);
        addClient.setDate2(birthDate);
        addClient.enterClientPhone(phone);
        addClient.enterClientFax(fax);
        addClient.enterClientMobile(mobile);
        addClient.enterClientEmail(email);
        addClient.enterClientWeb(web);
        addClient.enterClientVatId(vat);
        addClient.enterClientTaxCode(tax);

        addClient.clickButtonSubmit();

        String actual = "";

        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/InvoicePlane.xlsx","Sheet1");
    }
}
