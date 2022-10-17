package com.crm.Generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_utility 
{
public void waitForpageToload(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
public void scriptTimeout(WebDriver driver)
{
	driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
}
public void waitForElementwithCustomtimeOut(WebDriver driver,WebElement element,int pollingTime)
{
	FluentWait wait = new FluentWait(driver);
	wait.pollingEvery(Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForElementoInspect(WebDriver driver,String data)
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.titleContains(data));
}
public void toHandleMouseActions(WebDriver driver,WebElement element)
{
	Actions a = new Actions(driver);
	a.moveToElement(element).perform();
}
public void rightClickonElement(WebDriver driver,WebElement element)
{
	Actions a = new Actions(driver);
	a.contextClick(element).perform();
}
public void moveByoffSet(WebDriver driver,int x,int y)
{
	Actions a = new Actions(driver);
	a.moveByOffset(x, y).click().perform();
}
public void toHandleAlertandConfirmationPopuptoAccept(WebDriver driver)
{
	
	Alert a = driver.switchTo().alert();
	a.accept();
}
public void toDismiss(WebDriver driver)
{
	Alert a = driver.switchTo().alert();
	a.dismiss();
}

public void toHandleDropdown(WebElement ele,int index,String value,String text)
{
	Select s = new Select(ele);
	s.selectByIndex(index);
	s.selectByValue(value);
	s.selectByVisibleText(text);
	s.deselectByIndex(index);
	s.deselectByValue(value);
	s.deselectByVisibleText(text);
	s.deselectAll();
}
public void switchingWindow(WebDriver driver,String partialWindowTitle)
{
	Set<String> all_id = driver.getWindowHandles();
	Iterator<String> id = all_id.iterator();
	while(id.hasNext())
	{
		String wid = id.next();
		driver.switchTo().window(wid);
	if(driver.getTitle().contains(partialWindowTitle))
	{
		break;
	}
	}
}
public void switchToFrame(WebDriver driver,String id_name_attribute,int index1)
{
	driver.switchTo().frame(id_name_attribute);
	driver.switchTo().frame(index1);
}
}
