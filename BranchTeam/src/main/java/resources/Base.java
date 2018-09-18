package resources;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\nehag\\BranchTeam\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			// Execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nehag\\BranchTeam\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			// Execute in firefox driver
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nehag\\BranchTeam\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("IE")){
			// Execute in Internet Explorer browser
			System.setProperty("webdriver.ie.driver","C:\\Users\\nehag\\BranchTeam\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		// Implicit Wait for all test cases
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
