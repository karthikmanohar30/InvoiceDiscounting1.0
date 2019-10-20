package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.EditingExternalParty;
import com.CentrumFinvisage.pageObject.ExternalPartyCreation;

public class ExternalParties extends Basesetupclass{

	@Test
	public void editExternalParty() throws Exception
	{
		System.out.println("===========CUSTOMER/VENDOR CREATION============");
		driver.get(baseurl);
		ExternalPartyCreation epc = new ExternalPartyCreation(driver);
		EditingExternalParty eep = new EditingExternalParty(driver);
		epc.setUsername(uname);
		epc.setPassword(pword);
		epc.clicklogin();
		epc.clicksettings();
		epc.clickExternalParty();
		Thread.sleep(1000);
		String expexparty = "Finvisage - External Parties";
		String actexparty = driver.getTitle();
		if(expexparty.equalsIgnoreCase(actexparty))
		{
			epc.clickNewExternalParty();
			Thread.sleep(1000);
			String expnewexparty = "Finvisage - External Party - New";
			String actnewexparty = driver.getTitle();
			if(expnewexparty.equalsIgnoreCase(actnewexparty))
			{
				epc.setExternalPartyName("Test External Party");
				epc.externalPartyStatus();
				assertTrue(true, "Status selected as inactive");

				epc.setExternalPartyId("TEP2019");
				epc.epliID();
				assertEquals(false, false, "Field is Enabled-Default should be disabled");
				epc.clickProgramDropdown();
				epc.selectProgram();
				epc.clickLenderDropdown();
				epc.selectLender();
				epc.clickCreateButton();
				String acterrormsg = "has already been taken";
				String experrormsg = epc.errorMessage();
				if(acterrormsg.equalsIgnoreCase(experrormsg))
				{
					System.out.println("External party ID must be uniqe");
					System.out.println("System doesn't create external party");
					Thread.sleep(2000);
					epc.clickCancelButton();
					String expexparty1 = "Finvisage - External Parties";
					String actexparty1 = driver.getTitle();
					if(expexparty1.equalsIgnoreCase(actexparty1))
					{
						System.out.println(" ");
					}else
					{
						System.out.println("New externalparty creation cancel button-crashed");
						takeScreenshot(driver, "Externalparty cancelbutton");
					}
				}else
				{
					epc.successfulMsg();
				}
			}else
			{
				System.out.println("External party new link-crashed");
				takeScreenshot(driver, "New Externalparty");
			}
		}else
		{
			System.out.println("Externalparty link-crashed;");
			takeScreenshot(driver, "Externalparty");
		}

		//Verifying Filters Action

		System.out.println("============VERIFYING FILTERS ACTION============");
		Thread.sleep(6000);
		eep.clickProgramFilter();
		eep.searchByProgram();
		eep.clickSearch();
		if(eep.checkElement()==true)
		{
			System.out.println("External party exists by program");
		}else
		{
			System.out.println("Externalparty searched doesn't exist");
		}
		eep.navigateBackAdminManagement();
		eep.clickExternalParty();
		eep.clickLenderFilter();
		eep.searchByLender();
		eep.clickSearch();
		if(eep.checkElement()==true)
		{
			System.out.println("External party exists by lender");
		}else
		{
			System.out.println("Externalparty searched doesn't exist");
		}
		eep.navigateBackAdminManagement();
		eep.clickExternalParty();
		eep.searchByEPID("TEP2019");
		eep.clickSearch();
		if(eep.checkElement()==true)
		{
			System.out.println("External party exists by EPID");
		}else
		{
			System.out.println("Externalparty searched doesn't exist");
		}		
		eep.clearEPID();
		eep.searchByName("Test");
		eep.clickStausDD();
		eep.selectStatus();
		eep.clickSearch();
		if(eep.verifyEPStatus()==true)
		{
			System.out.println("External party exists with 'Active' by status");
		}else
		{
			System.out.println("EP status should be active-incorrect status selected");
		}
		eep.navigateBackAdminManagement();
		eep.clickExternalParty();

		//Editing external party

		System.out.println("=============EDITING EXTERNALPARTY============");
		eep.searchByName("Test");
		eep.clickSearch();
		eep.clickEditIcon();
		eep.clickCancelButton();
		String exppage = "Finvisage - External Parties";
		String actpage = driver.getTitle();
		if(exppage.equalsIgnoreCase(actpage))
		{
			System.out.print("");
		}else
		{
			System.out.println("Externalparty cancelbutton -crashed");
			takeScreenshot(driver, "Externalparty cancelbutton");
		}
		eep.searchByName("Test");
		eep.clickSearch();
		eep.clickEditIcon();
		eep.navigateBackExteralParties();
		String exppage1 = "Finvisage - External Parties";
		String actpage1 = driver.getTitle();
		if(exppage1.equalsIgnoreCase(actpage1))
		{
			System.out.print("");
		}else
		{
			System.out.println("Navigate back external parties link-crashed");
			takeScreenshot(driver, "Navigateback EP link");
		}
		eep.searchByName("Test");
		eep.clickSearch();
		eep.clickEditIcon();
		eep.modifyEpName("Test External Party Modified");
		eep.modifyEpID("TEP2019Modified");
		Thread.sleep(4000);
		eep.clickUpdateButton();
		String expmsg = "External Party was successfully updated";
		String actmsg = eep.updateMsg();
		if(expmsg.equalsIgnoreCase(actmsg))
		{
			System.out.println("Externalparty details modified");
		}else
		{
			System.out.println("Externalparty updatebutton -crashed");
			takeScreenshot(driver, "EP updatebutton");
		}
		Thread.sleep(1000);
		eep.searchByName("Test");
		Thread.sleep(6000);
		eep.clickSearch();
		eep.clickEditIcon();
		eep.modifyEpName("Test External Party");
		eep.modifyEpID("TEP2019");
		Thread.sleep(4000);
		eep.clickUpdateButton();
		System.out.println("Externalparty detials set back");

		//Switching external party status
		Thread.sleep(7000);
		System.out.println("========SWITCHING EXTERNALPARTY STATUS=======");
		eep.searchByName("test");
		Thread.sleep(2000);
		eep.clickSearch();
		eep.clickInactiveIcon();
		System.out.println("Done");
		Thread.sleep(7000);
		eep.searchByName("Test");
		Thread.sleep(2000);
		eep.clickSearch();
		if(eep.verifyEPStatusInactive()==true)
		{
			System.out.println("Externalparty status changed to Inactive");
		}else
		{
			System.out.println("Externalparty status didn't change to Inactive");
		}
		eep.navigateBackAdminManagement();
		eep.clickExternalParty();
		eep.searchByName("test");
		Thread.sleep(2000);
		eep.clickSearch();
		eep.clickInactiveIcon();
		Thread.sleep(7000);
		eep.searchByName("Test");
		Thread.sleep(2000);
		eep.clickSearch();
		if(eep.verifyEPStatus()==true)
		{
			System.out.println("Externalparty status set back to active");
		}else
		{
			System.out.println("Externalparty status didn't change to active");
		}

		//Exporting external parties to excel		

		System.out.println("==============EXPORT TO EXCEL===============");
		eep.clickETE();
		String exppage3 = "Finvisage - External Parties";
		String acctpage3 = driver.getTitle();
		if(exppage3.equalsIgnoreCase(acctpage3))
		{
			System.out.println("Export to excel externalparties done");
		}else
		{
			System.out.println("Export to excel link crashed");
			takeScreenshot(driver, "Exxport to excel link");
		}
		eep.navigateBackAdminManagement();
		String exppage2 = "Finvisage - Admin - Home";
		String actpage2 = driver.getTitle();
		if(exppage2.equalsIgnoreCase(actpage2))
		{
			System.out.println(actpage2 +" - page");
		}else
		{
			System.out.println("Navigate back admin home link -crashed");
			takeScreenshot(driver, "Navigateback admin link");
		}
	}
}
