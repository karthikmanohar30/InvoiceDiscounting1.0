package com.CentrumFinvisage.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.Loginpage;

public class CheckMultiLogins extends Basesetupclass{


	@Test(dataProvider="LoginData")
	public void checkLogins(String user, String pwd)
	{
		driver.get(baseurl);		
		Loginpage lp = new Loginpage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clicklogin();
	}

	@DataProvider(name="LoginData")
	public String[][] getData() 
	{
		String[][] da = new String[3][2];
		da[0][0] = "admin";
		da[0][1] = "admin123";
		da[1][0] = "login";
		da[1][1] = "login123";
		da[2][0] = "signin";
		da[2][1] = "signin123";
		
		return da;
		
		
	}


}
