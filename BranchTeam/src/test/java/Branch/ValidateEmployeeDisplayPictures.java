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

// Come up with 2 more valuable test cases.
// 2) Verify that display picture of every employee is present in All tab and individual department tabs.

public class ValidateEmployeeDisplayPictures extends Base {
	
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
			System.out.println("WebDriver Exception Occurred in ValidateEmployeeDisplayPictures.java! Can't click on 'Accept Cookies' button. Please run this test case again.");
			driver.close();
			driver=null;
		}
		
		
	}
	
	@Test
	public void validateAllEmployeesDisplayPictures() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in All departments
		team.getAll().click();
		List<WebElement> all_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-all')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<all_display_pictures.size(); i++) {
			Assert.assertTrue(all_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}
	
	}
	
	@Test
	public void validateDataEmployeesDisplayPictures() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in Data department
		team.getData().click();
		List<WebElement> data_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-data')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<data_display_pictures.size(); i++) {
			Assert.assertTrue(data_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}

	}
	
	@Test
	public void validateEngineeringEmployeesDisplayPictures() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in Engineering department
		team.getEngineering().click();
		List<WebElement> engineering_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-engineering')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<engineering_display_pictures.size(); i++) {
			Assert.assertTrue(engineering_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}
		
	}
	
	@Test
	public void validateMarketingEmployeesDisplayPictures() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in Marketing department
		team.getMarketing().click();
		List<WebElement> marketing_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-marketing')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<marketing_display_pictures.size(); i++) {
			Assert.assertTrue(marketing_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}
		
	}
	
	@Test
	public void validateOperationsEmployeesDisplayPictures() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in Operations department
		team.getOperations().click();
		List<WebElement> operations_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-operations')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<operations_display_pictures.size(); i++) {
			Assert.assertTrue(operations_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}
		
	}
	
	@Test
	public void validatePartnerGrowthEmployeesDisplayPictures() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in Partner Growth department
		team.getPartnerGrowth().click();
		List<WebElement> partnerGrowth_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-partner-growth')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<partnerGrowth_display_pictures.size(); i++) {
			Assert.assertTrue(partnerGrowth_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}
		
	}
	
	@Test
	public void validateProductEmployeesDisplayPictures() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in Product department
		team.getProduct().click();
		List<WebElement> product_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-product')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<product_display_pictures.size(); i++) {
			Assert.assertTrue(product_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}
		
	}
	
	@Test
	public void validateRecruitingEmployeesDisplayPictures() throws IOException {	
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the image block of employees in Recruiting department
		team.getRecruiting().click();
		List<WebElement> recruiting_display_pictures = driver.findElements(By.xpath("//div[contains(@class, 'category-recruiting')]//div[@class='image-block']"));
		// Check if style attribute contains .jpg image for each employee
		for(int i=0; i<recruiting_display_pictures.size(); i++) {
			Assert.assertTrue(recruiting_display_pictures.get(i).getAttribute("style").endsWith(".jpg\");"));
		}
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

}
