package Branch;

import java.io.IOException;
import java.util.ArrayList;
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

// Verify that employee names match between All tab and other tabs.

public class ValidateEmployeeNames extends Base {
		
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
			System.out.println("WebDriver Exception Occurred in ValidateEmployeeNames.java! Can't click on 'Accept Cookies' button. Please run this test case again.");
			driver.close();
			driver=null;
		}
		
	}
	
	@Test
	public void validateDataEmployeeNames() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the number of employees in All departments
		team.getAll().click();
		List<WebElement> all_data_names = driver.findElements(By.xpath("//div[contains(@class, 'category-data')]//div[@class='info-block']/h2"));
		
		// Get the number of employees in Data department
		team.getData().click();
		List<WebElement> data = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		
		Map<String, ArrayList<String>> comparison = validateEmployees("Data", all_data_names, data);
		Assert.assertEquals(comparison.get("Data"), comparison.get("all"));

	}
	
	@Test
	public void validateEngineeringEmployeeNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the number of employees in All departments
		team.getAll().click();
		List<WebElement> all_engineering_names = driver.findElements(By.xpath("//div[contains(@class, 'category-engineering')]//div[@class='info-block']/h2"));
				
		// Get the number of employees in Engineering departments
		team.getEngineering().click();
		List<WebElement> engineering = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		
		Map<String, ArrayList<String>> comparison = validateEmployees("Engineering", all_engineering_names, engineering);
		Assert.assertEquals(comparison.get("Engineering"), comparison.get("all"));
		
	}
	
	@Test
	public void validateMarketingEmployeeNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the number of employees in All departments
		team.getAll().click();
		List<WebElement> all_marketing_names = driver.findElements(By.xpath("//div[contains(@class, 'category-marketing')]//div[@class='info-block']/h2"));
		
		// Get the number of employees in Marketing departments
		team.getMarketing().click();
		List<WebElement> marketing = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		
		Map<String, ArrayList<String>> comparison = validateEmployees("Marketing", all_marketing_names, marketing);
		Assert.assertEquals(comparison.get("Marketing"), comparison.get("all"));
		
	}
	
	@Test
	public void validateOperationsEmployeeNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the number of employees in All departments
		team.getAll().click();
		List<WebElement> all_operations_names = driver.findElements(By.xpath("//div[contains(@class, 'category-operations')]//div[@class='info-block']/h2"));
		
		
		// Get the number of employees in Operations departments
		team.getOperations().click();
		List<WebElement> operations = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		
		Map<String, ArrayList<String>> comparison = validateEmployees("Operations", all_operations_names, operations);
		Assert.assertEquals(comparison.get("Operations"), comparison.get("all"));

		
	}
	
	@Test
	public void validatePartnerGrowthEmployeeNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the number of employees in All departments
		team.getAll().click();
		List<WebElement> all_partnerGrowth_names = driver.findElements(By.xpath("//div[contains(@class, 'category-partner-growth')]//div[@class='info-block']/h2"));
		
		// Get the number of employees in Partner Growth department
		team.getPartnerGrowth().click();
		List<WebElement> partnerGrowth = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		
		Map<String, ArrayList<String>> comparison = validateEmployees("Partner Growth", all_partnerGrowth_names, partnerGrowth);
		Assert.assertEquals(comparison.get("Partner Growth"), comparison.get("all"));

		
	}
	
	@Test
	public void validateProductEmployeeNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the number of employees in All departments
		team.getAll().click();
		List<WebElement> all_product_names = driver.findElements(By.xpath("//div[contains(@class, 'category-product')]//div[@class='info-block']/h2"));
		
		// Get the number of employees in Product departments
		team.getProduct().click();
		List<WebElement> product = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		
		Map<String, ArrayList<String>> comparison = validateEmployees("Product", all_product_names, product);
		Assert.assertEquals(comparison.get("Product"), comparison.get("all"));

		
	}
	
	@Test
	public void validateRecruitingEmployeeNames() throws IOException {	
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the number of employees in All departments
		team.getAll().click();
		List<WebElement> all_recruiting_names = driver.findElements(By.xpath("//div[contains(@class, 'category-recruiting')]//div[@class='info-block']/h2"));
		
		// Get the number of employees in Recruiting department
		team.getRecruiting().click();
		List<WebElement> recruiting = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		
		Map<String, ArrayList<String>> comparison = validateEmployees("Recruiting", all_recruiting_names, recruiting);
		Assert.assertEquals(comparison.get("Recruiting"), comparison.get("all"));

		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
	public Map<String, ArrayList<String>> validateEmployees(String departmentName, List<WebElement> all_department_names, List<WebElement> department) {
		Map<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
		ArrayList<String> allDepartment = new ArrayList<String>();
		for(int i =0; i<all_department_names.size(); i++) {
			allDepartment.add(all_department_names.get(i).getText());
		}
//		System.out.println("All  "+departmentName +" "+allDepartment);
		answer.put("all", allDepartment);
		
		ArrayList<String> departmentNames = new ArrayList<String>();
		for(int j=0; j<department.size(); j++) {
			departmentNames.add(department.get(j).getText());
		}
//		System.out.println(departmentName +" Names "+departmentNames);
		answer.put(departmentName, departmentNames);
		return answer;
	}

}
