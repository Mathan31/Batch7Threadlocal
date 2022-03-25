package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import libraries.SeleniumWrapper;
import utilities.ExcelReader;
import utilities.PropertiesReader;
 
public class BaseClass extends SeleniumWrapper{
	
	 public WebDriver driver; 
	 int iBrowserType = 1; //1 - Chrome,2 - FF,3 - Edge,4 - IE
	 String propertyFile = "Environment_Details";
	 String sURL = PropertiesReader.getPropertyValue(propertyFile, "production");
	 public String excelFile = "";
	 public String testCaseName,testDescription,module;
	 
	 @BeforeSuite
	 public void  reportInit() {
		 startReport();
	 }
	 
	 @AfterSuite
	 public void flushReport() {
		 endReport();
	 }
	
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
		tlDriver.set(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(sURL);
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		startTestCase(testCaseName, testDescription);
		startTestcase(module);
		
	}
	
	@AfterClass
	public  void closeBrowser() {
		//driver.close();
		driver.quit();
	}
	
	@DataProvider(name = "TestCaseData")
	public Object[][] excelData() {
		Object[][] values = ExcelReader.getValueFromExcel(excelFile);
		return values;
	}

	
}

