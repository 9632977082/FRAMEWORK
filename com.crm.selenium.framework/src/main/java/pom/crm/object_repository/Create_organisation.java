package pom.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_organisation 
{
	@FindBy(xpath ="//img[@title='Create Organization...']" )
	private WebElement Createorganisation;
	
	@FindBy(xpath ="//input[@name='accountname']" )
	private WebElement orgname;
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement save;
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	 private WebElement actdata;
	public WebElement getOrgname() 
	{
		return orgname;
	}
	public WebElement getSave() 
	{
		return save;
	}
	public Create_organisation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateorganisation() 
	{
		return Createorganisation;
	}
	public WebElement getActdata() 
	{
		return actdata;
	}
	public void createorganisation(String data1)
	{
		Createorganisation.click();
		orgname.sendKeys(data1);
		save.click();
		//actdata.getText();
		//return actdata;
	}
	
}