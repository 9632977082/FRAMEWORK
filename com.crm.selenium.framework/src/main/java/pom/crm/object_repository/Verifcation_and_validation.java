package pom.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verifcation_and_validation 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ActOrgData;
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ActProductData;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement  ActCampWithProduct;



	public Verifcation_and_validation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getActProductData() 
	{
		return ActProductData;
	}

	public WebElement getActOrgData() 
	{
		return ActOrgData;
	}
	public WebElement getActCampWithProduct() 
	{
		return ActCampWithProduct;
	}

	public void OrganisationValidation(WebDriver driver,String data1)
	{
		String ActData = ActOrgData.getText();
		if(ActData.contains(data1))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	public void ProductValdation(WebDriver driver,String data1)
	{
		String Actdata = ActProductData.getText();
		if(Actdata.contains(data1))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}

	}
public void  CampaignAndProductValidation(WebDriver driver,String data1)
{
	String ActData = ActCampWithProduct.getText();
	if(ActData.contains(data1))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	
	
}

}
