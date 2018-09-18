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

// Verify that employee departments are listed correctly between All tab and Department tabs.
// B) Verify that employee department name written in description is same as actual department name in All tab and Department tabs
// Eg. All employees belonging to Engineering department should have Department Name as 'Engineering' and so on 

public class ValidateEmployeeDepartmentNames extends Base {
		
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
		home.getCookieAcceptButton().click();
		home.getTeamPage().click();
		
	}
	
	@Test
	public void validateDataDepartmentNames() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getData().click();
//		Get the department name of Data department and capitalize first letter only
		String name = team.getData().getText();
		String departmentName = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
		
//		Get the department names of all employees in Data Tab
		List<WebElement> data_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		for(int i=0; i<data_departments.size(); i++) {
//			Check if department names match with 'Data'
			Assert.assertEquals(data_departments.get(i).getText(), departmentName);
		}
			
	}
	
	@Test
	public void validateEngineeringDepartmentNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getEngineering().click();
//		Get the department name of Engineering department and capitalize first letter only
		String name = team.getEngineering().getText();
		String departmentName = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
		
//		Get the department names of all employees in Engineering Tab
		List<WebElement> engineering_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		for(int i=0; i<engineering_departments.size(); i++) {
//			Check if department names match with 'Engineering'
			Assert.assertEquals(engineering_departments.get(i).getText(), departmentName);
		}
		
	}
	
	@Test
	public void validateMarketingDepartmentNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getMarketing().click();
//		Get the department name of Marketing department and capitalize first letter only
		String name = team.getMarketing().getText();
		String departmentName = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
		
//		Get the department names of all employees in Marketing Tab
		List<WebElement> marketing_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		for(int i=0; i<marketing_departments.size(); i++) {
//			Check if department names match with 'Marketing'
			Assert.assertEquals(marketing_departments.get(i).getText(), departmentName);
		}
		
	}
	
	@Test
	public void validateOperationsDepartmentNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getOperations().click();
//		Get the department name of Operations department and capitalize first letter only
		String name = team.getOperations().getText();
		String departmentName = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
		
//		Get the department names of all employees in Operations Tab
		List<WebElement> operations_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		for(int i=0; i<operations_departments.size(); i++) {
//			Check if department names match with 'Operations'
			Assert.assertEquals(operations_departments.get(i).getText(), departmentName);
		}
		
	}
	
	@Test
	public void validatePartnerGrowthDepartmentNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getPartnerGrowth().click();
//		Get the department name of Partner Growth department and capitalize first letter only
		String name = team.getPartnerGrowth().getText();
		String departmentName = name.substring(0, 1).toUpperCase()+name.substring(1,8).toLowerCase()+name.substring(8,9).toUpperCase()+name.substring(9).toLowerCase();
		
//		Get the department names of all employees in Partner Growth Tab
		List<WebElement> partnerGrowth_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		for(int i=0; i<partnerGrowth_departments.size(); i++) {
//			Check if department names match with 'Partner Growth'
			Assert.assertEquals(partnerGrowth_departments.get(i).getText(), departmentName);
		}

		
	}
	
	@Test
	public void validateProductDepartmentNames() throws IOException {
		
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getProduct().click();
//		Get the department name of Product department and capitalize first letter only
		String name = team.getProduct().getText();
		String departmentName = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
		
//		Get the department names of all employees in Product Tab
		List<WebElement> product_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		for(int i=0; i<product_departments.size(); i++) {
//			Check if department names match with 'Product'
			Assert.assertEquals(product_departments.get(i).getText(), departmentName);
		}
		
	}
	
	@Test
	public void validateRecruitingDepartmentNames() throws IOException {	
		
		BranchTeamPage team = new BranchTeamPage(driver);
		team.getRecruiting().click();
//		Get the department name of Recruiting department and capitalize first letter only
		String name = team.getRecruiting().getText();
		String departmentName = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
		
//		Get the department names of all employees in Recruiting Tab
		List<WebElement> recruiting_departments = driver.findElements(By.xpath("//div[@style='display: inline-block;']//div[@class='info-block']/h4"));
		for(int i=0; i<recruiting_departments.size(); i++) {
//			Check if department names match with 'Recruiting'
			Assert.assertEquals(recruiting_departments.get(i).getText(), departmentName);
		}
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

}
