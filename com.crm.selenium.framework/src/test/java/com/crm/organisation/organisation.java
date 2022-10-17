package com.crm.organisation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.Generic_utility.Base_class;
import com.crm.Generic_utility.Excel_utility;
import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Java_utility;
import com.crm.Generic_utility.Webdriver_utility;

import pom.crm.object_repository.Create_organisation;
import pom.crm.object_repository.Home_page;
import pom.crm.object_repository.Verifcation_and_validation;

public class organisation extends Base_class
{
	@Test(groups = "Smoke_test")
	public void createOrganisation_test() throws IOException 
	{
		File_utility flib = new File_utility();
		Java_utility jlib = new Java_utility();
		Webdriver_utility w = new Webdriver_utility();

		Home_page home = new Home_page(driver);
		home.homepage();
		Create_organisation org = new Create_organisation(driver);

		int ranDom = jlib.getRanDomNum();
		Excel_utility elib = new Excel_utility();
		String data1 = elib.getExcelValue("Sheet1", 0, 0)+ranDom;
		org.createorganisation(data1);

		System.out.println(data1);

		Verifcation_and_validation validation = new Verifcation_and_validation(driver);
		validation.OrganisationValidation(driver, data1);
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		w.toHandleMouseActions(driver,admin );
		home.signout();

	}
}
