package practice;

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
import org.openqa.selenium.firefox.FirefoxDriver;

public class Makemytrip 
{
	public static void main(String[] args) throws IOException
	{
		String key = "webdriver.gecko.driver";
		String value = "./geckodriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("./commondata2.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);

		FileInputStream fis1 = new FileInputStream("./DATA1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
		System.out.println(data);
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(data);
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();



		FileInputStream fis11 = new FileInputStream("./DATA1.xlsx");
		Workbook book1 = WorkbookFactory.create(fis11);
		Sheet sh1 = book1.getSheet("Sheet1");
		Row row1 = sh1.getRow(2);
		Cell cell1 = row1.getCell(0);
		String data1 = cell.getStringCellValue();
		System.out.println(data1);

		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(data1);

		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-3']")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();

		String month = "September 2022";
		String date = "30";
		
		driver.findElement(By.xpath("//div[.='"+month+"']"
		+"/ancestor::div[@class='DayPicker-Month']/descedant::p[.='"+date+"']")).click();
	}
}
