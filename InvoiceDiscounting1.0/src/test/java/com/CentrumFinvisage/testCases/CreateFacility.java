package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.FacilityCreation;
import com.CentrumFinvisage.testCases.Basesetupclass;

public class CreateFacility extends Basesetupclass{

	@Test
	public void createFacility() throws Exception
	{
		System.out.println("===============FACILITY CREATION===============");
		driver.get(baseurl);
		FacilityCreation fc = new FacilityCreation(driver);
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
	}
}
