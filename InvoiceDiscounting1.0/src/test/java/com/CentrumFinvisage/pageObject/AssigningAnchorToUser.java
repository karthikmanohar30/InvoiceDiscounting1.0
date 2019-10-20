package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssigningAnchorToUser {
	
	WebDriver driver;
	public AssigningAnchorToUser(WebDriver rdriver)
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
	
	@FindBy(xpath = "//p[text()='Users Management']")
	WebElement clickusermanagement;
	
	@FindBy(xpath = "//a[@href='/user_groups']")
	WebElement clickusergroups;
	
	@FindBy(xpath = "//a[text()='Test user group']")
	WebElement clickgroupname;
	
	@FindBy(xpath = "//a[text()='Manage Test user group']")
	WebElement clickmanageusergroup;
	
	@FindBy(xpath = "(//div[@class='selectize-control select optional selectize multi plugin-remove_button'])[2]")
	WebElement clickassignanchordropdown;
	
	@FindBy(xpath = "//div[text()='Test Anchor']")
	WebElement selectanchor;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement clicksubmit;
	
	@FindBy(xpath = "//div[text()='UserGroup details were successfully updated']")
	WebElement updatemsg;
	
	
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
	public void clickUserManagement()
	{
		clickusermanagement.click();
	}
	public void clickUserGroups()
	{
		clickusergroups.click();
	}
	public void clickGroupName()
	{
		clickgroupname.click();
	}
	public void clickManageUserGroup()
	{
		clickmanageusergroup.click();
	}
	public void clickAssignAnchorDropdown()
	{
		clickassignanchordropdown.click();
	}
	public void selectAnchor()
	{
		selectanchor.click();
	}
	public void clickSubmit()
	{
		clicksubmit.click();
	}
	public String updateMsg()
	{
		return updatemsg.getText();
	}
	
}
