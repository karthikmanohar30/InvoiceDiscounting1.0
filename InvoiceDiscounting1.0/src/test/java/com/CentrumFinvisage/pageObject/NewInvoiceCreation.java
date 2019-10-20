package com.CentrumFinvisage.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewInvoiceCreation {

	WebDriver driver;
	public NewInvoiceCreation(WebDriver rdriver)
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

	@FindBy(xpath="//a[@href='/forecast_views']")
	WebElement clickforecastviews;
	
	@FindBy(xpath = "//span[text()='Test_ForecastView']")
	WebElement selectaforecastview;

	@FindBy(xpath = "//a[@title='More actions']")
	WebElement clickedotsicon;

	@FindBy(xpath = "//a[text()=' Add new invoice']")
	WebElement clickaddnewinvoice;

	@FindBy(xpath = "(//div[@class='selectize-input items not-full has-options'])[1]")
	WebElement clickprogram;

	@FindBy(xpath = "//div[text()='Test Program (TP2019)']")
	WebElement selectprogram;

	@FindBy(xpath = "(//div[@class='selectize-control select required selectize single plugin-remove_button'])[2]")
	WebElement clickexternalparty;

	@FindBy(xpath = "//div[text()='Test External Party ( TEP2019 )']")
	WebElement selectexternalparty;

	@FindBy(xpath = "//div[text()='Test Lender']")
	WebElement selectlender;

	@FindBy(id = "transaction_internal_id")
	WebElement setaccountid;

	@FindBy(id = "transaction_scheduled_at")
	WebElement setinvoicedate;

	@FindBy(id = "transaction_internal_id-error")
	WebElement accountiderror;

	@FindBy(id = "transaction_payment_at")
	WebElement setduedate;

	@FindBy(xpath = "//div[@class='selectize-control selectize single plugin-remove_button']")
	WebElement clickfacility;

	@FindBy(xpath = "//div[text()='Test Facility']")
	WebElement setfacility;

	@FindBy(id = "tag_name")
	WebElement tagname;

	@FindBy(id = "transaction_external_id")
	WebElement setinvoiceno;

	@FindBy(id = "transaction_amount")
	WebElement setloanamount;

	@FindBy(id = "transaction_margin")
	WebElement setmargin;

	@FindBy(id = "net_amount")
	WebElement dueamount;

	@FindBy(id = "transaction_description")
	WebElement description;

	@FindBy(id = "cancel_transaction")
	WebElement clickcancel;

	@FindBy(xpath = "//input[@value='Create']")
	WebElement clickcreate;

	@FindBy(xpath = "//div[text()='Invoice was successfully created']")
	WebElement successmsg;



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
	public void clickForecastViews()
	{
		clickforecastviews.click();
	}
	public void selectAForecastView()
	{
		String oldtab = driver.getWindowHandle();
		selectaforecastview.click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldtab);
		driver.switchTo().window(newTab.get(0));
	}
	public void clickDotsIcon()
	{
		clickedotsicon.click();
	}
	public void clickAddNewInvoice()
	{
		clickaddnewinvoice.click();
	}
	public void clickProgram()
	{
		clickprogram.click();	

	}

	public void selectProgram()
	{
		selectprogram.click();
	}
	public void clickExternalParty()
	{
		clickexternalparty.click();
	}

	public void selectExternalParty()
	{
		selectexternalparty.click();
	}
	public boolean selectLender()
	{
		return selectlender.isDisplayed();
	}
	public void setAccountID(String EnterAccountID)
	{
		setaccountid.sendKeys(EnterAccountID);
	}
	public void setInvoiceDate(String EnterInvoiceDate)
	{
		for(int i=0; i<10; i++)
		{
			setinvoicedate.sendKeys(Keys.BACK_SPACE);
		}
		setinvoicedate.sendKeys(EnterInvoiceDate);
	}
	public String accountIDError()
	{
		return accountiderror.getText();
	}
	public void setDueDate(String EnterDueDate)
	{
		for(int i=0;i<10;i++) 
		{
			setduedate.sendKeys(Keys.BACK_SPACE);
		}
		setduedate.sendKeys(EnterDueDate);
	}
	public void clickFacility()
	{
		clickfacility.click();
	}

	public void setFacility()
	{
		setfacility.click();
	}
	public boolean tagName()
	{
		return tagname.isDisplayed();
	}
	public void setInvoiceNo(String EnterInvoiceNo)
	{
		setinvoiceno.sendKeys(EnterInvoiceNo);
	}
	public void setLoanAmount(String EnterLoanAmount)
	{
		setloanamount.click();
		setloanamount.sendKeys(EnterLoanAmount);
	}
	public void setMargin(String EnterMargin)
	{
		setmargin.click();
		setmargin.sendKeys(EnterMargin);
	}
	public boolean dueAmount()
	{
		return dueamount.isEnabled();
	}
	public void descriptioN(String EnterDescription)
	{
		description.sendKeys(EnterDescription);

	}
	public void clickCancel()
	{
		clickcancel.click();
	}
	public void clickCreate()
	{
		clickcreate.click();
	}
	public String successMsg()
	{
		return successmsg.getText();
	}

}
