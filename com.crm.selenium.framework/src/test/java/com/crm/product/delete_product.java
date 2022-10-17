package com.crm.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Generic_utility.Base_class;
import com.crm.Generic_utility.Excel_utility;
import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Java_utility;
import com.crm.Generic_utility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.crm.object_repository.Create_product;
import pom.crm.object_repository.Home_page;
import pom.crm.object_repository.Log_in;

public class delete_product extends Base_class
{
	@Test(groups = {"Smoke_test","Regression_test"})
	public void deleteProduct_test() throws IOException 
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
		Assert.fail();
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
		//driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		product.delete();
		w.toHandleAlertandConfirmationPopuptoAccept(driver);

		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		w.toHandleMouseActions(driver,admin );
		home.signout();

	}
	@Test
	public void Sample()
	{
		System.out.println("modified");
	}
}

