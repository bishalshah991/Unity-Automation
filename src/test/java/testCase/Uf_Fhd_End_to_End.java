package testCase;

import baseClass.TestBase;
import helper.ClaimInformation;
import helper.GenerateQuote;
import helper.PolicySearch;
import helper.ThankYou;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.LoginPage;

import java.io.File;
import java.io.IOException;

public class Uf_Fhd_End_to_End extends TestBase {

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"unity_test_data.json";

    @Parameters({"username","password","policy"})
    @Test(priority = 1)
    public void login_to_end_to_end_setup_test(String username,String password,String policy) throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.Login_to_application(username + ".com",password);
        PolicySearch policySearch = new PolicySearch();
        policySearch.Search_Active_Policy(policy);
        GenerateQuote generateQuote = new GenerateQuote();
        generateQuote.enter_generate_quote();
        ClaimInformation claimInformation = new ClaimInformation();
        claimInformation.enter_license_number();
        claimInformation.Scroll_the_page();
        claimInformation.UploadDocument();
        claimInformation.Funeral_Home();
        claimInformation.get_Signature();
        claimInformation.get_Beneficiary_name();
        claimInformation.get_Signature();
        claimInformation.get_click_checkBox();
        ThankYou thankYou = new ThankYou();
        thankYou.get_AdditionalInfo();
        policySearch.Search_Policy(policy);
        Thread.sleep(5000);
        loginPage.Log_out_from_appliaction();
    }
}
