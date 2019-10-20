package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.Loginpage;

public class Logintest extends Basesetupclass{

	@Test
	public void loginTest() throws Exception
	{  
		System.out.println(" 'Verifying application login' ");
		driver.get(baseurl);
		String exploginpagetitle = "FINVISAGE";
		String actloginpagetitle = driver.getTitle();
		if(exploginpagetitle.equalsIgnoreCase(actloginpagetitle))
		{
			System.out.println("Login page verified");
			Loginpage lp = new Loginpage(driver);
			lp.setUsername(uname);
			lp.setPassword(pword);
			lp.clicklogin();
			
			String exppage = "Finvisage - Consolidated View";
			String actpage =driver.getTitle();
			if(exppage.equalsIgnoreCase(actpage))
			{
				System.out.println("Home page verified");
				lp.logoutApplication();
				String exppage1 = "FINVISAGE";
				String actpage1 = driver.getTitle();
				if(exppage1.equalsIgnoreCase(actpage1))
				{
					System.out.println(" 'Application logged out successfully' ");
				}else
				{
					System.out.println("Logout button crashed");
					takeScreenshot(driver, "Logout button");
				}
			}else
			{
				System.out.println("Home page crashed");
				takeScreenshot(driver, "Home page");
			}
		}else
		{
			System.out.println("Invalid login page");
			takeScreenshot(driver, "Invalid login page");
		}	
	}
}
