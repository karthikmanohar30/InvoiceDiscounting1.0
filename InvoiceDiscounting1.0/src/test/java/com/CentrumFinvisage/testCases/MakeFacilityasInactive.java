package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.MakeFacilityInactive;

public class MakeFacilityasInactive extends Basesetupclass {

	@Test
	public void switchingInactiveButton()
	{
		System.out.println("============Switching Inactive Button===========");
		driver.get(baseurl);
		MakeFacilityInactive mfi = new MakeFacilityInactive(driver);
		mfi.setUsername(uname);
		mfi.setPassword(pword);
		mfi.clicklogin();
		mfi.clicksettings();
		mfi.clickFacility();
		mfi.clickInactiveButton();
		String expmsg = "Facility was successfully updated.";
		String actmsg=mfi.updateMsg();
		if(expmsg.equalsIgnoreCase(actmsg))
		{
			System.out.println("Status changd to Inactive");
		}else
		{
			System.out.println("Updated notification message not received");
			takeScreenshot(driver, "Facility Inactivebutton");
		}
		mfi.clickInactiveButton();
		String expmsg1 = "Facility was successfully updated.";
		String actmsg1 =mfi.updateMsg();
		if(expmsg1.equalsIgnoreCase(actmsg1))
		{
			System.out.println("Status changed back to Active");
		}else
		{
			System.out.println("Updated notification message not received");
			takeScreenshot(driver, "Facility Inactivebutton");
		}
	}
}
