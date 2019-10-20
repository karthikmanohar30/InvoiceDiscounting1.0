package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.LenderCreation;
import com.CentrumFinvisage.pageObject.LenderEditing;

public class Lender extends Basesetupclass{

	@Test
	public void editLender() throws Exception
	{
		System.out.println("================LENDER CREATION=================");
		driver.get(baseurl);
		LenderCreation lc = new LenderCreation(driver);
		LenderEditing le = new LenderEditing(driver);
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
		
		//Editing the lender
				
		System.out.println("=============EDITING LENDER============");
		
		le.clickEditIcon();
		le.clickCancel();
		String exppage = "Finvisage - Lenders";
		String actpage = driver.getTitle();
		if(exppage.equalsIgnoreCase(actpage))
		{
			System.out.print ("");
		}else
		{
			System.out.println("Lender cancelbutton -crashed");
			takeScreenshot(driver, "Lender cancelbutton");
		}
		le.clickEditIcon();
		le.navigateBackToLender();
		String exppage1 = "Finvisage - Lenders";
		String actpage1 = driver.getTitle();
		if(exppage1.equalsIgnoreCase(actpage1))
		{
			System.out.print("");
		}else
		{
			System.out.println("Navigate backto lender link -crashed");
			takeScreenshot(driver, "Navigateback lender link");
		}
		le.clickEditIcon();	
		le.updateLenderName("Test Lender Modified");
		le.updateLenderShortcode("TL2019 Modified");
		Thread.sleep(2000);
		le.clickUpdateButton();
		String expmsg = "Lender was successfully updated";
		String actmsg =le.updateMsg();
		if(expmsg.equalsIgnoreCase(actmsg))
		{
			System.out.print("");
		}else
		{
			System.out.println("Ledner update button - crashed");
			takeScreenshot(driver, "Lender updatebutton");
		}
		System.out.println("Lender name and ID modified");
		le.clickEditIcon();
		le.updateLenderName("Test Lender");
		le.updateLenderShortcode("TL2019");
		Thread.sleep(2000);
		le.clickUpdateButton();
		System.out.println("Lender details set back");

		//Verifying filter actions
		System.out.println("================LENDER FILTER ACTION=============");
		le.clickClear();
		String exppage2 = "Finvisage - Lenders";
		String actpage2 = driver.getTitle();
		if(exppage2.equalsIgnoreCase(actpage2))
		{
			System.out.print("");
		}else
		{
			System.out.println("Filter's clear link crashed");
			takeScreenshot(driver, "Clear link");
		}

		le.searchByName("Test Lender");
		le.clickSearch();
		if(le.checkElement()==true)
		{
			System.out.println("Lender exists by name");
		}else
		{
			System.out.println("Lender doesn't existing by name");
			takeScreenshot(driver, "Lender searched by name");
		}
		le.clickClear();
		le.searchByShortcode("TL2019");
		le.clickSearch();
		if(le.checkElement()==true)
		{
			System.out.println("Lender exists shortcode");
		}else
		{
			System.out.println("Lender doesn't existing by shortcode");
			takeScreenshot(driver, "Lender searched by shortcode");
		}
		le.clickClear();
		le.clickStatusDD();
		le.searchByStatus();
		le.clickSearch();
		if(le.checkElement()==true)
		{
			System.out.println("Lender exists active status");
		}else
		{
			System.out.println("Lender doesn't existing by status");
			takeScreenshot(driver, "Lender searched by status");
		}

		//Switching lender status

		System.out.println("===========Switching Lender Status===========");
		le.clickInactiveIcon();
		String expmsg1 = "Lender was successfully updated";
		String actmsg1 =le.updateMsg();
		if(expmsg1.equalsIgnoreCase(actmsg1))
		{
			System.out.println("Lender status changed to Inactive");
		}else
		{
			System.out.println("Ledner inactive button - crashed");
			takeScreenshot(driver, "Lender inactivebutton");
		}
		le.clickStatusDD();
		le.searchByStatus1();
		le.clickSearch();
		if(le.checkElement()==true)
		{
			System.out.println("Lender existing by Inactive status");
		}else
		{
			System.out.println("Lender doesn't existing by Inactivestatus");
			takeScreenshot(driver, "Lender searched by Inactivestatus");
		}
		le.clickInactiveIcon();
		System.out.println("Lender status changed back to Active");		

		//Export to excel action
		System.out.println("=============Export to excel===============");
		le.clickETE();
		String exppage4 = "Finvisage - Lenders";
		String actpage4 = driver.getTitle();
		if(exppage4.equalsIgnoreCase(actpage4))
		{
			System.out.println("Export to excel done");
		}else
		{
			System.out.println("Export to excel link crashed");
			takeScreenshot(driver, "Export to excel");
		}
		
		System.out.println("===========Adminmanagement home============");
		le.navigateBackAdminManagement();
		String exppage3 = "Finvisage - Admin - Home";
		String actpage3 = driver.getTitle();
		if(exppage3.equalsIgnoreCase(actpage3))
		{
			System.out.println(actpage3);
		}else
		{
			System.out.println("Adminmanagement link crashed");
			takeScreenshot(driver, "Adminmanagement homepage");
		}
	}
}
