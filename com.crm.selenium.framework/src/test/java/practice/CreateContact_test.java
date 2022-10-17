package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact_test 
{
	@Test(dataProvider = "dataProvider_test")
public void Contact(String firstname ,String mobile) throws IOException
{ 
	
	File_utility flib = new File_utility();
	String BROWSER = flib.getPropertyKeyValue("browser");
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}else if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("msedge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	Webdriver_utility w = new Webdriver_utility();
	w.waitForpageToload(driver);
	String URL = flib.getPropertyKeyValue("url");
	String UN = flib.getPropertyKeyValue("un");
	String PWD = flib.getPropertyKeyValue("pw");
	driver.get(URL);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
	driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(mobile);
	
	
	
	
	//@DataProvider
///	public Object[][] dataProvider_test()
	//{
	//	Object[2][2] objarr = new Object[2][2]();
		
		//objarr[0][0]="rio";
		//objarr[0][1]="72092";
		
		//objarr[2][0]="ri";
		//objarr[2][1]="7209";
		
	//	return objarr;
		
	//}
	
}
}
