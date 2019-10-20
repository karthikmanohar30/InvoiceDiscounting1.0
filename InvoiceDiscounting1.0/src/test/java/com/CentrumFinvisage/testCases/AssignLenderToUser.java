package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.AssigningLenderToUser;

public class AssignLenderToUser extends Basesetupclass{
	
	@Test
	public void assignLenderUser() throws Exception
	{
		System.out.println("===========ASSIGNING LENDER TO USER============");
		driver.get(baseurl);
		AssigningLenderToUser altu = new AssigningLenderToUser (driver);
		altu.setUsername(uname);
		altu.setPassword(pword);
		altu.clicklogin();
		
		altu.clicksettings();
		altu.clickUserManagement();
		altu.clickUserGroups();
		altu.clickGroupName();
		altu.clickManageUserGroup();
		Thread.sleep(2000);
		altu.clickLenderDropdown();
		Thread.sleep(2000);
		altu.selectLender();
		altu.clickSubmit();
		
		String actualupdatemsg ="UserGroup details were successfully updated";
		String expupdatemsg = altu.updateMsg();

		if(actualupdatemsg.equalsIgnoreCase(expupdatemsg))
		{
			System.out.println("Lender assigned to user");
			System.out.println(altu.updateMsg());
		}else
		{
			System.out.println("Unable to assign anchor-crashed");
			takeScreenshot(driver, "Lender Assign-crashed");
		}		
	}
}
