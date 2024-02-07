package testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.HealthAndWellnessPage;
import pageObjects.homePage;
import testBase.baseClass;

public class TC_003_CorporateHealthAndWellness_InvalidDetails extends baseClass{
	
	@Test(priority = 1)
	public void checkingInvalidDetails()
	{
	try 
	{
		logger.info("***** Starting TC_003_CorporateHealthAndWellness_InvalidDetails *****");
		homePage hp=new homePage(driver);
	
		hp.clickOnforCorporates();
		logger.info("Clicked On Corporates");
		
		hp.clickOnHealthAndWellnessPlans();
		logger.info("Clicked On Health And Wellness Plans Option");
		
		HealthAndWellnessPage hwp =new HealthAndWellnessPage(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		logger.info("Scrolled down");
		
		hwp.EnterNameElement.sendKeys(p.getProperty("Name"));
		logger.info("Name Entered");
		
		hwp.OrganizationNameElement.sendKeys(p.getProperty("OrgName"));
		logger.info("Organization Name Entered");
		
		hwp.ContactNumberElement.sendKeys(p.getProperty("ContactNo"));
		logger.info("The Contact Number Entered");
		
		hwp.officialEmailIdElement.sendKeys(p.getProperty("InvalidemailId"));
		logger.info("Invalid Email-Id Entered");
		
		hwp.organizantionSizeDropdown();
		logger.info("Selected Organizantion's Size from Dropdown");
		
		hwp.interestedInDropdown();
		logger.info("Selected Interested-In from Dropdown");
		
		if (!hwp.getScheduleButton().isEnabled()) 
		{
			//takeSnapshot(driver, "Invalid Details Form");
			System.out.println("Schedule button is disabled");
			logger.info("Schedule button is disabled");
			
		}
		else 
		{
			System.out.println("Schedule button is Enabled");
			logger.error("Schedule button is Enabled");
			
			Assert.fail();
			logger.error("Error");
//			hwp.getScheduleButton();
		}
		logger.info("***** Ending TC_003_CorporateHealthAndWellness_InvalidDetails *****");
	}
	catch(Exception e) 
	{
		System.out.println("Checking Invalid Details test failed"+ e.getMessage());
		Assert.fail();
	}
	}

}




//@Test(priority = 3)
//public void EnteringDetailsNegative() throws IOException, InterruptedException 
//{
//
//	homePage hp=new homePage(driver);
//	
//	//SurgeriesPage sp =new SurgeriesPage(driver);
//	
//	HealthAndWellnessPage hwp =new HealthAndWellnessPage(driver);
//	
////	JavascriptExecutor js = (JavascriptExecutor)driver;
////	
////	js.executeScript("arguments[0].scrollIntoView();", sp.forCorporatesElement);
//	
//	hp.clickOnforCorporates();
//	
//	hp.clickOnHealthAndWellnessPlans();
//	
//	
//	
//	//js.executeScript("arguments[0].scrollIntoView();", hwp.ScheduleDemoAreaElement);
//	
//	
//	
//	hwp.EnterNameElement.sendKeys(p.getProperty("Name"));
//	
//	hwp.OrganizationNameElement.sendKeys(p.getProperty("OrgName"));
//	
//	hwp.ContactNumberElement.sendKeys(p.getProperty("ContactNo"));
//	
//	hwp.officialEmailIdElement.sendKeys(p.getProperty("InvalidemailId"));
//	
//	hwp.organizantionSizeDropdown();
//	
//	hwp.interestedInDropdown();
//	
//	if(hwp.getScheduleDemoAreaElement().isEnabled())
//	{
//		
//		hwp.ClickScheduleButton();
//		System.out.println("Schedule Demo Button is Enabled");
//		
//		Thread.sleep(10000);
//		
//		
//		TakeScreenshot ts = new TakeScreenshot(driver);
//		
//		ts.takeScreenshot(driver, "Firstscreenshot.png");
//		
//		String thankyou= hwp.captureThankYouTextElement.getText();
//		System.out.println(thankyou);
//		
//		String belowtext= hwp.captureBelowTextElement.getText();
//		System.out.println(belowtext);
//	}
//	else
//	{
//		System.out.println("Schedule Demo Button is Disabled");
//	}
//	
//}