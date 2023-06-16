package DatabaseTesting;

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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static utility.ForDataProvider.getMyData;
import static util.Conversion.*;

public class AddClientDataProviderTest extends DoLogin {


    @Test (dataProvider = "getData")
    public void addClientTest(
            String name,String surname,String language,String address1,
            String address2,String city,String state,String zip,String country,
            String gender,String birthDate,String phone,String fax,String mobile,
            String email,String web,String vat,String tax
    ) throws ParseException, ClassNotFoundException, SQLException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();


        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthDate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);


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

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/ip",
                        "root","root");
        Statement st = con.createStatement();
        String sql = "select * from ip_clients where client_name='"+name+"'";
        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullFormCountry = convertCountry(shortCountry);
            actual.add(fullFormCountry);
           // actual.add(rs.getString("client_country"));

            actual.add(convertGender(rs.getString("client_gender")));

            actual.add(convertDate(rs.getString("client_birthdate")));

            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }



        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/InvoicePlane.xlsx","add client");
    }
}
