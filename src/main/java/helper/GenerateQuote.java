package helper;

import baseClass.PageDriver;
import baseClass.TestBase;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;
import utility.AssertionHelper;
import utility.ReadJSonData;

import java.io.File;
import java.io.IOException;

public class GenerateQuote extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"unity_test_data.json";
    WebDriver driver;
    public GenerateQuote(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By Text_input_date_of_death = By.xpath("//input[@data-placeholder='Date of Death']");

    By Cause_of_Death = By.xpath("//span[contains(text(),'[None Selected]')]");

    By Cause_of_Death_option = By.xpath("//div[@id='cause_of_death-panel']/mat-option[2]");

    By Text_Bill_amount = By.xpath("//input[@data-placeholder='How much is the funeral bill amount?']");

    By GenerateQuote= By.xpath("//span[contains(text(),'GENERATE QUOTE')]");

    By StartClaim = By.xpath("//button[@id='start-claim']");

    By Label_License_Number = By.xpath("(//*[starts-with(@id,'mat-form-field-label')])[1]");

    /*
        Csr Generate Quote
     */

    public By Csr_GeneRateQuote = By.xpath("//div[contains(text(),'GENERATE QUOTE')]");
    By csr_Date_of_Death = By.xpath("//input[@id='v_datDeath']");
    By csr_cause_of_Death = By.xpath("//span[contains(text(),'[None Selected]')]");
    By csr_option_cause_of_Death = By.xpath("//span[normalize-space()='Natural']");

    By csr_bill_amount = By.xpath("//input[@id='fb_amt']");



    public void enter_generate_quote() throws IOException, ParseException, InterruptedException {
        WaitForPresenceOfElement(GenerateQuote,10);
        Thread.sleep(2000);

        type(Text_input_date_of_death, new ReadJSonData().Read_the_value_from_json(path,"DOB"));
        Thread.sleep(2000);

        click(Cause_of_Death);
        Thread.sleep(2000);

        click(Cause_of_Death_option);
        Thread.sleep(2000);

        click(Text_Bill_amount);
        Thread.sleep(2000);
        type(Text_Bill_amount,new ReadJSonData().Read_the_value_from_json(path,"Bill_amount"));
        Thread.sleep(2000);

        click(GenerateQuote);
        WaitForPresenceOfElement(StartClaim,10);
        Thread.sleep(3000);

        click(StartClaim);
        WaitForPresenceOfElement(Label_License_Number,10);
    }

    /*
        CSR Data Generate Data
     */

    public void go_to_Generate_Quote_tab(){
        click(Csr_GeneRateQuote);
        WaitForPresenceOfElement(GenerateQuote,10);
    }

    public void Create_Generate_Quote() throws IOException, ParseException, InterruptedException {
        type(csr_Date_of_Death, new ReadJSonData().Read_the_value_from_json(path,"DOB"));
        click(csr_cause_of_Death);
        Thread.sleep(2000);
        click(csr_option_cause_of_Death);

        click(csr_bill_amount);
        type(csr_bill_amount,new ReadJSonData().Read_the_value_from_json(path,"Bill_amount"));
        click(GenerateQuote);
        WaitForPresenceOfElement(StartClaim,10);
        click(StartClaim);
    }
}
