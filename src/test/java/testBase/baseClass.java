package testBase;

import java.io.File;
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
//import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class baseClass {
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	
	@BeforeClass
	@Parameters({"os" , "browser"})
	public void setup(String os , String br) throws IOException
	{
		// Loading properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);	
		
		// Loading log4j file
		logger = LogManager.getLogger(this.getClass());

		
		// Launching browser based on choice
		if(br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("No matching browser");
			return;
		}
		
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		
		driver.get(p.getProperty("PageURL"));
		
		
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
//	public static String captureScreen(String name) {
//		// TODO Auto-generated method stub
//		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		
//		String targetPath = System.getProperty("user.dir")+"\\extentScreenshots\\+"+name+".png";
//		File trg = new File(targetPath);
//		
//		src.renameTo(trg);
//		return targetPath;
//	}
	
	
	
}