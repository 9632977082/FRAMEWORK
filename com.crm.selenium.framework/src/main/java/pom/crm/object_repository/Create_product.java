package pom.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_product 
{
	@FindBy(xpath ="//img[@title='Create Product...']")
	private WebElement productplus;
	@FindBy(xpath ="//input[@name='productname']")
	private  WebElement productname;
	@FindBy(xpath ="//input[@accesskey='S']")
	private WebElement save;
	@FindBy(xpath ="//input[@title='Delete [Alt+D]']")
	private WebElement deleteproduct;

	public Create_product(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductplus() 
	{
		return productplus;
	}
	public WebElement getProductname() 
	{
		return productname;
	}
	public WebElement getSave() 
	{
		return save;
	}
	public void createproduct(String data1)
	{
		productplus.click();
		productname.sendKeys(data1);
		save.click();
	}
	public WebElement getDeleteproduct() 
	{
		return deleteproduct;
	}
	public void delete()
	{
		deleteproduct.click();
	}
}
