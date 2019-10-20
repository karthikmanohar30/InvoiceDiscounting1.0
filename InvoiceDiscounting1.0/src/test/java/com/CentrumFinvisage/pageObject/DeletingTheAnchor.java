package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletingTheAnchor {

	WebDriver driver;

	public DeletingTheAnchor(WebDriver rdriver)
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

	@FindBy(xpath = "//i[@title='Delete Test Anchor']")
	WebElement deleteanchor;

	@FindBy(xpath = "//div[text()='Anchor was successfully deleted']")
	WebElement deletesuccessmsg;

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
	public void clickdeleteanchor()
	{
		deleteanchor.click();
		driver.switchTo().alert().accept();
	}
	public String deleteSuccessMsg()
	{
		return deletesuccessmsg.getText();
		
		
	}
}
