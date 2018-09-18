package Branch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
// 1) Verify that employees are displayed as per Alphabetical Order of Employee Names in All tab and individual department tabs.

public class ValidateAlphabeticalOrder extends Base {
		
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
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
			wait.until(ExpectedConditions.visibilityOf(home.getCookieAcceptButton()));
			home.getCookieAcceptButton().click();
			home.getTeamPage().click();
		}catch(WebDriverException e) {
			System.out.println("WebDriver Exception Occurred in ValidateAlphabeticalOrder.java! Can't click on 'Accept Cookies' button. Please run this test case again.");
			driver.close();
//			driver=null;
		}
		
	}
	@Test
	public void validateAllAlphabeticalOrder() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in All departments
		team.getAll().click();
		List<WebElement> all_names = driver.findElements(By.xpath("//div[contains(@class, 'category-all')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("All", all_names);
		Assert.assertEquals(comparison.get("All"), comparison.get("Sorted"));
	
	}
	
	@Test
	public void validateDataAlphabeticalOrder() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in Data department
		team.getData().click();
		List<WebElement> data_names = driver.findElements(By.xpath("//div[contains(@class, 'category-data')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("Data", data_names);
		Assert.assertEquals(comparison.get("Data"), comparison.get("Sorted"));

	}
	
	@Test
	public void validateEngineeringAlphabeticalOrder() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in Engineering department
		team.getEngineering().click();
		List<WebElement> engineering_names = driver.findElements(By.xpath("//div[contains(@class, 'category-engineering')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("Engineering", engineering_names);
		Assert.assertEquals(comparison.get("Engineering"), comparison.get("Sorted"));
		
	}
	
	@Test
	public void validateMarketingAlphabeticalOrder() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in Marketing department
		team.getMarketing().click();
		List<WebElement> marketing_names = driver.findElements(By.xpath("//div[contains(@class, 'category-marketing')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("Marketing", marketing_names);
		Assert.assertEquals(comparison.get("Marketing"), comparison.get("Sorted"));
		
	}
	
	@Test
	public void validateOperationsAlphabeticalOrder() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in Operations department
		team.getOperations().click();
		List<WebElement> operations_names = driver.findElements(By.xpath("//div[contains(@class, 'category-operations')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("Operations", operations_names);
		Assert.assertEquals(comparison.get("Operations"), comparison.get("Sorted"));
		
	}
	
	@Test
	public void validatePartnerGrowthAlphabeticalOrder() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in Partner Growth department
		team.getPartnerGrowth().click();
		List<WebElement> partnerGrowth_names = driver.findElements(By.xpath("//div[contains(@class, 'category-partner-growth')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("Partner Growth", partnerGrowth_names);
		Assert.assertEquals(comparison.get("Partner Growth"), comparison.get("Sorted"));
		
	}
	
	@Test
	public void validateProductAlphabeticalOrder() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in Product department
		team.getProduct().click();
		List<WebElement> product_names = driver.findElements(By.xpath("//div[contains(@class, 'category-product')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("Product", product_names);
		Assert.assertEquals(comparison.get("Product"), comparison.get("Sorted"));
		
	}
	
	@Test
	public void validateRecruitingAlphabeticalOrder() throws IOException {	
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the names of employees in Recruiting department
		team.getRecruiting().click();
		List<WebElement> recruiting_names = driver.findElements(By.xpath("//div[contains(@class, 'category-recruiting')]//div[@class='info-block']/h2"));
		
		// Get two arrayLists - 1) Given Names ArrayList 2) Sorted names ArrayList and compare if givenNames = sortedNames 
		Map<String, ArrayList<String>> comparison = validateOrder("Recruiting", recruiting_names);
		Assert.assertEquals(comparison.get("Recruiting"), comparison.get("Sorted"));
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
	public Map<String, ArrayList<String>> validateOrder(String departmentName, List<WebElement> given_department_names) {
		Map<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
		ArrayList<String> givenNames = new ArrayList<String>();
		ArrayList<String> sortedNames = new ArrayList<String>();
		for(int i =0; i<given_department_names.size(); i++) {
			givenNames.add(given_department_names.get(i).getText());
			sortedNames.add(given_department_names.get(i).getText());
		}
//		System.out.println("Given Names from "+ departmentName +" "+givenNames);
		answer.put(departmentName, givenNames);

		Collections.sort(sortedNames);
//		System.out.println("Sorted Names "+sortedNames);
		answer.put("Sorted", sortedNames);
		return answer;
	}

}
