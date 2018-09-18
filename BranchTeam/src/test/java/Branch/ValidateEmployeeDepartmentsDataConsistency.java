package Branch;

import java.io.IOException;
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

// Verify that employee departments are listed correctly between All tab and Department tabs.
// A) Verify that employee department names are consistent between All tab and Department tabs
// Eg. If All Tab has department listed as Co-Founder/CEO, then Engineering tab should also show the department as Co-Founder/CEO for that employee

public class ValidateEmployeeDepartmentsDataConsistency extends Base {
		
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
			System.out.println("WebDriver Exception Occurred in ValidateEmployeeDepartmentsDataConsistency.java! Can't click on 'Accept Cookies' button. Please run this test case again.");
			driver.close();
			driver=null;
		}
		
	}
	
	@Test
	public void validateDataEmployeeDepartmentsConsistency() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Department from 'All' tab for employees in 'Data' Department
		team.getAll().click();
		List<WebElement> all_data_names = driver.findElements(By.xpath("//div[contains(@class, 'category-data')]//div[@class='info-block']/h2"));
		List<WebElement> all_data_departments = driver.findElements(By.xpath("//div[contains(@class, 'category-data')]//div[@class='info-block']/h4"));
		
		// Get the Employee Name and Department from 'Data' tab for employees in 'Data' Department
		team.getData().click();
		List<WebElement> data_names = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		List<WebElement> data_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		
		// Store the employeeName, employeeDepartment from all and Data tabs in 2 hashMaps and check if both the hashmaps are equal
		Map<String, HashMap<String, String>> comparison = validateEmployeeNamesAndDepartments("Data", all_data_names, all_data_departments, data_names, data_departments);
		Assert.assertEquals(comparison.get("Data"), comparison.get("all"));

	}
	
	@Test
	public void validateEngineeringEmployeeDepartmentsConsistency() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Department from 'All' tab for employees in 'Engineering' Department
		team.getAll().click();
		List<WebElement> all_engineering_names = driver.findElements(By.xpath("//div[contains(@class, 'category-engineering')]//div[@class='info-block']/h2"));
		List<WebElement> all_engineering_departments = driver.findElements(By.xpath("//div[contains(@class, 'category-engineering')]//div[@class='info-block']/h4"));
		
		// Get the Employee Name and Department from 'Engineering' tab for employees in 'Engineering' Department
		team.getEngineering().click();
		List<WebElement> engineering_names = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		List<WebElement> engineering_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		
		// Store the employeeName, employeeDepartment from all and Engineering tabs in 2 hashMaps and check if both the hashmaps are equal
		Map<String, HashMap<String, String>> comparison = validateEmployeeNamesAndDepartments("Engineering", all_engineering_names, all_engineering_departments, engineering_names, engineering_departments);
		Assert.assertEquals(comparison.get("Engineering"), comparison.get("all"));
		
	}
	
	@Test
	public void validateMarketingEmployeeDepartmentsConsistency() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Department from 'All' tab for employees in 'Marketing' Department
		team.getAll().click();
		List<WebElement> all_marketing_names = driver.findElements(By.xpath("//div[contains(@class, 'category-marketing')]//div[@class='info-block']/h2"));
		List<WebElement> all_marketing_departments = driver.findElements(By.xpath("//div[contains(@class, 'category-marketing')]//div[@class='info-block']/h4"));
		
		// Get the Employee Name and Department from 'Marketing' tab for employees in 'Marketing' Department
		team.getMarketing().click();
		List<WebElement> marketing_names = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		List<WebElement> marketing_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		
		// Store the employeeName, employeeDepartment from all and Marketing tabs in 2 hashMaps and check if both the hashmaps are equal
		Map<String, HashMap<String, String>> comparison = validateEmployeeNamesAndDepartments("Marketing", all_marketing_names, all_marketing_departments, marketing_names, marketing_departments);
		Assert.assertEquals(comparison.get("Marketing"), comparison.get("all"));
		
	}
	
	@Test
	public void validateOperationsEmployeeDepartmentsConsistency() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Department from 'All' tab for employees in 'Operations' Department
		team.getAll().click();
		List<WebElement> all_operations_names = driver.findElements(By.xpath("//div[contains(@class, 'category-operations')]//div[@class='info-block']/h2"));
		List<WebElement> all_operations_departments = driver.findElements(By.xpath("//div[contains(@class, 'category-operations')]//div[@class='info-block']/h4"));
		
		// Get the Employee Name and Department from 'Operations' tab for employees in 'Operations' Department
		team.getOperations().click();
		List<WebElement> operations_names = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		List<WebElement> operations_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		
		// Store the employeeName, employeeDepartment from all and Operations tabs in 2 hashMaps and check if both the hashmaps are equal
		Map<String, HashMap<String, String>> comparison = validateEmployeeNamesAndDepartments("Operations", all_operations_names, all_operations_departments, operations_names, operations_departments);
		Assert.assertEquals(comparison.get("Operations"), comparison.get("all"));
		
	}
	
	@Test
	public void validatePartnerGrowthEmployeeDepartmentsConsistency() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Department from 'All' tab for employees in 'Partner Growth' Department
		team.getAll().click();
		List<WebElement> all_partnerGrowth_names = driver.findElements(By.xpath("//div[contains(@class, 'category-partner-growth')]//div[@class='info-block']/h2"));
		List<WebElement> all_partnerGrowth_departments = driver.findElements(By.xpath("//div[contains(@class, 'category-partner-growth')]//div[@class='info-block']/h4"));
		
		// Get the Employee Name and Department from 'Partner Growth' tab for employees in 'Partner Growth' Department
		team.getPartnerGrowth().click();
		List<WebElement> partnerGrowth_names = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		List<WebElement> partnerGrowth_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		
		// Store the employeeName, employeeDepartment from all and Partner Growth tabs in 2 hashMaps and check if both the hashmaps are equal
		Map<String, HashMap<String, String>> comparison = validateEmployeeNamesAndDepartments("Partner Growth", all_partnerGrowth_names, all_partnerGrowth_departments, partnerGrowth_names, partnerGrowth_departments);
		Assert.assertEquals(comparison.get("Partner Growth"), comparison.get("all"));

		
	}
	
	@Test
	public void validateProductEmployeeDepartmentsConsistency() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Department from 'All' tab for employees in 'Product' Department
		team.getAll().click();
		List<WebElement> all_product_names = driver.findElements(By.xpath("//div[contains(@class, 'category-product')]//div[@class='info-block']/h2"));
		List<WebElement> all_product_departments = driver.findElements(By.xpath("//div[contains(@class, 'category-product')]//div[@class='info-block']/h4"));
		
		// Get the Employee Name and Department from 'Product' tab for employees in 'Product' Department
		team.getProduct().click();
		List<WebElement> product_names = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		List<WebElement> product_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		
		// Store the employeeName, employeeDepartment from all and Product tabs in 2 hashMaps and check if both the hashmaps are equal
		Map<String, HashMap<String, String>> comparison = validateEmployeeNamesAndDepartments("Product", all_product_names, all_product_departments, product_names, product_departments);
		Assert.assertEquals(comparison.get("Product"), comparison.get("all"));

		
	}
	
	@Test
	public void validateRecruitingEmployeeDepartmentsConsistency() throws IOException {	
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Department from 'All' tab for employees in 'Recruiting' Department
		team.getAll().click();
		List<WebElement> all_recruiting_names = driver.findElements(By.xpath("//div[contains(@class, 'category-recruiting')]//div[@class='info-block']/h2"));
		List<WebElement> all_recruiting_departments = driver.findElements(By.xpath("//div[contains(@class, 'category-recruiting')]//div[@class='info-block']/h4"));
		
		// Get the Employee Name and Department from 'Recruiting' tab for employees in 'Recruiting' Department
		team.getRecruiting().click();
		List<WebElement> recruiting_names = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h2"));
		List<WebElement> recruiting_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		
		// Store the employeeName, employeeDepartment from all and Recruiting tabs in 2 hashMaps and check if both the hashmaps are equal
		Map<String, HashMap<String, String>> comparison = validateEmployeeNamesAndDepartments("Recruiting", all_recruiting_names, all_recruiting_departments, recruiting_names, recruiting_departments);
		Assert.assertEquals(comparison.get("Recruiting"), comparison.get("all"));
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
	public Map<String, HashMap<String, String>> validateEmployeeNamesAndDepartments(String departmentName, List<WebElement> all_names, List<WebElement> all_departments, List<WebElement> department_names, List<WebElement> department_departments) {
		Map<String, HashMap<String, String>> answer = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> all = new HashMap<String, String>();
		for(int i =0; i<all_names.size(); i++) {
			all.put(all_names.get(i).getText(), all_departments.get(i).getText());
		}
//		System.out.println("All  "+departmentName +" "+all);
		answer.put("all", all);
		
		HashMap<String, String> department = new HashMap<String, String>();
		for(int j=0; j<department_names.size(); j++) {
			department.put(department_names.get(j).getText(), department_departments.get(j).getText());
		}
//		System.out.println(departmentName +" Names "+department);
		answer.put(departmentName, department);
		return answer;
	}

}
