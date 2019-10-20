package com.CentrumFinvisage.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	public Loginpage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id="user_login")
	WebElement username;

	@FindBy(id="user_password")
	WebElement password;

	@FindBy(name="commit")
	WebElement loginbutton;
	
	@FindBy(xpath = "//div[text()='Invalid Login or password.']")
	WebElement invalidlogin;
	
	@FindBy(xpath = "//a[@href='/users/sign_out']")
	WebElement logout;

	public void setUsername(String Usernames)
	{
		username.sendKeys(Usernames);
	}
	public void setPassword(String Passwords)
	{
		password.sendKeys(Passwords);
	}
	public void clicklogin()
	{
		loginbutton.click();
	}
	public String invalidLogin()
	{
		return invalidlogin.getText();
	}
	public void logoutApplication()
	{
		logout.click();
	}
}
