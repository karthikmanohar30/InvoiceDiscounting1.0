package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.CentrumFinvisage.pageObject.NewInvoiceCreation;

public class CreateNewInvoice extends Basesetupclass{

	@Test
	public void createNewInvoice() throws Exception
	{
		System.out.println("=============NEW INVOICE CREATION==============");
		driver.get(baseurl);
		NewInvoiceCreation nic = new  NewInvoiceCreation(driver);
		nic.setUsername(uname);
		nic.setPassword(pword);
		nic.clicklogin();
		nic.clickForecastViews();
		String expforecastviewstitle = "Finvisage - Forecast Views";
		String actforecastviewstitle = driver.getTitle();
		if(expforecastviewstitle.equalsIgnoreCase(actforecastviewstitle))
		{
			nic.selectAForecastView();
			String expselectedforecast = "Finvisage - Test Anchor - Forecast View";
			String actselectedforecast = driver.getTitle();
			if(expselectedforecast.equalsIgnoreCase(actselectedforecast)) 
			{
				nic.clickDotsIcon();
				nic.clickAddNewInvoice();
				String expnewinvoicepage = "Finvisage - New invoice";
				String actnewinvoicepage = driver.getTitle();
				if(expnewinvoicepage.equalsIgnoreCase(actnewinvoicepage))
				{
					Thread.sleep(2000);
					nic.clickProgram();
					Thread.sleep(2000);
					nic.selectProgram();
					Thread.sleep(2000);
					nic.clickExternalParty();
					Thread.sleep(2000);
					nic.selectExternalParty();
					Thread.sleep(2000);
					nic.selectLender();
					assertEquals(true, true, "Lender not selected");
					nic.setAccountID("TestAccountID2019");
					Thread.sleep(2000);
					nic.setInvoiceDate("01/01/2019");
					Thread.sleep(2000);
					String accountidacterrormsg = "must be unique.";
					String accountidexperrormsg = nic.accountIDError();
					if(accountidacterrormsg.equalsIgnoreCase(accountidexperrormsg))
					{
						System.out.println("Account ID "+ nic.accountIDError());
						System.out.println("System doesn't create invoice");
						Thread.sleep(2000);
						nic.clickCancel();
						String expselectedforecast1 = "Finvisage - Test Anchor - Forecast View";
						String actselectedforecast1 = driver.getTitle();
						if(expselectedforecast1.equalsIgnoreCase(actselectedforecast1))
						{
							System.out.println(" ");
						}else
						{
							System.out.println("Invoice creation cancelbutton-crashed");
							takeScreenshot(driver, "Invoice cancelbutton");
						}
						
					}else
					{
						nic.setDueDate("31/03/2019");
						Thread.sleep(2000);
						nic.clickFacility();
						Thread.sleep(2000);
						nic.setFacility();
						nic.tagName();
						assertEquals(true, true, "Tag not selected");
						nic.setInvoiceNo("TestInvoiceNO2019");
						Thread.sleep(2000);
						nic.setLoanAmount("1000000");
						Thread.sleep(2000);
						nic.setMargin("1000");
						nic.dueAmount();
						assertEquals(false, false, "Field is enabled-but default should be disabled");
						nic.descriptioN("Transaction created for testing");
						nic.clickCreate();	
						String actsuccessmsg = "Invoice was successfully created";
						String expsuccessmsg =nic.successMsg();
						if(actsuccessmsg.equalsIgnoreCase(expsuccessmsg))
						{
							System.out.println(nic.successMsg());	
						}else
						{
							System.out.println("Unable to create an Invoice-crashed");
							takeScreenshot(driver,"Invoice creation");
						}
					}	
				}else
				{
					System.out.println("Add new invoice link - crashed");
					takeScreenshot(driver, "Add new invoice");
				}
			}else
			{
				System.out.println("Forecast view selected -crashed");
				takeScreenshot(driver, "Forecastview selection");
			}
		}else
		{
			System.out.println("Forecast view link - crashed");
			takeScreenshot(driver, "Forecast views");
		}		
	}
}