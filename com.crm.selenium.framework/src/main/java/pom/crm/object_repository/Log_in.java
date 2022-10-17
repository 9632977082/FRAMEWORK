package pom.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_in 
{
//declaration
	@FindBy(xpath ="//input[@type='text']" )
	private WebElement UN;
	@FindBy(xpath = "//input[@type='password']")
	 private WebElement PWD;
	@FindBy(xpath ="//input[@type='submit']")
	     private WebElement log_in;
	
	public Log_in(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getUN() {
		return UN;
	}
	public WebElement getPWD() {
		return PWD;
	}
	public WebElement getLog_in() {
		return log_in;
	}
	public void Login(String un,String pw)
	{
		UN.sendKeys(un);
		PWD.sendKeys(pw);
		log_in.click();
	}

		
	
}
