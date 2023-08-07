package helper;

import baseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;

public class ThankYou extends BasePage {
    WebDriver driver;
    public ThankYou(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By AdditionalInfo = By.xpath("//div[contains(text(),' ADDITIONAL INFO ')]");
    By ThankYou_tab = By.xpath("//div[contains(text(),'Thank You.')]");

    By BackButton = By.xpath("//div[contains(text(),'BACK')]");
    By Print = By.xpath("//div[normalize-space()='PRINT CONFIRMATION']");


    public void get_AdditionalInfo(){
        WaitForPresenceOfElement(new AddBeneficiaries().beneficiariesTab,10);
        click(AdditionalInfo);
        WaitForPresenceOfElement(new ViewChecklist().viewChecklistTab,10);
        WaitForPresenceOfElement(new AddBeneficiaries().beneficiariesTab,10);
        click(BackButton);
        WaitForPresenceOfElement(ThankYou_tab,10);
        WaitForPresenceOfElement(AdditionalInfo,10);
        WaitForPresenceOfElement(Print,10);
    }
}
