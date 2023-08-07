package pageObject;

import baseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver;

    public LoginPage(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    public By TextLogin = By.xpath("//h1[normalize-space()='LOGIN TO YOUR ACCOUNT']");
    public By Version = By.xpath("//span[starts-with(@class,'remember-me ng-tns')]");

    By UserName = By.xpath("//input[@placeholder='Email']");
    By PassWord = By.xpath("//input[@placeholder='Password']");
    public By LoginButton = By.xpath("//span[normalize-space()='LOGIN']");
    By TextPayment = By.xpath("//div[normalize-space()='Payment Overview']");

    By PaymentDashboard = By.xpath("//div[starts-with(@class,'ngx-charts-outer ng-tns')]//*[name()='svg']");

    /*
        Logout
     */

    By LogoutArrow = By.xpath("//mat-icon[normalize-space()='keyboard_arrow_down']");

    By TextSignOut = By.xpath("(//span[normalize-space()='Sign Out'])[1]");

    public void Login_to_application(String userName,String passWord){
        type(UserName,userName);
        type(PassWord,passWord);
        click(LoginButton);
        WaitForPresenceOfElement(TextPayment,10);
        WaitForPresenceOfElement(PaymentDashboard,10);
    }

    public void Log_out_from_appliaction(){
        click(LogoutArrow);
        WaitForPresenceOfElement(TextSignOut,10);
        click(TextSignOut);
        WaitForPresenceOfElement(TextLogin,10);
        WaitForPresenceOfElement(LoginButton,10);
    }



}
