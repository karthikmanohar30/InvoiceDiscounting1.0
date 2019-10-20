package com.CentrumFinvisage.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForecastViewCreation {

	WebDriver driver;
	public ForecastViewCreation(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="user_login")
	WebElement txtusername;

	@FindBy(id="user_password")
	WebElement txtpassword;

	@FindBy(name="commit")
	WebElement loginbutton;

	@FindBy(xpath="//a[@href='/forecast_views']")
	WebElement clickforecastviews;

	@FindBy(xpath = "//a[@href='/forecast_views/new']")
	WebElement clickaddnew;

	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement clickanchordropdown;

	@FindBy(xpath = "(//div[text()='Test Anchor'])")
	WebElement selectanchor;

	@FindBy(xpath = "(//input[@id='forecast_view_name'])")
	WebElement setforecastviewname;

	@FindBy(xpath = "(//input[@id='forecast_view_start_date'])")
	WebElement setforecastviewstartdate;

	@FindBy(xpath = "//input[@id='forecast_view_end_date']")
	WebElement setforecastviewenddate;

	@FindBy(xpath = "//input[@value='Create']")
	WebElement clickcreate;

	@FindBy(xpath = "//div[text()='View saved successfully']")
	WebElement viewsavedmsg;
	
	@FindBy(xpath="//a[@href='/users/sign_out']")
	WebElement logout;


	public void setUsername(String uname)
	{
		txtusername.sendKeys(uname);
	}
	public void setPassword(String pword)
	{
		txtpassword.sendKeys(pword);
	}
	public void clicklogin()
	{
		loginbutton.click();
	}
	public void clickForecastViews()
	{
		clickforecastviews.click();
	}
	public void clickAddNew()
	{
		clickaddnew.click();
	}
	public void clickAnchorDropdown()
	{
		clickanchordropdown.click();
	}
	public void selectAnchor()
	{

		selectanchor.click();
	}
	public void setForecastViewName(String Enterforecastviewname)
	{
		setforecastviewname.sendKeys(Enterforecastviewname);
	}
	public void setForecastViewStartdate(String enterStartDate)
	{

		setforecastviewstartdate.click();
		for(int i=0;i<10;i++) 
		{
			setforecastviewstartdate.sendKeys(Keys.BACK_SPACE);
		}
		setforecastviewstartdate.sendKeys(enterStartDate);
	}
	public void setForecastViewEnddate(String Enterenddate)
	{
		setforecastviewenddate.click();
		for(int i=0;i<10;i++) 
		{
			setforecastviewenddate.sendKeys(Keys.BACK_SPACE);
		}
		setforecastviewenddate.sendKeys(Enterenddate);
	}
	public void clickCreate()
	{
		clickcreate.click();
	}
	public String viewSavedMsg()
	{
		return viewsavedmsg.getText();
	}
	public void logOut()
	{
		logout.click();
	}

}
