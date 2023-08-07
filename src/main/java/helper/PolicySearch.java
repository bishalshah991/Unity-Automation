package helper;

import baseClass.PageDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;
import utility.ReadJSonData;

import java.io.File;
import java.io.IOException;

public class PolicySearch extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"unity_test_data.json";
    WebDriver driver;

    public PolicySearch(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By PolicySearchTab = By.xpath("//span[contains(text(),'Policy Search')]");
    By TabKeyEnter = By.xpath("//input[@placeholder='Type keywords and Press Enter....']");

        By PolicySearchTextBox =By.xpath("//input[@id='searchInput']");

    By ThreeDots = By.xpath("//mat-icon[normalize-space()='more_horiz']");

    By Active = By.xpath("//div[contains(text(),'Active')]");
    By BeginClaim = By.xpath("//span[contains(text(),'Begin Claim')]");

    public By GenerateQuote = By.xpath("//span[normalize-space()='GENERATE QUOTE']");

    public void Search_Policy(String policy_number){
        click(PolicySearchTab);
        WaitForPresenceOfElement(TabKeyEnter,10);
        type(PolicySearchTextBox,policy_number);
        WaitForPresenceOfElement(Active,10);
    }

    public void Go_to_Begin_Claim(){
        click(ThreeDots);
        WaitForPresenceOfElement(BeginClaim,10);
        click(BeginClaim);
        WaitForPresenceOfElement(new GenerateQuote().Csr_GeneRateQuote,10);
    }

    public void Search_Active_Policy(String policy_number) throws InterruptedException {
        click(PolicySearchTab);
        WaitForPresenceOfElement(TabKeyEnter,10);
        type(PolicySearchTextBox,policy_number);
        WaitForPresenceOfElement(Active,10);
        click(ThreeDots);
        WaitForPresenceOfElement(BeginClaim,10);
        click(BeginClaim);
        Thread.sleep(3000);
        WaitForPresenceOfElement(new PolicySearch().GenerateQuote,10);
        Thread.sleep(3000);
    }



}
