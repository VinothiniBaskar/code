package pages;

import org.openqa.selenium.By;

import testng.baseclass.BaseClass;

public class ViewPartner extends BaseClass{

	public  void verify() {
		String text = getMethod().findElement(By.id("viewPartner_groupName_sp")).getText();
		if (text.equalsIgnoreCase("Vino")) {
			System.out.println("First Partner is created succesfully");
		}
		else if (text.equalsIgnoreCase("Gayu")) {
			System.out.println("Second Partner is created succesfully");

		} else {
			System.out.println(" Partner is  not created ");

		}

	}

}
