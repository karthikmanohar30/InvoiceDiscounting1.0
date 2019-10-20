package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.CentrumFinvisage.pageObject.ExternalPartyCreation;

public class CreateExternalParty extends Basesetupclass{

	@Test
	public void createExternalParty() throws Exception
	{
		System.out.println("===========CUSTOMER/VENDOR CREATION============");
		driver.get(baseurl);
		ExternalPartyCreation epc = new ExternalPartyCreation(driver);
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
	}
}
