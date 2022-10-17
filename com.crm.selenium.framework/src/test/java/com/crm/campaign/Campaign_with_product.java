package com.crm.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_utility.Base_class;
import com.crm.Generic_utility.Excel_utility;
import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Java_utility;
import com.crm.Generic_utility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.crm.object_repository.CreateCampaignwith_product;
import pom.crm.object_repository.Create_product;
import pom.crm.object_repository.Home_page;
import pom.crm.object_repository.Log_in;
import pom.crm.object_repository.Verifcation_and_validation;

public class Campaign_with_product extends Base_class
{
	@Test (groups = "Smoke_test")
	public void campaign_with_product_test()throws EncryptedDocumentException, IOException, InterruptedException 
	{
		File_utility flib = new File_utility();
		//String key = "webdriver.gecko.driver";
		//String value = "./geckodriver.exe";

		//System.setProperty(key, value);
		//WebDriver driver = new FirefoxDriver();

		String BROWSER = flib.getPropertyKeyValue("browser");
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
		Verifcation_and_validation validation = new Verifcation_and_validation(driver);
		validation.ProductValdation(driver, data1);

		WebElement ele=driver.findElement(By.xpath("//a[@href='javascript:;']"));
		w.toHandleMouseActions(driver, ele);
		home.campaign();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		String data2 = elib.getExcelValue("Sheet1", 0, 0)+ranDom;
		System.out.println(data2);
		CreateCampaignwith_product campaign = new CreateCampaignwith_product(driver);
		campaign.createcampaignwithproduct(data2);

		Webdriver_utility w1 = new Webdriver_utility();
		w.switchingWindow(driver, "Products&action");
		String productdata = "SELENIUM";
		campaign.productselect(productdata);
		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
		//Switch back Window
		w.switchingWindow(driver, "Campaigns&action");

		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		campaign.savecampandproduct();
		Thread.sleep(1000);

		//String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();

		CharSequence data = "SELENIUM";
	//	if(actData.contains(data))
		//{
			System.out.println("pass");
	//	}
	//	else
		//{
			System.out.println("fail");
	//	}
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		w.toHandleMouseActions(driver,admin );
		home.signout();


	}
}
