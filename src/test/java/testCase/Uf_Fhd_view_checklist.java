package testCase;

import baseClass.TestBase;
import helper.ClaimInformation;
import helper.GenerateQuote;
import helper.PolicySearch;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.LoginPage;

import java.io.IOException;

public class Uf_Fhd_view_checklist extends TestBase {

    @Parameters({"username","password","policy1"})
    @Test(priority = 1)
    public void end_to_end_view_check_list(String username,String password,String policy1) throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.Login_to_application(username + ".com", password);
        PolicySearch policySearch = new PolicySearch();
        policySearch.Search_Active_Policy(policy1);
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
    }
}
