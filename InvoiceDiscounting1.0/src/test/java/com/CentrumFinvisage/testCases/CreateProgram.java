package com.CentrumFinvisage.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.ProgramCreation;

public class CreateProgram extends Basesetupclass {

	@Test
	public void createProgram() throws Exception
	{
		System.out.println("===============PROGRAM CREATION================");
		driver.get(baseurl);
		ProgramCreation pc = new ProgramCreation(driver);
		pc.setUsername(uname);
		pc.setPassword(pword);
		pc.clicklogin();
		pc.clicksettings();

		String expadmintitle = "Finvisage - Admin - Home";
		String actadmintitle = driver.getTitle();
		if(expadmintitle.equalsIgnoreCase(actadmintitle))
		{
			pc.clickProgram();
			String expprogramtitle = "Finvisage - Programs";
			String actprogramtitle = driver.getTitle();
			if(expprogramtitle.equalsIgnoreCase(actprogramtitle))
			{
				pc.clickNewProgram();
				String expnewprogramtitle = "Finvisage - Business Unit - New";
				String actnewprogramtitle = driver.getTitle();
				if(expnewprogramtitle.equalsIgnoreCase(actnewprogramtitle))
				{
					pc.enterProgramName("Test Program");	
					pc.enterProgramId("TP2019");
					pc.clickOnAnchorDropdown();
					Thread.sleep(1000);
					String expectederrormsg = "already taken";
					String actmsg=pc.errorMessage();
					if(expectederrormsg.equalsIgnoreCase(actmsg))
					{
						System.out.println("Program ID must be unique");
						System.out.println("System doesn't create the program");
						Thread.sleep(1000);
						pc.cancelButton();
						String expprogramtitle1 = "Finvisage - Programs";
						String actprogramtitle1 = driver.getTitle();
						if(expprogramtitle1.equalsIgnoreCase(actprogramtitle1))
						{
							System.out.println(" ");
						}else
						{
							System.out.println("Program creation cancelbutton-crashed");
							takeScreenshot(driver, "program creation cancelbutton");
						}
					}
					else
					{
						pc.selectAnchor();
						pc.defaultProgramStatus();
						assertTrue(true, "program Status selected as inactive");
						pc.enterDescription("Program created for testing");
						pc.clickOnCreate();	
						String actsuccessmsg = "Program was created successfully";
						String expsuccessmsg = pc.successMessage();
						if(actsuccessmsg.equalsIgnoreCase(expsuccessmsg))
						{
							System.out.println(pc.successMessage() + " ");
						}else
						{
							System.out.println("Unable to create program-crashed");
							takeScreenshot(driver, "Program creation");
						}	
					}
				}
				else
				{
					System.out.println("New program-crashed");
					takeScreenshot(driver, "New prgram creation-crashed");
				}
			}
			else
			{
				System.out.println("Prgram creation-crashed");
				takeScreenshot(driver, "Program");
			}
		}
		else
		{
			System.out.println("Settings-Chrashed");
			takeScreenshot(driver, "Settings");
		}
	}
}

