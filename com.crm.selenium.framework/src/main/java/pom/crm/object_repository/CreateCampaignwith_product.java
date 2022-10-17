package pom.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignwith_product 
{
	@FindBy(xpath ="//img[@title='Create Campaign...']")
	private  WebElement campaign_plus; 
	@FindBy(xpath ="//input[@name='campaignname']")
	private  WebElement	campaignname;
	public WebElement getSavecampandproduct() {
		return Savecampandproduct;
	}
	@FindBy(xpath ="//img[@alt='Select']")
	private   WebElement	select;
	@FindBy(id = "search_txt" )
	private	 WebElement searchtext;
	@FindBy(name = "search")
	private  WebElement search;
	@FindBy(xpath ="//input[@value='  Save  ']")
	private WebElement	save;
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement	Savecampandproduct;

	public WebElement getSave() {
		return save;
	}
	public WebElement getSearchtext() 
	{
		return searchtext;
	}
	public WebElement getSavecampandproduct1() 
	{
		return	Savecampandproduct ;
	}
	public WebElement getSearch() {
		return search;
	}
	public CreateCampaignwith_product(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaign_plus()
	{
		return campaign_plus;
	}
	public WebElement getCampaignname() {
		return campaignname;
	}
	public WebElement getSelect() {
		return select;
	}
	public void createcampaignwithproduct(String data2)
	{
		campaign_plus.click();
		campaignname.sendKeys(data2);
		select.click();
	}
	public void productselect(String productdata)
	{
		searchtext.sendKeys(productdata);
		search.click();
	}
	public void onlycampaign(String data1)
	{
		campaign_plus.click();
		campaignname.sendKeys(data1);
		save.click();
	}
	public void savecampandproduct()
	{
		Savecampandproduct.click();
	}



}
