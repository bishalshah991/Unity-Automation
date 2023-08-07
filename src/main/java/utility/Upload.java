package utility;

import baseClass.PageDriver;
import helper.MatchThis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;

import java.io.File;

public class Upload extends BasePage {

    WebDriver driver;
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"TestData.pdf";

    public Upload(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }
    By FileUpload = By.xpath("//input[@type='file']");
    By SaveButton = By.xpath("//span[contains(text(),'Save')]");

    By MatchThis = By.xpath("(//span[normalize-space()='Match This'])[1]");
    public void UploadDocument(){
        DocumentUpload(FileUpload);
        WaitForPresenceOfElement(SaveButton,10);
        WaitForPresenceOfElement(MatchThis,10);
    }

    public void upload_Document(){
        DocumentUpload(FileUpload);
        WaitForPresenceOfElement(new MatchThis().MatchThis,10);
    }



}
