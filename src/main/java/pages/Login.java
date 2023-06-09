package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

   /* WebDriver driver;
    WebElement txtEmail = driver.findElement(By.name("email"));*/

    @FindBy (name = "email")
    public WebElement txtEmail;
    @FindBy (name = "password")
    public WebElement txtPassword;
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement btnLogin;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    public WebElement lnkForgotPass;

    @FindBy (xpath= "//label[@for='email']")
    public WebElement lblEmail;

    @FindBy (xpath= "//label[@for='password']")
    public WebElement lblPassword;
    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }
    public void clickForgotPass()
    {
        lnkForgotPass.click();
    }

    public void login(String username,String password)
    {
        setTxtEmail(username);
        setTxtPassword(password);
        clickLogin();
    }
}
