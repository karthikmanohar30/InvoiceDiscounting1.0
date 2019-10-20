package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingTheProgram {

	WebDriver driver;

	public EditingTheProgram(WebDriver rdriver)
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

	@FindBy(xpath = "//a[@href='/admin/home']")
	WebElement settingsTab;

	@FindBy (xpath = "//a[@href='/programs']")
	WebElement clickprograms;

	@FindBy(xpath = "//i[contains(@title,'Edit Test Program')]")
	WebElement clickediticon;

	@FindBy(id = "program_name")
	WebElement updateprogramname;

	@FindBy(id = "program_internal_id")
	WebElement updateprogramid;

	@FindBy(xpath = "(//div[@class='selectize-control selectize standard_select single plugin-remove_button'])[1]")
	WebElement clickanchordropdown;	

	@FindBy(id = "program_description")
	WebElement enterdescription;

	@FindBy(xpath = "//input[@value='Update']")
	WebElement clickupdatebutton;

	@FindBy(xpath = "(//a[@href='/programs'])[2]")
	WebElement clickcancelbutton;

	@FindBy(xpath = "(//a[@href='/programs'])[2]")
	WebElement navigatebacktoprograms;

	@FindBy(xpath = "//div[text()='Program successfully updated']")
	WebElement updatemsg;

	@FindBy(id = "q_name_cont")
	WebElement searchbyname;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement clicksearch;

	@FindBy(xpath = "//i[contains(@title,'Make Test Program')]")
	WebElement clickinactiveicon;

	@FindBy(xpath = "(//a[@href='/admin/home'])[2]")
	WebElement clickadminmanagement;

	@FindBy(id = "q_internal_id_cont")
	WebElement searchbyprogramid;

	@FindBy (xpath = "(//div[@class='selectize-control selectize standard_select single plugin-remove_button'])[1]")
	WebElement clicksearchbyanchor;

	@FindBy (xpath = "//div[text()='Test Anchor']")
	WebElement searchbyanchor;

	@FindBy(xpath = "//td[text()='Test Anchor']//..//td[text()='TP2019']")
	WebElement checkanchorelement;

	@FindBy(xpath = "//a[@href='/programs']")
	WebElement clearfilter;

	@FindBy (xpath = "(//div[@class='selectize-control selectize standard_select single plugin-remove_button'])[2]")
	WebElement clicksearchbystatus;

	@FindBy (xpath = "//div[text()='Active']")
	WebElement selectstatustosearch;

	@FindBy (xpath = "//div[text()='Inactive']")
	WebElement selectstatustosearch1;

	@FindBy(xpath = "//span[text()='Active']//..//..//td[text()='TP2019']")
	WebElement programwithactive;

	@FindBy (xpath = "//span[text()='Inactive']//..//..//td[text()='TP2019']")
	WebElement programwithinactive;

	@FindBy (xpath = "//a[@href='/programs.xlsx']")
	WebElement clickete;	

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
	public void clickProgram() {
		clickprograms.click();
	}
	public void clickEditIcon()
	{
		clickediticon.click();
	}
	public void updateProgramName(String UpdateProgramName)
	{
		updateprogramname.clear();
		updateprogramname.sendKeys(UpdateProgramName);
	}
	public void updateProgramID(String UpdateProgramID)
	{
		updateprogramid.clear();
		updateprogramid.sendKeys(UpdateProgramID);
	}
	public void clickAnchorDropdown()
	{
		clickanchordropdown.click();
	}
	public void enterDescription(String EnterTheDescription)
	{
		enterdescription.clear();
		enterdescription.sendKeys(EnterTheDescription);
	}
	public void clickUpdateButton()
	{
		clickupdatebutton.click();
	}
	public void clickCancelButton()
	{
		clickcancelbutton.click();
	}
	public void navigateBacktoPrograms()
	{
		navigatebacktoprograms.click();
	}
	public String updateMsg()
	{
		return updatemsg.getText();
	}
	public void searchByName(String Enterprogramnametosearch)
	{
		searchbyname.sendKeys(Enterprogramnametosearch);
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
	public void clickAdminManagement()
	{
		clickadminmanagement.click();
	}
	public void searchByProgramID(String EnterProgramID)
	{
		searchbyprogramid.sendKeys(EnterProgramID);
	}
	public void clickSearchByAnchor()
	{
		clicksearchbyanchor.click();
	}
	public void searchByAnchor()
	{
		searchbyanchor.click();
	}
	public boolean checkAnchorElement()
	{
		return checkanchorelement.isDisplayed();
	}
	public void clearFilter()
	{
		clearfilter.click();
	}
	public void clickSearchByStatus()
	{
		clicksearchbystatus.click();
	}
	public void selectStatusToSearch()
	{
		selectstatustosearch.click();
	}
	public void selectStatusToSearch1()
	{
		selectstatustosearch1.click();
	}
	public boolean programWithActive()
	{
		return programwithactive.isDisplayed();
	}
	public boolean programWithInactive()
	{
		return programwithinactive.isDisplayed();
	}
	public void clickETE()
	{
		clickete.click();
	}
}