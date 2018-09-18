package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BranchTeamPage {
	
	public WebDriver driver;
	public BranchTeamPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By all = By.xpath("//a[@href='#all']");
	By data = By.xpath("//a[@href='#data']");
	By engineering = By.xpath("//a[@href='#engineering']");
	By marketing = By.xpath("//a[@href='#marketing']");
	By operations = By.xpath("//a[@href='#operations']");
	By partnerGrowth = By.xpath("//a[@href='#partner-growth']");
	By product = By.xpath("//a[@href='#product']");
	By recruiting = By.xpath("//a[@href='#recruiting']");
	
	public WebElement getAll() {
		return driver.findElement(all);
	}
	
	public WebElement getData() {
		return driver.findElement(data);
	}
	
	public WebElement getEngineering() {
		return driver.findElement(engineering);
	}
	
	public WebElement getMarketing() {
		return driver.findElement(marketing);
	}
	
	public WebElement getOperations() {
		return driver.findElement(operations);
	}
	
	public WebElement getPartnerGrowth() {
		return driver.findElement(partnerGrowth);
	}
	
	public WebElement getProduct() {
		return driver.findElement(product);
	}
	
	public WebElement getRecruiting() {
		return driver.findElement(recruiting);
	}
	
}
