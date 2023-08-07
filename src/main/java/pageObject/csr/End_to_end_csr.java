package pageObject.csr;

import baseClass.PageDriver;
import helper.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;
import utility.Upload;

import java.io.IOException;

public class End_to_end_csr extends BasePage {
    WebDriver driver;
    PolicySearch policySearch;
    GenerateQuote generateQuote;
    ViewDetailNdr viewDetailNdr;
    public End_to_end_csr(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        policySearch = new PolicySearch();
        viewDetailNdr = new ViewDetailNdr();
    }
    public void GenerateQuote() throws IOException, ParseException, InterruptedException {
        generateQuote = new GenerateQuote();
        generateQuote.go_to_Generate_Quote_tab();
        generateQuote.Create_Generate_Quote();
        viewDetailNdr.WaitForPage();
    }

    public void go_to_Inbox(){
        viewDetailNdr.Inbox();
        viewDetailNdr.WaitForPage();
    }
    public void Create_Beneficiary() throws InterruptedException, IOException, ParseException {
        AddBeneficiaries addBeneficiaries = new AddBeneficiaries();
        addBeneficiaries.Go_to_Beneficiaries();
        addBeneficiaries.Go_to_UpdatedBeneficiary();
        addBeneficiaries.CreateBeneficiaryIfo();
        addBeneficiaries.Get_Detail_of_Beneficiary();
    }

    public void Upload() throws InterruptedException {
        new Upload().upload_Document();
        new MatchThis().Count_of_Match_this();
        WaitForPresenceOfElement(viewDetailNdr.Completed,10);
        viewDetailNdr.ViewPdfPage();
        viewDetailNdr.WaitForPage();
    }

    public void go_to_Assign_to_me(){
        viewDetailNdr.go_to_Assign_to_me();
        viewDetailNdr.WaitForPage();
    }

}
