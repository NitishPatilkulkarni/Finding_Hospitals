package testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HealthAndWellnessPage;
import pageObjects.homePage;
import testBase.baseClass;
import utilities.TakeScreenshot;

public class TC_004_CorporateHealthAndWellness_ValidDetails extends baseClass{
	
	@Test(priority = 1)
	public void checkingValidDetails() throws InterruptedException
	{
	try 
	{
		logger.info("***** Starting TC_004_CorporateHealthAndWellness_ValidDetails *****");
		
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
		logger.info("Contact Number Entered");
		
		hwp.officialEmailIdElement.sendKeys(p.getProperty("validemailId"));
		logger.info("Valid Email-Id Entered");
		
		hwp.organizantionSizeDropdown();
		logger.info("Selected Organizantion's Size from Dropdown");
		
		hwp.interestedInDropdown();
		logger.info("Selected Interested-In from Dropdown");
		
		if(!hwp.getScheduleButton().isEnabled())
		{
			System.out.println("Schedule button is Disabled");
			logger.info("Schedule button is Disabled");
			Assert.fail();
			logger.error("Error");
		}

		else 
		{

			Assert.assertTrue(true);
			
			hwp.getScheduleButton().click();
			logger.info("Clicked On Schedule button ");
		
			Thread.sleep(15000);
			
			
			TakeScreenshot ts = new TakeScreenshot(driver);
			
			ts.takeScreenshot(driver, "Thankyou.png");
			logger.info("Captured ScreenShot of Thank You Pop-Up");
			
			
			String expectedString = "THANK YOU";
			String thankyou= hwp.captureThankYouText.getText();
			if(thankyou.equals(expectedString))
			{
				Assert.assertTrue(true);
				System.out.println(thankyou);
				logger.info("Printed Thankyou Text in console ");
			
				String thankYouParagraph= hwp.capturethankYouParagraph.getText();
				System.out.println(thankYouParagraph);
				logger.info("Printed Thankyou Paragraph in console ");
			
			}
			else
			{
				Assert.fail();
				logger.error("Error");
			}
			
		
		}
		
		logger.debug("Application logs end........");
	
		logger.info("***** Ending TC_004_CorporateHealthAndWellness_ValidDetails *****");
	}
	catch(Exception e) 
	{
		System.out.println("Checking Valid Details test failed"+ e.getMessage());
		Assert.fail();
	}
	
	}

}
