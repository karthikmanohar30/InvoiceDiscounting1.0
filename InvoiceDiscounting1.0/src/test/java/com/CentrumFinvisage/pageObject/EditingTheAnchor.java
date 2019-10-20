package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingTheAnchor {

	WebDriver driver;


	public EditingTheAnchor(WebDriver rdriver)
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

	@FindBy(xpath = "//i[contains(@title,'Edit Test Anchor')]")
	WebElement editanchor;


	@FindBy(id= "anchor_name")
	WebElement editanchorname;

	@FindBy(id= "anchor_ticker")
	WebElement editanchorshortcode;

	@FindBy(id= "anchor_description")
	WebElement editanchordescription;

	@FindBy(xpath = "//input[@value='Update']")
	WebElement clickupdate;

	@FindBy(xpath = "//div[text()='Anchor was successfully updated']")
	WebElement editupdatesuccessmsg;

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
	public void clickEditAnchor()
	{

		editanchor.click();

	}

	public void editAnchorName(String editanchorname1)
	{
		editanchorname.clear();
		editanchorname.sendKeys(editanchorname1);

	}
	public void editAnchorShortcode (String editanchorshortcode1)
	{
		editanchorshortcode.clear();
		editanchorshortcode.sendKeys(editanchorshortcode1);

	}
	public void editanchordescription(String editdescription)
	{
		editanchordescription.clear();
		editanchordescription.sendKeys(editdescription);
	}
	public void clickUpdateButton()
	{
		clickupdate.click();
	}
	public String editUpdateSuccessMsg()
	{
		return editupdatesuccessmsg.getText();
	}

}
