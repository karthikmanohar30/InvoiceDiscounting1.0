package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingExternalParty {

	WebDriver driver;
	public EditingExternalParty(WebDriver rdriver)
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

	@FindBy(xpath = "//i[contains(@title,'Edit Test External Party')]")
	WebElement clickediticon;

	@FindBy(xpath = "(//a[@href='/external_parties'])[2]")
	WebElement clickcancelbutton;

	@FindBy(xpath = "(//a[@href='/external_parties'])[1]")
	WebElement navigatebackexternalparties;

	@FindBy(id = "external_party_name")
	WebElement modifyepname;

	@FindBy(id = "external_party_internal_id")
	WebElement modifyepid;

	@FindBy(xpath = "//input[@value='Update']")
	WebElement clickupdatebutton;

	@FindBy(xpath = "//div[text()='External Party was successfully updated']")
	WebElement updatemsg;

	@FindBy(id = "q_name_cont")
	WebElement searchbyname;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement clicksearch;

	@FindBy(xpath = "//i[contains(@title,'Make Test External Party')]")
	WebElement clickinactiveicon;

	@FindBy(xpath = "//a[@href='/external_parties.xlsx']")
	WebElement clickete;

	@FindBy(xpath = "//td[text()='TEP2019']")
	WebElement checkelement;

	@FindBy(xpath = "(//div[@class='selectize-control selectize standard_select single plugin-remove_button'])[1]")
	WebElement clickprogramfilter;

	@FindBy(xpath = "//div[text()='Test Program (TP2019)']")
	WebElement searchbyprogram;

	@FindBy(xpath = "(//div[@class='selectize-control selectize standard_select single plugin-remove_button'])[2]")
	WebElement clicklenderfilter;

	@FindBy(xpath = "//div[text()='Test Lender']")
	WebElement searchbylender;

	@FindBy(id = "q_internal_id_cont")
	WebElement searchbyepid;

	@FindBy(xpath = "//span[text()='Active']//..//..//td[text()='TEP2019']")
	WebElement verifyepstatus;

	@FindBy(xpath = "(//a[@href='/admin/home'])[2]")
	WebElement navigatebackadminmanagement;	
	
	@FindBy(xpath = "(//div[@class='selectize-control selectize standard_select single plugin-remove_button'])[3]")
	WebElement clickstatusdd;
	
	@FindBy(xpath = "//div[text()='Active']")
	WebElement selectstatus;
	
	@FindBy(xpath = "//span[text()='Inactive']//..//..//td[text()='TEP2019']")
	WebElement verifyepstatusinactive;
	
	
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
	public void clickEditIcon()
	{
		clickediticon.click();
	}
	public void clickCancelButton()
	{
		clickcancelbutton.click();
	}
	public void navigateBackExteralParties()
	{
		navigatebackexternalparties.click();
	}
	public void modifyEpName(String UpdateEpName)
	{
		modifyepname.clear();
		modifyepname.sendKeys(UpdateEpName);
	}
	public void modifyEpID(String UpdateEpID)
	{
		modifyepid.clear();
		modifyepid.sendKeys(UpdateEpID);
	}
	public void clickUpdateButton()
	{
		clickupdatebutton.click();
	}
	public String updateMsg()
	{
		return updatemsg.getText();
	}
	public void searchByName(String EnterEpName)
	{
		searchbyname.sendKeys(EnterEpName);
	}
	public void clickSearch()
	{
		clicksearch.click();
	}
	public void clickInactiveIcon()
	{
		clickinactiveicon.click();
		driver.switchTo().alert().accept();
	}
	public void clickETE()
	{
		clickete.click();
	}
	public boolean checkElement()
	{
		return checkelement.isDisplayed();
	}
	public void clickProgramFilter()
	{
		clickprogramfilter.click();
	}
	public void searchByProgram()
	{
		searchbyprogram.click();
	}
	public void clickLenderFilter()
	{
		clicklenderfilter.click();
	}
	public void searchByLender()
	{
		searchbylender.click();
	}
	public void searchByEPID(String EnterExternalPartyIDtoSearch)
	{
		searchbyepid.sendKeys(EnterExternalPartyIDtoSearch);
	}
	public boolean verifyEPStatus()
	{
		return verifyepstatus.isDisplayed();
	}
	public void navigateBackAdminManagement()
	{
		navigatebackadminmanagement.click();
	}
	public void clickStausDD()
	{
		clickstatusdd.click();
	}
	public void selectStatus()
	{
		selectstatus.click();
	}
	public boolean verifyEPStatusInactive()
	{
		return verifyepstatusinactive.isDisplayed();
	}
	public void clearEPID()
	{
		searchbyepid.clear();
	}
}
