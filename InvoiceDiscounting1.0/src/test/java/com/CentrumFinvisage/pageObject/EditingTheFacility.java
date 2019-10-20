package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingTheFacility {

	WebDriver driver;
	public EditingTheFacility(WebDriver rdriver)
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
	
	@FindBy(xpath = "//i[contains(@title,'Edit Test Facility')]")
	WebElement clickoneditfacility;
	
	@FindBy(id = "cashflow_category_name")
	WebElement editfacilityname;
	
	@FindBy(xpath = "//label[text()='Inactive']")
	WebElement clickinactive;
	
	@FindBy(xpath = "//input[@value='Update']")
	WebElement clickupdate;
	
	@FindBy(xpath = "//div[text()='Facility was successfully updated.']")
	WebElement updatemsg;
	
	@FindBy(xpath = "(//a[@href='/cashflow_categories'])[2]")
	WebElement clickcancel;
	
	@FindBy(xpath = "(//a[@href='/cashflow_categories'])[1]")
	WebElement navigatefacility;
	
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
	public void clickOnEditFacility()
	{
		clickoneditfacility.click();
	}
	public void editFacilityName(String ModifyFacilityName)
	{
		editfacilityname.clear();
		editfacilityname.sendKeys(ModifyFacilityName);
	}
	public void clickInactive()
	{
		clickinactive.click();
	}
	public void clickUpdate()
	{
		clickupdate.click();
	}
	public String updateMsg()
	{
		return updatemsg.getText();
	}
	public void clickCancel()
	{
		clickcancel.click();
	}
	public void navigateFacility()
	{
		navigatefacility.click();
	}
}
