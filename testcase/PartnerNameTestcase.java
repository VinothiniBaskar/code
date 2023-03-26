package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import testng.baseclass.BaseClass;

public class PartnerNameTestcase extends BaseClass {

	@BeforeTest
	public void passData() {
		excelFileName="Name";
		testName="Partner Script";
		testDescription="Create Partner Functionality";
		testCategory="LeafTaps Module";
		testAuthor="Vino";
	}

	@Test(dataProvider="fetch")
	public void runName(String un,String pw,String fn,String ln) throws IOException {
		LoginPage lp = new LoginPage();
		lp.enterUsername(un)
		.enterPassword(pw)
		.clickLogin()
		.clickPartner()
		.clickNewPartner()
		.enterFirstName(fn)
		.enterLastName(ln)
		.clickBtn()
		.verify();;
		
	
	}

}
