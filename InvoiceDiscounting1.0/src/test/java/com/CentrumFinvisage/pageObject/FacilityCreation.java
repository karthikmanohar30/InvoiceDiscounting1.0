package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacilityCreation {

	WebDriver driver;
	
	public FacilityCreation(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="user_login")
	WebElement txtusername;

	@FindBy(id="user_password")
	WebElement txtpassword;

	@FindBy(name="commit")
	WebElement loginbutton;

	@FindBy(xpath = "//a[@href='/admin/home']")
	WebElement settingsTab;
	
	@FindBy(xpath = "//a[@href='/cashflow_categories']")
	WebElement clickfacility;
	
	@FindBy(xpath = "//a[@href='/cashflow_categories/new']")
	WebElement clicknewfacility;
	
	@FindBy(id="cashflow_category_name")
	WebElement setfacilityname;
	
	@FindBy(xpath = "//label[text()='Active']")
	WebElement facilitystatus;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement clickcancelbutton;
	
	@FindBy(xpath ="//input[@value='Create']")
	WebElement clickcreatebutton;
	
	@FindBy(xpath="//span[text()='has already been taken']")
	WebElement nameerrormessage;
	
	@FindBy (xpath ="//div[text()='Facility was successfully created']" )
	WebElement successmsg;
	
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
	public void clicksettings()
	{
		String oldtab = driver.getWindowHandle();
		settingsTab.click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldtab);
		driver.switchTo().window(newTab.get(0));
	}
	public void clickFacility()
	{
		clickfacility.click();
	}
	public void clickNewFacility()
	{
		clicknewfacility.click();
	}
	public void setFacilityName(String enterfacilityname)
	{
		setfacilityname.sendKeys(enterfacilityname);
	}
	public boolean facilityStatus()
	{
		return facilitystatus.isSelected();
	}
	public void clickCancelButton()
	{
		clickcancelbutton.click();
	}
	public void clickCreateButton()
	{
		clickcreatebutton.click();
	}
	public String nameErrorMessage()
	{
		return nameerrormessage.getText();
	}
	public String successfulMsg()
	{
		return successmsg.getText();
	}
	public void logOut()
	{
		logout.click();
	}

}
