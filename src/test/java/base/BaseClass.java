package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	 public static WebDriver driver;
	 int iBrowserType = 1; //1 - Chrome,2 - FF,3 - Edge,4 - IE
	 String sURL = "https://uibank.uipath.com/";
	
	@BeforeClass
	public  void invokeBrowser() {
		
		switch (iBrowserType) {
		case 1:
			System.out.println("User Option is : "+iBrowserType+", So Invoking Chrome Browser!!!");
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case 2:
			System.out.println("User Option is : "+iBrowserType+", So Invoking FF Browser!!!");
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case 3:
			System.out.println("User Option is : "+iBrowserType+", So Invoking Edge Browser!!!");
			System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
			
				
		case 4:
				System.out.println("User Option is : "+iBrowserType+", So Invoking IE Browser!!!");
				System.setProperty("webdriver.ie.driver","./drivers/iedriver.exe");
				driver = new InternetExplorerDriver();
				break;

		default:
			System.out.println("User Option is wrong : "+iBrowserType+", So Invoking default Chrome Browser!!!");
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterClass
	public  void closeBrowser() {
		//driver.close();
		driver.quit();
	}

}

