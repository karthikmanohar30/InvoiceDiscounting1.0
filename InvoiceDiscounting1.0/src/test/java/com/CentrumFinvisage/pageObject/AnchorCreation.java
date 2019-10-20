package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnchorCreation {

	WebDriver driver;
	public AnchorCreation(WebDriver rdriver)
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

	@FindBy (xpath = "//p[text()='Anchor']")
	WebElement anchorLink;

	@FindBy (xpath = "//a[@href='/anchors/new']")
	WebElement newanchorLink;

	@FindBy(id="anchor_name")
	WebElement enteranchorname;

	@FindBy(id="anchor_ticker")
	WebElement enteranchorshortcode;

	@FindBy(id= "anchor_name-error")
	WebElement acterrormsg;

	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelbutton;

	@FindBy(xpath ="//div[@class='selectize-input items not-full has-options']")
	WebElement leveldropdown;

	@FindBy(xpath ="//div[@data-value='2']")
	WebElement selectlevel;

	@FindBy(xpath ="//div[@class='selectize-control select optional concern_parent selectize single plugin-remove_button']")
	WebElement parentdropdown;

	@FindBy(xpath ="//div[contains(text(),'L&T')]")
	WebElement selectparentanchor;

	@FindBy(id = "anchor_description")
	WebElement description;

	@FindBy(xpath = "//input[@value='Create']")
	WebElement clickcreate;

	@FindBy (xpath ="//div[text()='Anchor was successfully created']" )
	WebElement successmsg;

	@FindBy(xpath="//a[@href='/users/sign_out']")
	WebElement logout;

	@FindBy(xpath = "//a[text()='Admin Management']")
	WebElement adminmanagement;


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
	public void clickAnchor()
	{
		anchorLink.click();
	}
	public void clicknewAnchor()
	{
		newanchorLink.click();
	}
	public void enterAnchorName(String NameAnAnchor)
	{
		enteranchorname.sendKeys(NameAnAnchor);
	}
	public void enterAnchorShortcode(String EnterAnchorShortcode)
	{
		enteranchorshortcode.sendKeys(EnterAnchorShortcode);

	}
	public String errorMessage()
	{
		return acterrormsg.getText();

	}
	public void clickCancelButton()
	{
		cancelbutton.click();
	}
	public void levelDropdown()
	{
		leveldropdown.click();
	}
	public void selectLevel()
	{
		selectlevel.click();
	}
	public void parentDropdown()
	{
		parentdropdown.click();
	}
	public void selectParent()
	{
		selectparentanchor.click();
	}
	public void enterDescription(String enterdescription)
	{
		description.sendKeys(enterdescription);
	}
	public void clickOnCreate()
	{
		clickcreate.click();
	}
	public String successfulMsg()
	{
		return successmsg.getText();
	}
	public void logOut()
	{
		logout.click();
	}
	public void adminManagement()
	{
		adminmanagement.click();
	}
}

