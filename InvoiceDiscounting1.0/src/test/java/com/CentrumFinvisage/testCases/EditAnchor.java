package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.EditingTheAnchor;

public class EditAnchor extends Basesetupclass{

	@Test
	public void editAnchor() throws Exception
	{
		System.out.println("==============EDITING THE ANCHOR===============");
		driver.get(baseurl);
		EditingTheAnchor eta = new EditingTheAnchor(driver);
		eta.setUsername(uname);
		eta.setPassword(pword);
		eta.clicklogin();
		eta.clicksettings();
		eta.clickAnchor();
		eta.clickEditAnchor();
		Thread.sleep(1000);
		String expeditpage = "Finvisage - Anchor - Edit";
		String acteditpage = driver.getTitle();
		if(expeditpage.equalsIgnoreCase(acteditpage))
		{
			eta.editAnchorName("Test Anchor Modified");
			Thread.sleep(1000);
			eta.editAnchorShortcode("TAM");
			Thread.sleep(1000);
			eta.editanchordescription("Anchor name has been modified");
			Thread.sleep(1000);
			eta.clickUpdateButton();
			String updatedsuccessfulmessage = "Anchor was successfully updated";
			String actualmsg = eta.editUpdateSuccessMsg();
			if(updatedsuccessfulmessage.equalsIgnoreCase(actualmsg))
			{
				System.out.println(actualmsg);
			}else
			{
				System.out.println("Edit anchor operation unsuccessful");
				takeScreenshot(driver, "Anchor updatebutton");
			}
		}else
		{
			System.out.println("Anchor edit link -crashed");
			takeScreenshot(driver, "Anchor edit link");
		}	
	}
}
