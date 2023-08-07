package helper;

import baseClass.PageDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;
import pageObject.BasePage;
import utility.JavaScriptHelper;
import utility.ReadJSonData;
import utility.Upload;


import java.io.File;
import java.io.IOException;
import java.security.Key;

public class ClaimInformation extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"unity_test_data.json";
    WebDriver driver;
    JavaScriptHelper javaScriptHelper;
    public ClaimInformation(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        javaScriptHelper = new JavaScriptHelper();
    }

    By License_Number = By.xpath("//input[@data-placeholder='Enter License Number']");

    By Funeral_home = By.xpath("(//div[starts-with(@class,'mat-select-value')])[1]");
    By optionDropDown = By.xpath("//div[@role='listbox']/mat-option[2]");

    By Beneficiary = By.xpath("(//div[starts-with(@class,'mat-select-value')])[2]");

    //By Medicaid = By.xpath("(//div[starts-with(@class,'mat-select-value ng-tns')])[3]");

    By Medicaid = By.xpath("//span[contains(text(),'[None Selected]')]");
    By medicaidOption = ByChained.xpath("//div[@id='receive_medicaid-panel']//span[contains(text(),'Yes')]");

      /*
        Scroll the Page
     */
    @FindBy(xpath = "//mat-label[contains(text(),'Was deceased receiving Medicaid?')]")
    WebElement ScrollThePage;

    @FindBy(xpath = "//mat-label[contains(text(),'Beneficiary Name')]")
    WebElement ScrollPage1;
    /*
        File Upload
     */
    By Upload = By.xpath("//input[@type='file']");
    By FileUpload = By.xpath("//div[@class='ng-star-inserted']");
    By CloseIcon = By.xpath("//span[@class='mat-button-wrapper']//mat-icon[@role='img'][normalize-space()='close']");

    /*
        Funeral Home Director Printed Name
     */

    By FuneralHome = By.xpath("//input[@id='fhdName']");

    By BeneficiaryName = By.xpath("//input[@id='beneficiary_name']");

    By checkBox = By.xpath("//span[@class='mat-checkbox-inner-container']");

    By AcceptButton = By.xpath("//span[normalize-space()='ACCEPT']");

    By SignedCopy = By.xpath("//button[@aria-label='Document attached']//div[@class='textLayer']");

    By uploadedPdf = By.xpath("(//button[starts-with(@class,'mat-focus-indicator mat-tooltip-trigger mat-button mat-button-base')])[2]");

    By SubmitClaim = By.xpath("//span[contains(text(),'SUBMIT CLAIM')]");

    By ThankYou = By.xpath("//div[contains(text(),'Thank You.')]");





    public void enter_license_number() throws IOException, ParseException, InterruptedException {
        click(License_Number);
        Thread.sleep(3000);
        type(License_Number,new ReadJSonData().Read_the_value_from_json(path,"LicNum"));
        Thread.sleep(3000);

        click(Funeral_home);
        Thread.sleep(3000);
        click(optionDropDown);
        Thread.sleep(3000);

        click(Beneficiary);
        Thread.sleep(3000);
        click(optionDropDown);
        Thread.sleep(3000);

        click(Medicaid);
        Thread.sleep(3000);
        click(medicaidOption);
        Thread.sleep(3000);
    }
    public void Scroll_the_page() throws InterruptedException {
        javaScriptHelper.scroll_to_View(ScrollThePage);
        Thread.sleep(3000);
    }
    public void UploadDocument() throws InterruptedException {
        DocumentUpload(Upload);
        WaitForPresenceOfElement(FileUpload,10);
        click(FileUpload);
        Thread.sleep(7000);
        click(CloseIcon);
    }
    public void Funeral_Home() throws IOException, ParseException {
        type(FuneralHome, new ReadJSonData().Read_the_value_from_json(path,"FirstName"));
    }

    public void get_Signature() throws InterruptedException {
        new SignatureHelper(driver).SignatureHelperClass();
        javaScriptHelper.scroll_to_View(ScrollPage1);
    }
    public void get_Beneficiary_name() throws IOException, ParseException {
        type(BeneficiaryName,new ReadJSonData().Read_the_value_from_json(path,"FirstName"));
    }
    public void get_click_checkBox() throws InterruptedException {
        click(checkBox);
        click(AcceptButton);
        Thread.sleep(10000);
        WaitForPresenceOfElement(uploadedPdf,10);
        WaitForPresenceOfElement(SubmitClaim,10);
        click(SignedCopy);
        Thread.sleep(10000);
        click(CloseIcon);
        Thread.sleep(5000);
        click(SubmitClaim);
        WaitForPresenceOfElement(ThankYou,10);
    }

}
