package com.crm.campaign;

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
import org.testng.annotations.Test;

import com.crm.Generic_utility.Base_class;
import com.crm.Generic_utility.Excel_utility;
import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Java_utility;
import com.crm.Generic_utility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.crm.object_repository.CreateCampaignwith_product;
import pom.crm.object_repository.Home_page;
import pom.crm.object_repository.Log_in;

public class create_campaign extends Base_class
{
	@Test(groups = {"Smoke_test","Regression_test"})
	public void creat_campaign_test() throws IOException 
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
		home.campaign();
		CreateCampaignwith_product onlycampaign = new CreateCampaignwith_product(driver);
		Java_utility jlib = new Java_utility();
		int ranDom = jlib.getRanDomNum();
		Excel_utility elib = new Excel_utility();
		String data1 = elib.getExcelValue("Sheet1", 0, 0)+ranDom;
		System.out.println(data1);
		System.out.println(data1);
		onlycampaign.onlycampaign(data1);
		//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(data1);
		//driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actdata.contains(data1))
		{
			System.out.println("created");
		}
		{
			System.out.println("not created");
		}
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		w.toHandleMouseActions(driver,admin );
		home.signout();


	}
}
