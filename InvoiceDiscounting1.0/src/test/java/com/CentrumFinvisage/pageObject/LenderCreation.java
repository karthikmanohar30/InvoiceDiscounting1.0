package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LenderCreation {

	WebDriver driver;

	public LenderCreation (WebDriver rdriver)
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

	@FindBy (xpath ="//a[@href='/lenders/new']")
	WebElement clicknewlender;

	@FindBy(id = "lender_name")
	WebElement enterlendername;

	@FindBy(id="lender_ticker")
	WebElement entershortcode;
	
	@FindBy(xpath="(//span[@id='lender_name-error'])[1]")
	WebElement nameerrormsg;
	
	@FindBy(xpath = "//label[text()='Active']")
	WebElement lenderstatus;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement clickcancelbutton;
	
	@FindBy(xpath = "//input[@value='Create']")
	WebElement clickcreatebutton;
	
	@FindBy (xpath ="//div[text()='Lender was successfully created']" )
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
	public void clickNewLender()
	{
		clicknewlender.click();
	}

	public void enterLenderName(String NameaLender) 
	{
		enterlendername.sendKeys(NameaLender);
	}
	public void enterShortcode(String NameaShortcode)
	{
		entershortcode.sendKeys(NameaShortcode);
	}
	public String nameErrorMsg()
	{
		return nameerrormsg.getText();
	}
	public boolean lenderStatus()
	{
		return lenderstatus.isSelected();
	}
	public void clickCancelButton()
	{
		clickcancelbutton.click();
	}
	public void clickCreateButton()
	{
		clickcreatebutton.click();
	}
	public String successMsg()
	{
		return successmsg.getText();
	}
	public void logOut()
	{
		logout.click();
	}
	
}
