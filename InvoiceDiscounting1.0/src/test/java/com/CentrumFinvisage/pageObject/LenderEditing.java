package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LenderEditing {
	
	WebDriver driver;

	public LenderEditing(WebDriver rdriver)
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

	@FindBy(xpath ="//a[@href='/lenders']")
	WebElement clicklender;

	@FindBy(xpath = "//i[contains(@title,'Edit Test Lender')]")
	WebElement clickediticon;
	
	@FindBy(xpath = "(//a[@href='/lenders'])[2]")
	WebElement clickcancel;
	
	@FindBy(xpath = "(//a[@href='/lenders'])[1]")
	WebElement navigatebacktolender;
	
	@FindBy(id = "lender_name")
	WebElement updatelendername;
	
	@FindBy(id = "lender_ticker")
	WebElement updatelendershortcode;
	
	@FindBy(xpath = "//input[@value='Update']")
	WebElement clickupdatebutton;
	
	@FindBy(xpath = "//div[text()='Lender was successfully updated']")
	WebElement updatemsg;
	
	@FindBy(xpath = "//i[contains(@title,'Make Test Lender')]")
	WebElement clickinactiveicon;
		
	@FindBy(id = "q_name_cont")
	WebElement searchbyname;
	
	@FindBy(id = "q_ticker_cont")
	WebElement searchbyshortcode;
	
	@FindBy(xpath = "//div[@class='selectize-input items not-full has-options']")
	WebElement clickstatusdd;
	
	@FindBy(xpath = "//div[text()='Active']")
	WebElement searchbystatus;
	
	@FindBy(xpath = "//div[text()='Inactive']")
	WebElement searchbystatus1;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement clicksearch;
	
	@FindBy(xpath = "//*[@href='/lenders']")
	WebElement clickclear;
	
	@FindBy(xpath = "(//a[@href='/admin/home'])[2]")
	WebElement navigatebackadminmanagement;
	
	@FindBy(xpath = "//*[@href='/lenders.xlsx']")
	WebElement clickete;
	
	@FindBy(xpath = "//td[text()='TL2019']//..//td[text()='Test Lender']")
	WebElement checkelement;
	
	public void setUsername(String uname)
	{
		txtusername.sendKeys(uname);
	}
	public void setPassword(String pword)
	{
		txtpassword.sendKeys(pword);
	}
	public void clickLogin()
	{
		loginbutton.click();
	}
	public void clickSettings()
	{
		String oldtab = driver.getWindowHandle();
		settingsTab.click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldtab);
		driver.switchTo().window(newTab.get(0));
	}
	public void clickLender()
	{
		clicklender.click();
	}
	public void clickEditIcon()
	{
		clickediticon.click();
	}
	public void clickCancel()
	{
		clickcancel.click();
	}
	public void  navigateBackToLender()
	{
		navigatebacktolender.click();
	}
	public void updateLenderName(String EnterLenderName)
	{
		updatelendername.clear();
		updatelendername.sendKeys(EnterLenderName);
	}
	public void updateLenderShortcode(String EnterShortcode)
	{
		updatelendershortcode.clear();
		updatelendershortcode.sendKeys(EnterShortcode);
	}
	public void clickUpdateButton()
	{
		clickupdatebutton.click();
	}
	public String updateMsg()
	{
		return updatemsg.getText();
	}
	public void clickInactiveIcon()
	{
		clickinactiveicon.click();
		driver.switchTo().alert().accept();
	}
	public void searchByName(String EnterLenderNameToSearch)
	{
		searchbyname.sendKeys(EnterLenderNameToSearch);
	}
	public void searchByShortcode(String EnterLenderShortcodeToSearch)
	{
		searchbyshortcode.sendKeys(EnterLenderShortcodeToSearch);
	}
	public void clickStatusDD()
	{
		clickstatusdd.click();
	}
	public void searchByStatus()
	{
		searchbystatus.click();
	}
	public void searchByStatus1()
	{
		searchbystatus1.click();
	}
	public void clickSearch()
	{
		clicksearch.click();
	}
	public void clickClear()
	{
		clickclear.click();
	}
	public void navigateBackAdminManagement()
	{
		navigatebackadminmanagement.click();
	}
	public void clickETE()
	{
		clickete.click();
	}
	public boolean checkElement()
	{
		return checkelement.isDisplayed();
	}
}
