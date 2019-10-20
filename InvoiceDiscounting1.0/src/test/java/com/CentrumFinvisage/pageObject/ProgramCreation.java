package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramCreation {

	WebDriver driver;
	public ProgramCreation(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(driver, this);
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

	@FindBy(xpath = "//a[@href='/programs/new']")
	WebElement clicknewprogram;

	@FindBy(xpath = "//input[@id='program_name']")
	WebElement enterprogramname;

	@FindBy(xpath = "//input[@id='program_internal_id']")
	WebElement enterprogramid;

	@FindBy (xpath = "//div[@class='selectize-input items not-full has-options']")
	WebElement clickonanchor;

	@FindBy (xpath="//span[@id='program_internal_id-error']")
	WebElement errormessage;

	@FindBy (xpath="//a[text()='Cancel']")
	WebElement cancelbutton;

	@FindBy(xpath = "//div[text()='Test Anchor']")
	WebElement selectanchor;

	@FindBy(xpath = "//label[text()='Active']")
	WebElement defaultprogramstatus;

	@FindBy(xpath = "//textarea[@id='program_description']")
	WebElement enterdescription;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement clickoncreate;
	
	@FindBy(xpath = "//div[text()='Program was successfully created']")
	WebElement successmessage;
	
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
	public void clickProgram() {
		clickprograms.click();
	}
	public void clickNewProgram() {
		clicknewprogram.click();
	}
	public void enterProgramName(String EnterTheProgramName) {
		enterprogramname.sendKeys(EnterTheProgramName);
	}
	public void enterProgramId(String EnterTheProgramID)
	{
		enterprogramid.sendKeys(EnterTheProgramID);
	}
	public void clickOnAnchorDropdown() {
		clickonanchor.click();
	}

	public String errorMessage()
	{
		return errormessage.getText();

	}
	public void cancelButton()
	{
		cancelbutton.click();
	}

	public void selectAnchor() {
		selectanchor.click();
	}
	public String defaultProgramStatus() {
		return defaultprogramstatus.getText();
	}
	public void enterDescription(String enterprogramdescription) {
		enterdescription.sendKeys(enterprogramdescription);
	}
	public void clickOnCreate() {
		clickoncreate.click();
	}
	public String successMessage()
	{
		return successmessage.getText();
	}
	public void logOut()
	{
		logout.click();
	}
}
