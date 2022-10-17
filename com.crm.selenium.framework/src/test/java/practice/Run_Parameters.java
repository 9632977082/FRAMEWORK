package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_utility.File_utility;
import com.crm.Generic_utility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.crm.object_repository.Log_in;

public class Run_Parameters
{
@Test
public void RunParameters() throws IOException
{
	WebDriver driver;
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
	Webdriver_utility w = new Webdriver_utility();
	w.waitForpageToload(driver);
	//File_utility flib = new File_utility();
	String URL = flib.getPropertyKeyValue("url");
	String UN = flib.getPropertyKeyValue("un");
	String PWD = flib.getPropertyKeyValue("pw");
	driver.get(URL);
	Log_in l = new Log_in(driver);
	l.Login(UN, PWD);
}

}
