package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Generic_utility.Excel_utility;
import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Java_utility;
import com.crm.Generic_utility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcontact_with_organisation 
{
	public static void main(String[] args) throws IOException 
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
		
		//String key = "webdriver.gecko.driver";
		//String value = "./geckodriver.exe";
		//System.setProperty(key, value);
		//WebDriver driver = new FirefoxDriver();
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
		String title = driver.getTitle();
		System.out.println(title);
		Java_utility jlib = new Java_utility();
		int ranDom = jlib.getRanDomNum();
		Excel_utility elib = new Excel_utility();
		String data1 = elib.getExcelValue("Sheet1", 0, 0)+ranDom;
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data1);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Webdriver_utility w1 = new Webdriver_utility();
		w.switchingWindow(driver, "Campaigns&action");
		String ORG = "TEST YANTRA";
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ORG);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='"+ORG+"']")).click();
		w.switchingWindow(driver, "Campaigns&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actdata.contains(data1))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				

	}
}
