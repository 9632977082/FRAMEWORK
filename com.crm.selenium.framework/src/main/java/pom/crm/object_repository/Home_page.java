package pom.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page
{
	//declaration
	@FindBy(xpath ="//a[.='Organizations']")
	private	WebElement Organisation;
	@FindBy(xpath ="//a[.='Products']")
	private	WebElement product;
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private	WebElement administrator;
	@FindBy(xpath ="//a[.='Sign Out']")
	private  WebElement signout;
	@FindBy(xpath ="//a[@href='javascript:;']")
	private WebElement more;
	@FindBy(xpath ="//a[@name='Campaigns']")
	private WebElement campaign;

	//initalization

	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getProducts() {
		return product;
	}
	public WebElement getMore() 
	{
		return more;
	}
	public WebElement getCampaign() 
	{
		return campaign;
	}
	public WebElement getOrganisation() 
	{
		return Organisation;
	}
	public WebElement getAdministrator() 
	{
		return administrator;
	}
	public WebElement getSignout() 
	{
		return signout;
	}
	public void homepage()
	{
		Organisation.click();
	}
	public void products_click()
	{
		product.click();
	}
	public void signout()
	{
		signout.click();
	}
	public void campaign()
	{
		more.click();
		campaign.click();
	}
}
