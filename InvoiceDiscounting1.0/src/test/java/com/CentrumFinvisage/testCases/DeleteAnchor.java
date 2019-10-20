package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.DeletingTheAnchor;

public class DeleteAnchor extends Basesetupclass{
	
	@Test
	public void deleteAnchor()
	{
		System.out.println("================ANCHOR DELETION================");
		driver.get(baseurl);
		DeletingTheAnchor dta = new DeletingTheAnchor(driver);
		dta.setUsername(uname);
		dta.setPassword(pword);
		dta.clicklogin();	
		dta.clicksettings();
		dta.clickAnchor();
		dta.clickdeleteanchor();
			
		String expmsg = "Anchor was successfully deleted";
		String actmsg=dta.deleteSuccessMsg();
		if(expmsg.equalsIgnoreCase(actmsg))
		{
			System.out.println(dta.deleteSuccessMsg());
		}else
		{
			System.out.println("Anchor delete link - crashed");
			takeScreenshot(driver, "Anchor deletelink");
		}
	}
}
