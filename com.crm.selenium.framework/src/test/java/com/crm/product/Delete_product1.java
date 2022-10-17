package com.crm.product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.Generic_utility.Base_class;
import com.crm.Generic_utility.Excel_utility;
import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Java_utility;
import com.crm.Generic_utility.Webdriver_utility;

import pom.crm.object_repository.Create_product;
import pom.crm.object_repository.Home_page;

public class Delete_product1 extends Base_class
{
	@Test(groups = {"Smoke_test","Regression_test"})
public void Delete_product() throws EncryptedDocumentException, IOException
{
	File_utility flib = new File_utility();
	//String key = "webdriver.gecko.driver";
	//String value = "./geckodriver.exe";
	//System.setProperty(key, value);
	//WebDriver driver = new FirefoxDriver();
	
	Webdriver_utility w = new Webdriver_utility();
	w.waitForpageToload(driver);
	Home_page home = new Home_page(driver);
	home.products_click();
	Java_utility jlib = new Java_utility();
	int ranDom = jlib.getRanDomNum();
	Excel_utility elib = new Excel_utility();
	String data1 = elib.getExcelValue("Sheet1", 0, 0)+ranDom;
	System.out.println(data1);
	Create_product product = new Create_product(driver);
	product.createproduct(data1);
	String actdata = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();             
	if(actdata.contains(data1))
	{
		System.out.println("created");
	}
	else
	{
		System.out.println("not created");
	}
	product.delete();
	w.toHandleAlertandConfirmationPopuptoAccept(driver);

	WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	//w.toHandleMouseActions(driver,admin );
	w.toHandleMouseActions(driver,admin );
	home.signout();
}

}
