package pages;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClient {
/*
    @FindBy (xpath = "//input[@id='client_name']") WebElement element;
    @FindBy (xpath = "//input[@id='client_surname']") WebElement element;
    @FindBy (xpath = "//input[@id='client_address_1']") WebElement element;
    @FindBy (xpath = "//input[@id='client_address_2']") WebElement element;
    @FindBy (xpath = "//input[@id='client_city']") WebElement element;
    @FindBy (xpath = "//input[@id='client_state']") WebElement element;
    @FindBy (xpath = "//input[@id='client_zip']") WebElement element;
    @FindBy (xpath = "//input[@id='client_phone']") WebElement element;
    @FindBy (xpath = "//input[@id='client_fax']") WebElement element;
    @FindBy (xpath = "//input[@id='client_mobile']") WebElement element;
    @FindBy (xpath = "//input[@id='client_email']") WebElement element;
    @FindBy (xpath = "//input[@id='client_web']") WebElement element;
    @FindBy (xpath = "//input[@id='client_vat_id']") WebElement element;

    @FindBy (xpath = "//input[@id='client_tax_code']") WebElement element;*/

    WebDriver driver;
    @FindBy(xpath = "//input[@id='client_name']")
    private WebElement clientNameInput;

    @FindBy(xpath = "//input[@id='client_surname']")
    private WebElement clientSurnameInput;

    @FindBy(xpath = "//input[@id='client_address_1']")
    private WebElement clientAddress1Input;

    @FindBy(xpath = "//input[@id='client_address_2']")
    private WebElement clientAddress2Input;

    @FindBy(xpath = "//input[@id='client_city']")
    private WebElement clientCityInput;

    @FindBy(xpath = "//input[@id='client_state']")
    private WebElement clientStateInput;

    @FindBy(xpath = "//input[@id='client_zip']")
    private WebElement clientZipInput;

    @FindBy(xpath = "//input[@id='client_phone']")
    private WebElement clientPhoneInput;

    @FindBy(xpath = "//input[@id='client_fax']")
    private WebElement clientFaxInput;

    @FindBy(xpath = "//input[@id='client_mobile']")
    private WebElement clientMobileInput;

    @FindBy(xpath = "//input[@id='client_email']")
    private WebElement clientEmailInput;

    @FindBy(xpath = "//input[@id='client_web']")
    private WebElement clientWebInput;

    @FindBy(xpath = "//input[@id='client_vat_id']")
    private WebElement clientVatIdInput;

    @FindBy(xpath = "//input[@id='client_tax_code']")
    private WebElement clientTaxCodeInput;

    @FindBy(xpath = "//button[@id='btn-submit']")
    WebElement btnSubmit;

    public AddClient(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id="select2-client_language-container")
    WebElement containerLanguage;

    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement searchBox;
    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }

    @FindBy (id="select2-client_country-container")
    WebElement containerCountry;

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();

    }


    @FindBy (id="select2-client_gender-container")
    WebElement containerGender;

    public void setContainerGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }

    // Action methods for the elements

    public void clickButtonSubmit()
    {
        btnSubmit.click();
    }
    public void enterClientName(String name) {
        clientNameInput.sendKeys(name);
    }

    public void enterClientSurname(String surname) {
        clientSurnameInput.sendKeys(surname);
    }

    public void enterClientAddress1(String address1) {
        clientAddress1Input.sendKeys(address1);
    }

    public void enterClientAddress2(String address2) {
        clientAddress2Input.sendKeys(address2);
    }

    public void enterClientCity(String city) {
        clientCityInput.sendKeys(city);
    }

    public void enterClientState(String state) {
        clientStateInput.sendKeys(state);
    }

    public void enterClientZip(String zip) {
        clientZipInput.sendKeys(zip);
    }

    public void enterClientPhone(String phone) {
        clientPhoneInput.sendKeys(phone);
    }

    public void enterClientFax(String fax) {
        clientFaxInput.sendKeys(fax);
    }

    public void enterClientMobile(String mobile) {
        clientMobileInput.sendKeys(mobile);
    }

    public void enterClientEmail(String email) {
        clientEmailInput.sendKeys(email);
    }

    public void enterClientWeb(String web) {
        clientWebInput.sendKeys(web);
    }

    public void enterClientVatId(String vatId) {
        clientVatIdInput.sendKeys(vatId);
    }

    public void enterClientTaxCode(String taxCode) {
        clientTaxCodeInput.sendKeys(taxCode);
    }

    @FindBy (xpath = "//input[@id='client_birthdate']")
    WebElement txtDate;

    public void setDate2(String setDateStr) throws ParseException // dd/MM/yyyy
    {
       // txtDate.sendKeys(setDateStr);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+setDateStr+"')",txtDate);
    }

    public void setDate(String setDateStr) throws ParseException // dd/MM/yyyy
    {
        txtDate.click();

        String currDateStr = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();
        //MMMM yyyy

        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);
        System.out.println("setDate="+setDate);
        System.out.println("currDate="+currDate);

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1)
                ,new DateTime(setDate).withDayOfMonth(1)).getMonths();

        System.out.println("monthDiff="+monthDiff);
        boolean flag=true;
        if (monthDiff<0)
        {
            flag=false;
            monthDiff = (-1) * monthDiff ;
        }

        for (int i=0;i<monthDiff;i++)
        {
            if (flag)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click(); // next
            else
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev']")).click(); // prev
        }

        String day = new SimpleDateFormat("dd").format(setDate);
        int dayInt = Integer.parseInt(day);

        driver.findElement(By.xpath("//td[normalize-space()='"+dayInt+"'][@class='day']")).click();
    }
}
