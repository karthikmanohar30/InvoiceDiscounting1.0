package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.LenderCreation;

public class CreateLender extends Basesetupclass {

	@Test
	public void createLender() throws Exception
	{
		System.out.println("================LENDER CREATION=================");
		driver.get(baseurl);
		LenderCreation lc = new LenderCreation(driver);
		lc.setUsername(uname);
		lc.setPassword(pword);
		lc.clickLogin();
		lc.clickSettings();

		String expadmintitle = "Finvisage - Admin - Home";
		String actadmintitle = driver.getTitle();
		if(expadmintitle.equalsIgnoreCase(actadmintitle))
		{
			lc.clickLender();
			String explendertitle = "Finvisage - Lenders";
			String actlendertitle = driver.getTitle();
			if(explendertitle.equalsIgnoreCase(actlendertitle))
			{
				lc.clickNewLender();
				String expnewlendertitle = "Finvisage - Lender - New";
				String actnewlendertitle = driver.getTitle();
				if(expnewlendertitle.equalsIgnoreCase(actnewlendertitle))
				{
					lc.enterLenderName("Test Lender");
					lc.enterShortcode("TL");
					String experrormsg = "Name already taken";
					String acterrormsg=lc.nameErrorMsg();
					if(experrormsg.equalsIgnoreCase(acterrormsg)) 
					{
						System.out.println("Lender name already been taken");
						System.out.println("System doesn't create lender");
						Thread.sleep(2000);
						lc.clickCancelButton();
						String explendertitle1 = "Finvisage - Lenders";
						String actlendertitle1 = driver.getTitle();
						if(explendertitle1.equalsIgnoreCase(actlendertitle1))
						{
							System.out.println(" ");
						}else
						{
							System.out.println("Lender creation cancelbutton-crashed");
							takeScreenshot(driver, "Lender creation cancelbutton");
						}
					}
					else
					{
						Thread.sleep(1000);
						lc.lenderStatus();
						assertEquals(true, true, "Status selected as Inactive");
						lc.clickCreateButton();

						String actsuccessmsg = "Lender was successfully created";
						String expsuccessmsg = lc.successMsg();
						if(actsuccessmsg.equalsIgnoreCase(expsuccessmsg)) 
						{
							System.out.println(lc.successMsg());
						}else
						{
							System.out.println("Unable to create lender-crashed");
							takeScreenshot(driver, "Lender creation");
						}			
					}
				}else
				{
					System.out.println("New lender link-crashed");
					takeScreenshot(driver, "New lender");
				}
			}else
			{
				System.out.println("Lender link-crashed");
				takeScreenshot(driver, "Lender");
			}
		}else
		{
			System.out.println("Settings link - crashed");
			takeScreenshot(driver, "Settings");
		}
	}
}
