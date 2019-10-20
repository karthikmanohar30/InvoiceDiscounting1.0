package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.EditingTheFacility;
import com.CentrumFinvisage.pageObject.FacilityCreation;
import com.CentrumFinvisage.pageObject.MakeFacilityInactive;

public class Facility extends Basesetupclass {

	@Test
	public void editFacility() throws Exception
	{
		System.out.println("===============FACILITY CREATION==============");
		driver.get(baseurl);
		FacilityCreation fc = new FacilityCreation(driver);
		EditingTheFacility etf = new EditingTheFacility(driver);
		MakeFacilityInactive mfi = new MakeFacilityInactive(driver);
		fc.setUsername(uname);
		fc.setPassword(pword);
		fc.clicklogin();
		fc.clicksettings();

		String expadmintitle = "Finvisage - Admin - Home";
		String actadmintitle = driver.getTitle();
		if(expadmintitle.equalsIgnoreCase(actadmintitle))
		{
			fc.clickFacility();
			String expfacilitytitle = "Finvisage - Facility";
			String actfacilitytitle = driver.getTitle();
			if(expfacilitytitle.equalsIgnoreCase(actfacilitytitle))
			{
				fc.clickNewFacility();
				String expnewfacilitytitle = "Finvisage - Facility - New";
				String actnewfacilitytitle = driver.getTitle();
				if(expnewfacilitytitle.equalsIgnoreCase(actnewfacilitytitle))
				{
					fc.setFacilityName("Test Facility");
					fc.facilityStatus();
					assertEquals(true, true, "facility status selected as Inactive");
					fc.clickCreateButton();
					Thread.sleep(1000);
					String experrormessage = "has already been taken";
					String actualerrormessage = fc.nameErrorMessage();
					if(experrormessage.equalsIgnoreCase(actualerrormessage))
					{
						System.out.println("Facility name already been taken");
						System.out.println("System doesn't create facility");
						fc.clickCancelButton();
						String expfacilitytitle1 = "Finvisage - Facility";
						String actfacilitytitle1 = driver.getTitle();
						if(expfacilitytitle1.equalsIgnoreCase(actfacilitytitle1))
						{
							System.out.println(" ");
						}else
						{
							System.out.println("Facility creation cancelbutton-crashed");
							takeScreenshot(driver, "Facility creation cancelbutton");
						}
					}else
					{
						System.out.println(fc.successfulMsg() + " ");
					}
				}else
				{
					System.out.println("New facility link -crashed");
					takeScreenshot(driver, "New facility");
				}
			}else
			{
				System.out.println("Facility link - crashed");
				takeScreenshot(driver, "Facility");
			}
		}else
		{
			System.out.println("Settings link - crashed");
			takeScreenshot(driver, "Settings");
		}

		//Editing the facility		

		System.out.println("=============EDITING THE FACILITY=============");
		
		etf.clickOnEditFacility();
		etf.editFacilityName("Test Faciltity Modified");
		etf.clickInactive();
		etf.clickCancel();
		String exppage = "Finvisage - Facility";
		String actpage = driver.getTitle();
		if(exppage.equalsIgnoreCase(actpage))
		{
			System.out.print("");
		}else
		{
			System.out.println("Facility cancel button");
			takeScreenshot(driver, "Facility cancelbutton");
		}
		etf.clickOnEditFacility();
		etf.navigateFacility();
		String exppage1 = "Finvisage - Facility";
		String actpage1 = driver.getTitle();
		if(exppage1.equalsIgnoreCase(actpage1))
		{
			System.out.print("");
		}else
		{
			System.out.println("Navigate back facility link crashed");
			takeScreenshot(driver, "Navigateback facility");
		}

		etf.clickOnEditFacility();
		etf.editFacilityName("Test Facility Modified");
		etf.clickUpdate();
		String expmsg = "Facility was successfully updated.";
		String actmsg=etf.updateMsg();
		if(expmsg.equalsIgnoreCase(actmsg))
		{
			System.out.println("Facility details modified");
		}else
		{
			System.out.println("Update button - crashed");
			takeScreenshot(driver, "Facility updatebutton");
		}
		Thread.sleep(7000);
		etf.clickOnEditFacility();
		etf.editFacilityName("Test Facility");
		etf.clickUpdate();
		System.out.println("Facility details set back");
		
		//Switching facility status
		System.out.println("=========SWITCHING FACILITY STATUS===========");
		mfi.clickInactiveButton();
		String expmsg1 = "Facility was successfully updated.";
		String actmsg1=mfi.updateMsg();
		if(expmsg1.equalsIgnoreCase(actmsg1))
		{
			System.out.println("Status changd to Inactive");
		}else
		{
			System.out.println("Updated notification message not received");
			takeScreenshot(driver, "Facility Inactivebutton");
		}
		mfi.clickInactiveButton();
		String expmsg2 = "Facility was successfully updated.";
		String actmsg2 =mfi.updateMsg();
		if(expmsg2.equalsIgnoreCase(actmsg2))
		{
			System.out.println("Status changed back to Active");
		}else
		{
			System.out.println("Updated notification message not received");
			takeScreenshot(driver, "Facility Inactivebutton");
		}
	}
}
