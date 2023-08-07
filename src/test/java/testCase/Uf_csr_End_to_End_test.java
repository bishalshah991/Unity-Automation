package testCase;

import baseClass.TestBase;
import helper.GenerateQuote;
import helper.PolicySearch;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.csr.End_to_end_csr;

import java.io.IOException;

public class Uf_csr_End_to_End_test extends TestBase {

    @Parameters({"username","password","policy"})
    @Test
    public void End_to_End_test(String username,String password,String policy) throws InterruptedException, IOException, ParseException {
        LoginPage loginPage = new LoginPage();
        loginPage.Login_to_application(username + ".com",password);
        PolicySearch policySearch = new PolicySearch();
        policySearch.Search_Policy(policy);
        policySearch.Go_to_Begin_Claim();

        End_to_end_csr endToEndCsr = new End_to_end_csr();
        endToEndCsr.GenerateQuote();
        endToEndCsr.go_to_Inbox();
        endToEndCsr.Create_Beneficiary();
        endToEndCsr.Upload();
        endToEndCsr.go_to_Assign_to_me();

    }


}
