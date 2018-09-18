package Branch;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BranchHomePage;
import pageObjects.BranchTeamPage;
import pageObjects.GooglePage;
import pageObjects.GoogleSearchPage;
import resources.Base;

//Verify that number of employees match between All tab and sum of other tabs.

public class ValidateNumberOfEmployees extends Base {
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		GooglePage google = new GooglePage(driver);
		google.getSearchBox().sendKeys("branch website");
		google.getSearchBox().sendKeys(Keys.TAB);
		google.getSearchBox().sendKeys(Keys.ENTER);
		
		GoogleSearchPage search = new GoogleSearchPage(driver);
		search.getBranchWebsite().click();
		
		BranchHomePage home = new BranchHomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
		wait.until(ExpectedConditions.visibilityOf(home.getCookieAcceptButton()));
		try {
			home.getCookieAcceptButton().click();
			home.getTeamPage().click();
		}catch(WebDriverException e) {
			System.out.println("WebDriver Exception Occurred in ValidateNumberOfEmployees.java! Can't click on 'Accept Cookies' button. Please run this test case again.");
			driver.close();
			driver=null;
		}
	}
	
	@Test
	public void validateNoOfEmployees() throws IOException {
		// Get the number of employees in All departments
		List<WebElement> all = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int allSize = all.size();
		System.out.println("All "+allSize);
		
		// Get the number of employees in individual departments
		// Data
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getData().click();
		List<WebElement> data = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int dataSize = data.size();
		System.out.println("data "+dataSize);
		
		// Engineering
		team.getEngineering().click();
		List<WebElement> engineering = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int engineeringSize = engineering.size();
		System.out.println("engineering "+engineeringSize);
		
		// Marketing
		team.getMarketing().click();
		List<WebElement> marketing = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int marketingSize = marketing.size();
		System.out.println("marketing "+marketingSize);
		
		// Operations
		team.getOperations().click();
		List<WebElement> operations = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int operationsSize = operations.size();
		System.out.println("operations "+operationsSize);
		
		// Partner Growth
		team.getPartnerGrowth().click();
		List<WebElement> partnerGrowth = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int partnerGrowthSize = partnerGrowth.size();
		System.out.println("partnerGrowth "+partnerGrowthSize);

		// Product
		team.getProduct().click();
		List<WebElement> product = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int productSize = product.size();
		System.out.println("product "+productSize);

		// Recruiting
		team.getRecruiting().click();
		List<WebElement> recruiting = driver.findElements(By.xpath("//div[@style='display: inline-block;']"));
		int recruitingSize = recruiting.size();
		System.out.println("recruiting "+recruitingSize);
		
		// Sum of employees in individual departments tabs
		int sumOfEmployees = dataSize + engineeringSize + marketingSize + operationsSize + partnerGrowthSize + productSize + recruitingSize;
		System.out.println("Sum of all departments: "+sumOfEmployees);
		Assert.assertEquals(sumOfEmployees, allSize);
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

}
