package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import testng.baseclass.BaseClass;

public class LoginTest extends BaseClass {
	@BeforeTest
	public void passData() {
		excelFileName = "Login";
		testName="Login Script";
		testDescription="Login Functionality";
		testCategory="LeafTaps Module";
		testAuthor="Vino";
		

	}

	@Test(dataProvider = "fetch")
	public void runLogin(String un, String pw) throws IOException {
		LoginPage lp = new LoginPage();
		lp.enterUsername(un).enterPassword(pw).clickLogin();

	}

}
