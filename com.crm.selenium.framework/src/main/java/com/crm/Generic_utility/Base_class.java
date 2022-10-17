package com.crm.Generic_utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.crm.object_repository.Log_in;
public class Base_class 
{ 
	//Excel_utility elibm= new Excel_utility();
	//File_utility flib = new File_utility();
	//Java_utility jlib = new Java_utility();
	//Webdriver_utility wlib = new Webdriver_utility();
	//Lisetner listner = new Lisetner();
	public	WebDriver driver;
	//public static WebDriver sdriver;
	public void BS() throws IOException
	{
		System.out.println("data base connection");
	}
	@BeforeTest(groups = {"Smoke_test","Regression_test"})
	public void BT()
	{
		System.out.println("execute in parallel mode");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoke_test","Regression_test"})
	//public void BC(String BROWSER) throws IOException
	public void BC() throws IOException
	{
		System.out.println("launching browser");
		
		File_utility flib = new File_utility();
		String Browser = flib.getPropertyKeyValue("browser");

		if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		//sdriver=driver;
		
	}
	@BeforeMethod(groups = {"Smoke_test","Regression_test"})
	public void BM() throws IOException
	{
		System.out.println("login to application ");
		Webdriver_utility w = new Webdriver_utility();
		w.waitForpageToload(driver);
		File_utility flib = new File_utility();
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("un");
		String PWD = flib.getPropertyKeyValue("pw");
		driver.get(URL);
		Log_in l = new Log_in(driver);
		l.Login(UN, PWD);
	}
	@AfterMethod(groups = {"Smoke_test","Regression_test"})
	public void AM()
	{
		System.out.println("logout the application");
	}
	@AfterClass(groups = {"Smoke_test","Regression_test"})
	public void AC()
	{
		System.out.println("close the browser");
	}
	@AfterSuite(groups = {"Smoke_test","Regression_test"})
	public void AS()
	{
		System.out.println("data base close");
	}
}
