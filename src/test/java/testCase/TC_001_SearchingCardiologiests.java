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
	
	@Test(priority = 1, groups = { "sanity" })
	public void SearchingCardiologiests() throws InterruptedException
	{
	
	logger.info("***** Starting TC_001_SearchingCardiologiests *****");
	try 	
	{
		
		homePage hp=new homePage(driver);
		hp.LocationArea.click();
		logger.info("Clicked on Location input box");
		
		hp.LocationArea.clear();
		logger.info("Cleared existing Location Appearing");
		
		hp.LocationArea.sendKeys("Bangalor");
		logger.info("Entered Location as Bangalore");
		
		Thread.sleep(1000);
		
		hp.BangloreOption.click();
		logger.info("Clicked on Banglore Location Option");
		
		
		hp.ClickOnSearchDoc();
		logger.info("Clicked On Search Doctors, Clinic, Hosplitals,etc.");
		
		hp.SearchDoctorsArea.sendKeys(p.getProperty("Doctors_Spc"));;
		logger.info("Entered Doctor's Speciality as Cardiologiest");
		
		Thread.sleep(1000);
		
		hp.ClickOnCardiologiestOpt();
		logger.info("Clicked on Cardiologiest Option");
	}
	catch(Exception e) 
	{
		System.out.println("Searching Cardiologiests test failed"+ e.getMessage());
		logger.error("Searching Cardiologiests test failed..");
		Assert.fail("An exception occurred in Searching Cardiologiests test: " + e.getMessage());
	}
		
	}
	
	@Test(dependsOnMethods = "SearchingCardiologiests", groups = { "sanity" })
	
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
			logger.info("Printed Doctor: "+i+" Details in console");
			
			//Capturing Doctor's Name in Excel Sheet
			et.setCellData("Doctors_Name", i, 0, doctorName.get(i).getText());
			logger.info("Printed Doctor: "+i+" Name in Excel");
			System.out.println("===============================================");
			
			WebElement doctor_details= doctordetails.get(i);
			File src = doctor_details.getScreenshotAs(OutputType.FILE);
			
			File DestFile = new File("C:\\Users\\2303559\\eclipse-workspace\\finding_Hospitals\\Screenshots\\doctors"+i+".png");
			
			FileUtils.copyFile(src, DestFile);
			logger.info("ScreenShot Captured of Doctor: "+i+" Details ");
	
			
		}
		
	}
	catch(Exception e) 
	{
		
		System.out.println("Getting Cardiologiests test failed"+ e.getMessage());
		logger.error("Getting Cardiologiests test failed..");
		Assert.fail("An exception occurred in Getting Cardiologists Test: " + e.getMessage());
		
		
	}
	
	logger.info("***** Ending TC_001_SearchingCardiologiests *****");	
}

}
