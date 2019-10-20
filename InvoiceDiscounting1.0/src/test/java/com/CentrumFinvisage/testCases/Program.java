package com.CentrumFinvisage.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.EditingTheProgram;
import com.CentrumFinvisage.pageObject.ProgramCreation;

public class Program extends Basesetupclass {

	@Test
	public void editProgram() throws Exception
	{
		//Program Creation
		System.out.println("==============PROGRAM CREATING===========");
		driver.get(baseurl);
		EditingTheProgram etp = new EditingTheProgram(driver);
		ProgramCreation pc = new ProgramCreation(driver);
		etp.setUsername(uname);
		etp.setPassword(pword);
		etp.clicklogin();
		etp.clicksettings();		
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
						//pc.defaultProgramStatus();
						//assertTrue(true, "program Status selected as inactive");
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
		System.out.println("Anchor set back");
		
		//Setting back anchor to program
		etp.searchByName("Test");
		etp.clickSearch();
		etp.clickEditIcon();
		pc.clickOnAnchorDropdown();
		pc.selectAnchor();
		Thread.sleep(2000);
		etp.clickUpdateButton();
		Thread.sleep(7000);
		
		//Filters action
		System.out.println("==========PROGRAM FILTERS ACTION==========");
		
		etp.clickAnchorDropdown();
		etp.searchByAnchor();
		etp.clickSearch();
		Assert.assertEquals(true, etp.checkAnchorElement(), "Program doesn't exist by anchor search");
		System.out.println("Program exists by anchor search");
		etp.clearFilter();
		etp.searchByName("Test");
		etp.clickSearch();
		Thread.sleep(2000);
		Assert.assertEquals(true, etp.checkAnchorElement(),"Program doesn't exists by name search");
		System.out.println("Program exists by name search");
		etp.clearFilter();
		etp.searchByProgramID("TP2019");
		etp.clickSearch();
		Assert.assertEquals(true, etp.checkAnchorElement(), "Program doen't exist by ID search");
		System.out.println("program exists by ID search");
		etp.clearFilter();
		etp.searchByName("Test");
		etp.clickSearch();
		etp.clickInactiveIcon();
		Thread.sleep(7000);
		etp.clearFilter();
		etp.searchByName("Test");		
		etp.clickSearchByStatus();
		etp.selectStatusToSearch();
		etp.clickSearch();
		Assert.assertEquals(true, etp.programWithActive(), "Program doesn't exists by activestatus search");
		System.out.println("Program exists by active status search");
		etp.clearFilter();
		
		//Program Editing
		
		System.out.println("=============PROGRAM EDITING=============");
		etp.searchByName("Test Program");
		etp.clickSearch();
		etp.clickEditIcon();
		etp.clickCancelButton();
		String exppagae = "Finvisage - Programs";
		String actpage = driver.getTitle();
		if(exppagae.equalsIgnoreCase(actpage))
		{
			System.out.print("");
		}else
		{
			System.out.println("Facility cancelbutton - crashed");
			takeScreenshot(driver, "Facility cancelbutton");
		}
		etp.searchByName("Test Program");
		etp.clickSearch();		
		etp.clickEditIcon();
		etp.navigateBacktoPrograms();
		String exppagae1 = "Finvisage - Programs";
		String actpage1 = driver.getTitle();
		if(exppagae1.equalsIgnoreCase(actpage1))
		{
			System.out.print("");
		}else
		{
			System.out.println("Navigate back to program link-crashed");
			takeScreenshot(driver, "Facility navigateback link");
		}
		etp.searchByName("Test Program");
		etp.clickSearch();
		etp.clickEditIcon();
		etp.updateProgramName("Test Program Modified");
		etp.updateProgramID("TP2019Modified");
		etp.enterDescription("Program description modified");
		Thread.sleep(2000);
		etp.clickUpdateButton();
		String expmsg = "Program successfully updated";
		String actmsg = etp.updateMsg();
		if(expmsg.equalsIgnoreCase(actmsg))
		{
			System.out.println("Program name and ID modified");
		}else
		{
			System.out.println("Facility editing Updatebutton - crashed");
			takeScreenshot(driver, "Facility updatebutton");
		}
		etp.searchByName("Test Program");
		etp.clickSearch();
		etp.clickEditIcon();
		etp.updateProgramName("Test Program");
		etp.updateProgramID("TP2019");
		etp.enterDescription("Program Created for testing");
		Thread.sleep(2000);
		etp.clickUpdateButton();
		System.out.println("Program details set back");
		System.out.println(etp.updateMsg());
		
		//Switching program status
		
		System.out.println("===========SWITCHING PROGRAM STATUS=========");
		etp.searchByName("Test Program");
		etp.clickSearch();
		etp.clickInactiveIcon();
		String expmsg1 = "Program successfully updated";
		String actmsg1 = etp.updateMsg();
		if(expmsg1.equalsIgnoreCase(actmsg1))
		{
			System.out.println("Program status changed to Inactive");
		}else
		{
			System.out.println("Program Inactivebutton - crashed");
			takeScreenshot(driver, "Program Inactivebutton");
		}
		etp.clearFilter();
		etp.searchByName("Test");
		etp.clickSearchByStatus();
		etp.selectStatusToSearch1();
		etp.clickSearch();
		Assert.assertEquals(true, etp.programWithInactive(), "Program doesn't exists withInactive status");
		System.out.println("Program exists with inactive status");
		Thread.sleep(1000);
		etp.clearFilter();
		etp.searchByName("Test");
		etp.clickSearch();
		etp.clickInactiveIcon();
		String expmsg2 = "Program successfully updated";
		String actmsg2 = etp.updateMsg();
		if(expmsg2.equalsIgnoreCase(actmsg2))
		{
			System.out.println("Program status changed back to Active");
		}else
		{
			System.out.println("Program Activebutton - crashed");
			takeScreenshot(driver, "Program Activebutton");
		}
		
		//Export to excel action
		System.out.println("==============EXPORT TO EXCEL===============");
		etp.clickETE();
		String exppage = "Finvisage - Programs";
		String actpaget = driver.getTitle();
		if(exppage.equalsIgnoreCase(actpaget))
		{
			System.out.println("Programs export to excel");
		}else
		{
			System.out.println("Export to excel link crashed");
			takeScreenshot(driver, "program ETE link");
		}
				
		etp.clickAdminManagement();
		String exppage2 = "Finvisage - Admin - Home";
		String actpage2 = driver.getTitle();
		if(exppage2.equalsIgnoreCase(actpage2))
		{
			System.out.println("");
		}else
		{
			System.out.println("Adminmanagement link - crashed");
			takeScreenshot(driver, "Adminmanagement link");
		}
	}
}
