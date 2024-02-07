package testCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CardiologiestPage;
import pageObjects.homePage;
import testBase.baseClass;
import utilities.ExcelUtils;

public class TC_001_SearchingCardiologiests extends baseClass{
	
	@Test(priority = 1)
	public void SearchingCardiologiests() throws InterruptedException
	{
	try 
		
	{
		logger.info("***** Starting TC_001_SearchingCardiologiests *****");
		
		homePage hp=new homePage(driver);
		
		logger.debug("Application logs started........");
		
		hp.ClickonLocation();
		logger.info("Clicked on Location input box");
		
		hp.ClearLocation();
		logger.info("Cleared existing Location Appearing");
		
		hp.EnterLocation();
		logger.info("Entered Location as Banglore");
		
		hp.ClickOnBloreLoc();
		logger.info("Clicked on Banglore Location Option");
		
		hp.ClickOnSearchDoc();
		logger.info("Clicked On Search Doctors, Clinic, Hosplitals,etc.");
		
		hp.EnterDocSpeciality();
		logger.info("Entered Doctor's Speciality as Cardiologiest");
		
		Thread.sleep(1000);
		
		hp.ClickOnCardiologiestOpt();
		logger.info("Clicked on Cardiologiest Option");
	}
	catch(Exception e) 
	{
		System.out.println("Searching Cardiologiests test failed"+ e.getMessage());
		Assert.fail();
	}
		
	}
	
	@Test(priority = 2)
	//@Test(dependsOnMethods = "SearchingCardiologiests")
	public void gettingCardiologiests() throws InterruptedException, IOException 
	{
	try 
	{
			
		CardiologiestPage cp=new CardiologiestPage(driver);
		
		cp.clickOnPatientStoriesFilter();
		logger.info("Clicked on Patient Stories Filter");
		
		cp.clickOn_30_Stories();
		logger.info("Clicked on 30+ Patient Stories Option");
		
		Thread.sleep(1000);
		
		cp.clickOnExperienceFilter();
		logger.info("Clicked on Experience Filter");
		
		cp.clickOnExperience5Years();
		logger.info("Clicked on 5Years+ Experience Option");
		
		Thread.sleep(1000);
		
		
		cp.clickOnAllFilter();
		logger.info("Clicked on All Filter");
		
		cp.clickOn500RsAbove();
		logger.info("Clicked on Above 500Rs Fees Option");
		
		Thread.sleep(1000);
		
		cp.clickOnAllFilter();
		logger.info("Clicked on All Filter");
		
		cp.clickOnAvailableTomorrow();
		logger.info("Clicked on Available Tomorrow Option");
		
		Thread.sleep(1000);
		
		cp.clickOnSortByFilter();
		logger.info("Clicked on Sort By Filter");
		
		cp.clickOnHighToLowExp();
		logger.info("Clicked on High To Low Experience Option");

		Thread.sleep(1000);
		
		ExcelUtils et = new ExcelUtils(System.getProperty("user.dir") + "\\testdata\\Surgeries.xlsx");
		List<WebElement> doctorName=driver.findElements(By.xpath("(//h2[@data-qa-id='doctor_name'])"));
		List<WebElement> doctordetails= driver.findElements(By.xpath("//div[@class='info-section']"));
		for(int i=0;i<5;i++) {
			
			System.out.println("The details of Doctor : "+i);
			System.out.println("===============================================");
			
			String d= doctordetails.get(i).getText();
			System.out.println(d);
			logger.info("Printed Doctor's Details in console");
			
			//Capturing Doctor's Name in Excel Sheet
			et.setCellData("Doctors_Name", i, 0, doctorName.get(i).getText());
			logger.info("Printed Doctor's Name in Excel");
			System.out.println("===============================================");
			
			WebElement doctor_details= doctordetails.get(i);
			File src = doctor_details.getScreenshotAs(OutputType.FILE);
			//File DestFile = new File(System.getProperty("user.dir")+"\\Screenshots\\doctors\"+i+\".png");
			File DestFile = new File("C:\\Users\\2303559\\eclipse-workspace\\finding_Hospitals\\Screenshots\\doctors"+i+".png");
			
			FileUtils.copyFile(src, DestFile);
			logger.info("ScreenShot Captured of Doctor's Details ");
	
			
		}
		logger.info("***** Ending TC_001_SearchingCardiologiests *****");
	}
	catch(Exception e) 
	{
		System.out.println("Getting Cardiologiests test failed"+ e.getMessage());
		Assert.fail();
	}
	
		
}

}






//homePage hp=new homePage(driver);
//
////SurgeriesPage sp =new SurgeriesPage(driver);
//
//HealthAndWellnessPage hwp =new HealthAndWellnessPage(driver);
//
////JavascriptExecutor js = (JavascriptExecutor)driver;
////
////js.executeScript("arguments[0].scrollIntoView();", sp.forCorporatesElement);
//
//hp.clickOnforCorporates();
//
//hp.clickOnHealthAndWellnessPlans();
//
//
//
////js.executeScript("arguments[0].scrollIntoView();", hwp.ScheduleDemoAreaElement);
//
//
//
//hwp.EnterNameElement.sendKeys(p.getProperty("Name"));
//
//hwp.OrganizationNameElement.sendKeys(p.getProperty("OrgName"));
//
//hwp.ContactNumberElement.sendKeys(p.getProperty("ContactNo"));
//
//hwp.officialEmailIdElement.sendKeys(p.getProperty("InvalidemailId"));
//
//hwp.organizantionSizeDropdown();
//
//hwp.interestedInDropdown();
//
//if(hwp.getScheduleDemoAreaElement().isEnabled())
//{
//	
//	hwp.ClickScheduleButton();
//	System.out.println("Schedule Demo Button is Enabled");
//	
//	Thread.sleep(10000);
//	
//	
//	TakeScreenshot ts = new TakeScreenshot(driver);
//	
//	ts.takeScreenshot(driver, "Firstscreenshot.png");
//	
//	String thankyou= hwp.captureThankYouTextElement.getText();
//	System.out.println(thankyou);
//	
//	String belowtext= hwp.captureBelowTextElement.getText();
//	System.out.println(belowtext);
//}
//else
//{
//	System.out.println("Schedule Demo Button is Disabled");
//}
//
//}
