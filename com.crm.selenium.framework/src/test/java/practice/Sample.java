package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		String key = "webdriver.gecko.driver";
		String value = "./geckodriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new FirefoxDriver();
		FileInputStream fis = new FileInputStream("./commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("un");
		String PWD = pro.getProperty("pw");
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	}

}
