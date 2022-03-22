package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

import libraries.HTMLReport;
import utilities.ExcelReader;
import utilities.PropertiesReader;

public class BaseClass extends HTMLReport{
	
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
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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

	@Override
	public String takeScreenshot() {
		String sPath = System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		TakesScreenshot oShot = (TakesScreenshot)driver;
		File osrc = oShot.getScreenshotAs(OutputType.FILE);
		File dis = new File(sPath);
		try {
			FileUtils.copyFile(osrc, dis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sPath;
	}

}

