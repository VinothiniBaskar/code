package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import testng.baseclass.BaseClass;

public class HomePage extends BaseClass {

	public HomePage clickPartner() throws IOException {
         try {
			getMethod().findElement(By.xpath("//a[text()='Partners']")).click();
			reportStep("clicked","pass");
		} catch (Exception e) {
			reportStep(e+"not clicked","fail");
		}
         return this;
	}
	
	public PartnerDetails clickNewPartner() throws IOException {
        try {
			getMethod().findElement(By.xpath("//a[text()='Create Partner'] ")).click();
			reportStep("clicked","pass");
		} catch (Exception e) {
			reportStep(e+" not clicked","fail");
		}
        return new PartnerDetails();
	}

}
