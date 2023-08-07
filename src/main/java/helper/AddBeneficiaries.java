package helper;

import baseClass.PageDriver;
import org.checkerframework.checker.units.qual.C;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;
import utility.JavaScriptHelper;
import utility.RandomNames;
import utility.ReadJSonData;

import java.io.File;
import java.io.IOException;

public class AddBeneficiaries extends BasePage {

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"unity_test_data.json";
    WebDriver driver;
    ViewDetailNdr viewDetailNdr;
    public AddBeneficiaries(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        viewDetailNdr = new ViewDetailNdr();
    }

    public By beneficiariesTab = By.xpath("//div[contains(text(),'BENEFICIARIES')]");
    By UpdateBeneficiary = By.xpath("//div[contains(text(),'Updated Beneficiary(ies)')]");

    By PersonAdd = By.xpath("//mat-icon[normalize-space()='person_add']");

    By BeneficiaryInfo = By.xpath("//div[contains(text(),'Beneficiary Info')]");

    By First_Name = By.xpath("//input[@id='FirstName']");
    By Last_Name = By.xpath("//input[@id='LastName']");

    By Address1 = By.xpath("//input[@id='AddressLine1']");
    By Address2 = By.xpath("//input[@id='AddressLine2']");
    By City = By.xpath("//input[@id='City']");
    By State = By.xpath("//input[@id='State']");
    By PostCode = By.xpath("//input[@id='PostalCode']");
    @FindBy(xpath = "//input[@id='PostalCode']")
    WebElement PostCodeXpath;
    By Suffix = By.xpath("//input[@id='Suffix']");
    By BusinessEntity = By.xpath("//input[@id='BusinessEntity']");

    By Email = By.xpath("//input[@id='Email']");

    By Relationship = By.xpath("//input[@id='RelationshipType']");
    By SaveRecord = By.xpath("//button[@aria-label='Close']//span[@class='mat-button-wrapper']");



    public void Go_to_Beneficiaries() throws InterruptedException {
        click(beneficiariesTab);
        Thread.sleep(2000);
    }

    public void Go_to_UpdatedBeneficiary(){
        click(UpdateBeneficiary);
        WaitForPresenceOfElement(PersonAdd,10);
    }

    public void CreateBeneficiaryIfo(){
        click(PersonAdd);
        WaitForPresenceOfElement(BeneficiaryInfo,10);
    }

    public void Get_Detail_of_Beneficiary() throws IOException, ParseException, InterruptedException {
        click(First_Name);
        type(First_Name,new RandomNames().GenerateFirstName());

        click(Last_Name);
        type(Last_Name,new RandomNames().GenerateLastName());

        click(Address1);
        type(Address1,new ReadJSonData().Read_the_value_from_json(path,"Address1"));
        tab(Address1);

        click(Address2);
        type(Address2,new ReadJSonData().Read_the_value_from_json(path,"Address2"));
        tab(Address2);

        click(City);
        type(City,new ReadJSonData().Read_the_value_from_json(path,"City"));
        tab(City);

        click(State);
        type(State,new ReadJSonData().Read_the_value_from_json(path,"State"));
        tab(State);

        click(PostCode);
        type(PostCode,new ReadJSonData().Read_the_value_from_json(path,"PostCode"));
        tab(PostCode);

        click(Suffix);
        type(Suffix,new ReadJSonData().Read_the_value_from_json(path,"Suffix"));
        tab(Suffix);

        click(BusinessEntity);
        type(BusinessEntity,new ReadJSonData().Read_the_value_from_json(path,"BusinessEntity"));
        tab(BusinessEntity);

        click(Email);
        type(Email,new ReadJSonData().Read_the_value_from_json(path,"Email"));
        tab(Email);

        click(Relationship);
        type(Relationship,new ReadJSonData().Read_the_value_from_json(path,"BusinessEntity"));
        tab(Relationship);
        click(SaveRecord);
        Thread.sleep(5000);
        driver.navigate().refresh();
        viewDetailNdr.WaitForPage();
    }



}
