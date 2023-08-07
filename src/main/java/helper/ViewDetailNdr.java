package helper;

import baseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;

public class ViewDetailNdr extends BasePage {
    WebDriver driver;
    public ViewDetailNdr(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By Initiated = By.xpath("(//div[contains(text(),'Initiated')])[1]");

    public By Inbox = By.xpath("//div[normalize-space()='INBOX']");
    By TextInbox = By.xpath("//span[contains(text(),'YOU HAVE NO INBOX MAIL FOR THIS CLAIM')]");
    By BackButton = By.xpath("(//div[normalize-space()='BACK'])[1]");
    By Beneficiary = By.xpath("//div[normalize-space()='BENEFICIARIES']");
    By EventLog = By.xpath("//div[normalize-space()='EVENT LOGS']");
    By LockOut = By.xpath("//div[normalize-space()='LOCK OUT']");

    By ClaimTag = By.xpath("//div[normalize-space()='CLAIM TAG']");

    By AssignTome = By.xpath("//div[normalize-space()='ASSIGN TO ME']");

    public By Completed = By.xpath("(//div[contains(text(),'Completed')])[1]");

    By ViewPdf = By.xpath("(//span[contains(text(),'VIEW')])[1]");
    By TexasRecon = By.xpath("//div[@class='mat-list-item-content']//span[contains(text(),'Texas Recon Benekiva Edition.xlsx')]");
    By SaveButton = By.xpath("//button[@aria-label='Save Dialog']");


    /*
        Assign to me
     */

    By assignTome = By.xpath("//div[normalize-space()='ASSIGN TO ME']");
    By ConfirmButton = By.xpath("//button[@aria-label='CONFIRM']");

    /*
        Approve
     */

    By Approve = By.xpath("//div[normalize-space()='APPROVE']");

    By Payment = By.xpath("//div[normalize-space()='PAYMENT']");
    By viewchecklist = By.xpath("//div[normalize-space()='VIEW CHECKLIST']");

    /*
        Assign to Me
     */

    By Assign_to_me = By.xpath("//div[contains(text(),'ASSIGN TO ME')]");
    By Confirm_Button = By.xpath("//span[contains(text(),'CONFIRM')]");

    By Approve_Button = By.xpath("//div[contains(text(),'APPROVE')]");

    By Payment_Button = By.xpath("//div[contains(text(),'PAYMENT')]");

    By Payee = By.xpath("//div[contains(text(),'PAYEES')]");

    By payee= By.xpath("(//mat-icon[@role='img'][normalize-space()='check'])[1]");



    public void WaitForPage(){
        WaitForPresenceOfElement(Initiated,10);
        WaitForPresenceOfElement(Inbox,10);
        WaitForPresenceOfElement(Beneficiary,10);
        WaitForPresenceOfElement(EventLog,10);
        WaitForPresenceOfElement(LockOut,10);
        WaitForPresenceOfElement(ClaimTag,10);
        WaitForPresenceOfElement(AssignTome,10);
    }

    public void Inbox(){
        click(Inbox);
        WaitForPresenceOfElement(TextInbox,10);
        click(BackButton);
    }

    public void ViewPdfPage() throws InterruptedException {
        click(ViewPdf);
        Thread.sleep(12000);
        click(TexasRecon);
        click(SaveButton);
    }

    public void go_to_Assign_to_me(){
        click(assignTome);
        WaitForPresenceOfElement(ConfirmButton,10);
        click(ConfirmButton);
    }

    public void get_approve_button(){
        click(Approve);
        WaitForPresenceOfElement(Payment,10);

    }




}
