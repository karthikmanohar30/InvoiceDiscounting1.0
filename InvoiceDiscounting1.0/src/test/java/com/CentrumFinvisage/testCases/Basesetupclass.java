package com.CentrumFinvisage.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.CentrumFinvisage.utilities.ReadConfiguration;

public class Basesetupclass {

	ReadConfiguration readconfig = new ReadConfiguration();
	public String baseurl  = readconfig.getUrl();
	public String uname = readconfig.getuname();
	public String pword = readconfig.getpword();
	String projectpath = System.getProperty("user.dir");


	
	public WebDriver driver;

	@BeforeClass
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver",projectpath + "/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown()
	{		
		driver.quit();
	}
	
	public void takeScreenshot(WebDriver driver , String testname)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File des= new File(projectpath + "/Screenshots/" + testname + ".png");
			FileUtils.copyFile(src,des);
		} 
		catch (Exception e) 
		{
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		System.out.println(" Screenshot captured ");

	}
}
