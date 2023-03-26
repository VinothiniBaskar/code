package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import testng.baseclass.BaseClass;

public class PartnerDetails extends BaseClass {

	public PartnerDetails  enterFirstName(String fn) throws IOException {
		try {
			getMethod().findElement(By.id("createPartnerForm_groupName")).sendKeys(fn);
			reportStep("entered fn","pass");
		} catch (Exception e) {
			reportStep(e+"not enterd","fail");
		}
        return this;
	}
	public PartnerDetails  enterLastName(String ln) throws IOException {
		try {
			getMethod().findElement(By.id("createPartnerForm_groupNameLocal")).sendKeys(ln);
			reportStep("enterd  ln","pass");
		} catch (Exception e) {
			reportStep(e+"not enterd","fail");
		}
        return this;
	}
	public ViewPartner clickBtn() throws IOException {
		try {
			getMethod().findElement(By.className("smallSubmit")).click();
			reportStep("clicked","pass");
		} catch (Exception e) {
			reportStep(e+"not clicked","fail");
		}
		return new ViewPartner();

	}
}
