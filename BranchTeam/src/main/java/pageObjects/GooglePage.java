package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	
	public WebDriver driver;
	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}
	By searchBox = By.xpath("//input[@title='Search']");
	By search = By.cssSelector("input[name=btnK]");
	
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

	public WebElement getSearch() {
		return driver.findElement(search);
	}
}
