package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import testng.baseclass.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage enterUsername(String un) throws IOException {
		try {
			getMethod().findElement(By.name("USERNAME")).sendKeys(un);
			reportStep("Entered username","pass");
		} catch (Exception e) {
			reportStep(e+"not enterd username","fail");
		}
		return this;

	}
	public LoginPage enterPassword(String pw) throws IOException {
		try {
			getMethod().findElement(By.name("PASSWORD")).sendKeys(pw);
			reportStep("Entered password","pass");

		} catch (Exception e) {
			reportStep(e+"not enterd ","fail");

		}
		return this;

	}
	public HomePage clickLogin() throws IOException {
		try {
			getMethod().findElement(By.className("loginButton")).click();
			reportStep("clicked","pass");

		} catch (Exception e) {
			reportStep(e+" not clicked","fail");

		}
		return new HomePage();

	}
}
