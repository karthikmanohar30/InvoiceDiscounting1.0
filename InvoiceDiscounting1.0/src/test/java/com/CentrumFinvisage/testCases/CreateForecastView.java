package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.ForecastViewCreation;

public class CreateForecastView extends Basesetupclass{

	@Test
	public void createForecastView() throws Exception
	{
		System.out.println("============FORECAST VIEW CREATION=============");
		driver.get(baseurl);
		ForecastViewCreation fvc = new ForecastViewCreation(driver);
		fvc.setUsername(uname);
		fvc.setPassword(pword);
		fvc.clicklogin();
		fvc.clickForecastViews();
		String expforecastviewstitle = "Finvisage - Forecast Views";
		String actforecastviewstitle = driver.getTitle();
		if(expforecastviewstitle.equalsIgnoreCase(actforecastviewstitle))
		{
			fvc.clickAddNew();
			String expforecastviewstitle1 = "Finvisage - Forecast Views";
			String actforecastviewstitle1 = driver.getTitle();
			if(expforecastviewstitle1.equalsIgnoreCase(actforecastviewstitle1))
			{
				Thread.sleep(2000);
				fvc.clickAnchorDropdown();
				fvc.selectAnchor();
				fvc.setForecastViewName("Test_ForecastView");
				fvc.setForecastViewStartdate("01/01/2018");
				Thread.sleep(3000);
				fvc.setForecastViewEnddate("31/12/2021");
				Thread.sleep(3000);
				fvc.clickCreate();
				String actsavedmsg = "View saved successfully";
				String expsavedmsg = fvc.viewSavedMsg();
				if(actsavedmsg.equalsIgnoreCase(expsavedmsg))
				{
					System.out.println("Forecast view has been created");
					System.out.println(fvc.viewSavedMsg());
				}else
				{
					System.out.println("Unable to create forecast view-crashed");
					takeScreenshot(driver, "forecast view creation");
				}	
			}else
			{
				System.out.println("Add new link -crashed");
				takeScreenshot(driver, "Add new link");
			}			
		}else
		{
			System.out.println("Forecast views link -crashed");
			takeScreenshot(driver, "Forecast views");
		}
	}
}
