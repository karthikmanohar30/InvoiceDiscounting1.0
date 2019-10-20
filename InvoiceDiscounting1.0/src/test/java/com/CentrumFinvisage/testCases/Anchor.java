package com.CentrumFinvisage.testCases;
import org.testng.annotations.Test;
import com.CentrumFinvisage.pageObject.AnchorCreation;
import com.CentrumFinvisage.pageObject.DeletingTheAnchor;
import com.CentrumFinvisage.pageObject.EditingTheAnchor;

public class Anchor extends Basesetupclass{

	@Test
	public void createAnchor() throws Exception
	{
		System.out.println("================ANCHOR CREATION================");
		driver.get(baseurl);
		AnchorCreation amdb = new AnchorCreation(driver);	
		EditingTheAnchor eta = new EditingTheAnchor(driver);
		DeletingTheAnchor dta = new DeletingTheAnchor(driver);
		amdb.setUsername(uname);
		amdb.setPassword(pword);
		amdb.clicklogin();
		amdb.clicksettings();
		String expadmintitle = "Finvisage - Admin - Home";
		String actadmintitle = driver.getTitle();
		if(expadmintitle.equalsIgnoreCase(actadmintitle))
		{
			amdb.clickAnchor();
			String exppagetitle = "Finvisage - Anchors";
			String actpagetitle = driver.getTitle();
			if(exppagetitle.equalsIgnoreCase(actpagetitle))
			{
				amdb.clicknewAnchor();
				String expanchornewtitle = 	"Finvisage - Anchor - New";
				String actanchornewtitle = driver.getTitle();
				if(expanchornewtitle.equalsIgnoreCase(actanchornewtitle))
				{
					amdb.enterAnchorName("Test Anchor");
					amdb.enterAnchorShortcode("TA");
					String expectederrormsg = "Name already taken";
					String actmsg=amdb.errorMessage();
					if(expectederrormsg.equalsIgnoreCase(actmsg))
					{
						System.out.println("Anchor name already been taken");
						System.out.println("System doesn't create an anchor");
						Thread.sleep(1000);
						amdb.clickCancelButton();
						String exppagetitle1 = "Finvisage - Anchors";
						String actpagetitle1 = driver.getTitle();
						if(exppagetitle1.equalsIgnoreCase(actpagetitle1))
						{
							System.out.println("");

						}else
						{
							System.out.println("New anchor creation cancel button-crashed");
							takeScreenshot(driver, "New anchor cancelbutton");
						}
					}
					else
					{	
						Thread.sleep(1000);
						amdb.levelDropdown();
						Thread.sleep(1000);
						amdb.selectLevel();
						Thread.sleep(1000);
						amdb.parentDropdown();
						Thread.sleep(1000);
						amdb.selectParent();
						Thread.sleep(1000);
						amdb.enterDescription("Anchor created for testing");
						amdb.clickOnCreate();						
						String actsuccessmsg = "Anchor was successfully created";
						String expsuccessmsg = amdb.successfulMsg();
						if(actsuccessmsg.equalsIgnoreCase(expsuccessmsg))
						{
							System.out.println(amdb.successfulMsg() + " ");
						}
						else
						{
							System.out.println("Unable to create an anchor-crashed");
							takeScreenshot(driver, "Anchor creation");
						}
					}
				}
				else
				{
					System.out.println("New anchor creation - crashed");
					takeScreenshot(driver, "New anchor creation");
				}	
			}
			else
			{
				System.out.println("Anchorpage-crashed");
				takeScreenshot(driver, "Anchorcreation");
			}	
		}
		else
		{
			System.out.println("Settings-Chrashed");
			takeScreenshot(driver, "Settings");
		}	

		//Editing the anchor
		System.out.println("==============EDITING THE ANCHOR=============");
		eta.clickEditAnchor();
		String expeditpage = "Finvisage - Anchor - Edit";
		String acteditpage = driver.getTitle();
		if(expeditpage.equalsIgnoreCase(acteditpage))
		{
			eta.editAnchorName("Test Anchor Modified");
			eta.editAnchorShortcode("TAM");
			eta.editanchordescription("Anchor name has been modified");
			Thread.sleep(2000);
			eta.clickUpdateButton();
			String updatedsuccessfulmessage = "Anchor was successfully updated";
			String actualmsg = eta.editUpdateSuccessMsg();
			if(updatedsuccessfulmessage.equalsIgnoreCase(actualmsg))
			{
				System.out.println("Anchor details modified");
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
		eta.clickEditAnchor();
		eta.editAnchorName("Test Anchor");
		eta.editAnchorShortcode("TA");
		Thread.sleep(2000);
		eta.clickUpdateButton();
		System.out.println("Anchor details set back");

		//Deleting the anchor
		System.out.println("==========DELETING THE ANCHOR==============");
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

		//Bring back the anchor
		System.out.println("========BRINGING BACK THE ANCHOR==============");
		Thread.sleep(7000);
		amdb.clicknewAnchor();
		amdb.enterAnchorName("Test Anchor");
		amdb.enterAnchorShortcode("TA");
		Thread.sleep(1000);
		amdb.levelDropdown();
		Thread.sleep(1000);
		amdb.selectLevel();
		Thread.sleep(1000);
		amdb.parentDropdown();
		Thread.sleep(1000);
		amdb.selectParent();
		amdb.enterDescription("Anchor created for testing");
		Thread.sleep(1000);
		amdb.clickOnCreate();
		System.out.println("Anchor brought back");		

		amdb.adminManagement();
		String exppage = "Finvisage - Admin - Home";
		String actpage = driver.getTitle();
		if(exppage.equalsIgnoreCase(actpage))
		{
			System.out.println(actpage);
		}else
		{
			System.out.println("Admin management link crashed");
			takeScreenshot(driver, "Anchor-adminmanagement link");
		}

	}
}
