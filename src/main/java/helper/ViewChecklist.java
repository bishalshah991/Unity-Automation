package helper;

import baseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;

public class ViewChecklist extends BasePage {

    WebDriver driver;
    public ViewChecklist(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    public By viewChecklistTab = By.xpath("//div[contains(text(), 'VIEW CHECKLIST')]");
    By uploadFile = By.xpath("//input[@type='file']");

    By SaveButton = By.xpath("//span[normalize-space()='Save']");

    By ViewButton = By.xpath("(//span[contains(text(),'VIEW')])[1]");
    By MapButton = By.xpath("//mat-icon[@class='mat-icon notranslate s-24 nav-link-icon material-icons mat-icon-no-color ng-star-inserted']");


    public void get_viewCheckList(){
        click(viewChecklistTab);
        WaitForPresenceOfElement(new AddBeneficiaries().beneficiariesTab,10);
        WaitForPresenceOfElement(new ThankYou().AdditionalInfo,10);
        WaitForPresenceOfElement(new ThankYou().BackButton,10);
    }

    public void UploadDocument() throws InterruptedException {
        DocumentUpload(uploadFile);
        WaitForPresenceOfElement(SaveButton,10);
        click(SaveButton);
        Thread.sleep(5000);
    }

    public void get_view_button() throws InterruptedException {
        click(ViewButton);
        Thread.sleep(10000);
        click(MapButton);
        click(SaveButton);
        WaitForPresenceOfElement(new AddBeneficiaries().beneficiariesTab,10);
        WaitForPresenceOfElement(new ThankYou().AdditionalInfo,10);
        WaitForPresenceOfElement(new ThankYou().BackButton,10);
    }
}
