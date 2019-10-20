package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.AssigningAnchorToUser;

public class AssignAnchorToUser extends Basesetupclass{

	@Test
	public void assignAnchorToUser() throws Exception
	{
		System.out.println("===========ASSIGNING ANCHOR TO USER============");
		driver.get(baseurl);
		AssigningAnchorToUser aatu = new AssigningAnchorToUser(driver);
		aatu.setUsername(uname);
		aatu.setPassword(pword);
		aatu.clicklogin();

		aatu.clicksettings();
		aatu.clickUserManagement();
		aatu.clickUserGroups();
		aatu.clickGroupName();
		aatu.clickManageUserGroup();
		Thread.sleep(2000);
		aatu.clickAssignAnchorDropdown();
		Thread.sleep(2000);
		aatu.selectAnchor();
		aatu.clickSubmit();

		String actualupdatemsg ="UserGroup details were successfully updated";
		String expupdatemsg = aatu.updateMsg();

		if(actualupdatemsg.equalsIgnoreCase(expupdatemsg))
		{
			System.out.println("Anchor assigned to user");
			System.out.println(aatu.updateMsg());
		}else
		{
			System.out.println("Unable to assign anchor-crashed");
			takeScreenshot(driver, "Anchor Assign-crashed");
		}
	}
}
