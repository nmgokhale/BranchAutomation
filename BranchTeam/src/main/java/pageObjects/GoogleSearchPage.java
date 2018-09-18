package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	public WebDriver driver;
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	By branchWebsite = By.xpath("//a[@href='https://branch.io/']");

	
	public WebElement getBranchWebsite() {
		return driver.findElement(branchWebsite);
	}

}
