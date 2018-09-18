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
// Come up with test that will fail and add explanation of failure as part of report
// Verify that description is added for each employee in All tab

public class ValidateEmployeeDescription extends Base {
		
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
			System.out.println("WebDriver Exception Occurred in ValidateEmployeeDescription.java! Can't click on 'Accept Cookies' button. Please run this test case again.");
			driver.close();
			driver=null;
		}
		
		
	}
	
	@Test
	public void validateEmployeeDescriptionIsNotNull() throws IOException {		
		
		BranchTeamPage team = new BranchTeamPage(driver);
		// Get the Employee Name and Description of Employees in 'All' tab
		team.getAll().click();
		List<WebElement> all_employee_names = driver.findElements(By.xpath("//div[contains(@class, 'category-all')]//div[@class='info-block']/h2"));
		List<WebElement> all_employee_description = driver.findElements(By.xpath("//div[contains(@class, 'category-all')]//div[@class='overlay']/p"));
		int count = 0;
		// Print the employee names whose description is not added. Also print the total number of such employees
		for(int i=0; i<all_employee_description.size(); i++) {
			if(all_employee_description.get(i).getAttribute("innerText").length() == 0) {
				count++;
				System.out.println(all_employee_names.get(i).getText());
			}
		}
		System.out.println("Total Number of employees without description: "+count);
		
		// Check if employee description is missing for employees in 'All' tab
		for(int j=0; j<all_employee_description.size(); j++) {
				Assert.assertTrue((all_employee_description.get(j).getAttribute("innerText").length() == 0), "Description is missing for some employees. Their Names are printed in the console.");				
		}

	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
}
