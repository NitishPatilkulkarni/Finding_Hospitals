package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage{
	
	WebDriver driver;
	
	//Constructor
	public homePage(WebDriver driver)
	{
		super(driver);
	}

	//Elements

//	@FindBy(xpath="(//input[@data-qa-id='omni-searchbox-locality'])")
//	public WebElement LocationArea;
	
	@FindBy(xpath="//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--locality']//div[@class='c-omni-searchbox_wrapper ']/input")
	public WebElement LocationArea;
	
	
	@FindBy(xpath="//body/div[@id='root']/div/div/div[@class='content']/div[@class='c-omni-wrapper u-d__inline-block']/div[@id='c-omni-container']/div[@class='c-omni u-clearfix']/div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--locality']/div[@class='c-omni-suggestion-list']/div[@class='c-omni-suggestion-group']/div[1]/span[1]")
	public WebElement BangloreOption;
	
//	@FindBy(xpath="(//div[@data-qa-id='omni-suggestion-city'])[1]")
//	public WebElement BangloreOption;
	
	@FindBy(xpath="(//input[@data-qa-id='omni-searchbox-keyword'])")
	public WebElement SearchDoctorsArea;
	
	@FindBy(xpath="(//div[@data-qa-id='omni-suggestion-listing'])[1]")
	public WebElement CardiologiestOption;
	
	@FindBy(xpath = "(//a[@class='nav-interact'])[21]")
	WebElement surgeriesButton;
	
	@FindBy(xpath = "//span[@event='Nav Provider Marketing:Interacted:Plus Corporate']")
	public WebElement forCorporatesElement;
	
	@FindBy(xpath = "//a[@event='Nav Provider Marketing:Interacted:Plus Corporate'][1]")
	WebElement HealthAndWellnessPlansElement;
	
	//Actions Methods
	
	public void ClickonLocation()
	{
		LocationArea.click();
		
	}
	
	public void ClearLocation()
	{
		LocationArea.clear();
		
	}
	
	
	
	public void ClickOnBloreLoc()
	{
		BangloreOption.click();
		
	}
	
	public void ClickOnSearchDoc()
	{
		SearchDoctorsArea.click();
		
	}
	
	public void clickOnSurgeries()
	{
		surgeriesButton.click();
	}
	
	
	

	public void ClickOnCardiologiestOpt()
	{
		CardiologiestOption.click();
		
	}
	
	public void clickOnforCorporates()
	{
		forCorporatesElement.click();
	}
	
	public void clickOnHealthAndWellnessPlans()
	{
		HealthAndWellnessPlansElement.click();
	}
	
	
}
