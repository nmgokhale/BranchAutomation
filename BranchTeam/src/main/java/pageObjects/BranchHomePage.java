package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BranchHomePage {
	
	public WebDriver driver;
	public BranchHomePage(WebDriver driver) {
		this.driver = driver;
	}
//	By cookieAcceptButton = By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']");
//	By cookieAcceptButton = By.xpath("//*[text()='Accept']");
	By cookieAcceptButton = By.xpath("//div[@id='cookiebanner']//div[@class='cookie-wrapper']//div[@id='c-buttons']/a");
	By teamPage = By.xpath("//a[@href='https://branch.io/team/#all']");
	
	public WebElement getCookieAcceptButton() {
		return driver.findElement(cookieAcceptButton);
	}
	public WebElement getTeamPage() {
		return driver.findElement(teamPage);
	}

}
