package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExternalPartyCreation {
	
	WebDriver driver;
	public ExternalPartyCreation(WebDriver rdriver)
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
	
	@FindBy(xpath = "//a[@href='/external_parties']")
	WebElement clickexternalparty;
	
	@FindBy(xpath = "//a[@href='/external_parties/new']")
	WebElement clicknewexternalparty;
	
	@FindBy(xpath = "//input[@name='external_party[name]']")
	WebElement setexternalpartyname;
	
	@FindBy(xpath = "//label[text()='Active']")
	WebElement externalpartystatus;
	
	@FindBy(xpath = "//input[@id='external_party_internal_id']")
	WebElement setexternalpartyid;
	
	@FindBy(xpath = "//input[@id='external_party_lender_internal_id']")
	WebElement epliid;
	
	@FindBy(xpath = "(//div[@class='selectize-control select required selectize single plugin-remove_button'])[1]")
	WebElement clickprogramdropdown;
	
	@FindBy(xpath = "//div[text()='Test Program (TP2019)']")
	WebElement selectprogram;
	
	@FindBy(xpath = "(//div[@class='selectize-control select required selectize single plugin-remove_button'])[2]")
	WebElement clicklenderdropdown;
	
	
	@FindBy(xpath = "//div[text()='Test Lender']")
	WebElement selectlender;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement clickcancelbutton;
	
	@FindBy(xpath = "//input[@value='Create']")
	WebElement clickcreatebutton;
	
	@FindBy(xpath = "//span[text()='has already been taken']")
	WebElement errormessage;
	
	@FindBy (xpath ="//div[text()='Customer/Vendor was successfully created']" )
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
	public void clickExternalParty()
	{
		clickexternalparty.click();
	}
	public void clickNewExternalParty()
	{
		clicknewexternalparty.click();
	}
	
	public void setExternalPartyName(String Enterexternalpartyname)
	{
		setexternalpartyname.sendKeys(Enterexternalpartyname);
	}
	public boolean externalPartyStatus()
	{
		return externalpartystatus.isSelected();
	}
	public void setExternalPartyId(String EnterexternalpartyID )
	{
		setexternalpartyid.sendKeys(EnterexternalpartyID);
	}
	public boolean epliID()
	{
		return epliid.isEnabled();
	}
	public void clickProgramDropdown()
	{
		clickprogramdropdown.click();
	}
	public void selectProgram()
	{
		selectprogram.click();
	}
	public void clickLenderDropdown()
	{
		clicklenderdropdown.click();
	}
	public void selectLender()
	{
		selectlender.click();
	}
	public void clickCancelButton()
	{
		clickcancelbutton.click();
	}
	public void clickCreateButton()
	{
		clickcreatebutton.click();
	}
	public String errorMessage()
	{
		return errormessage.getText();
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
