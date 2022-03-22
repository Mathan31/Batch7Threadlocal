package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class HomePage extends BaseClass{
	
	private By oWelcome = By.xpath("//h3[contains(text(),' Welcome!')]");
	private By oLogout = By.xpath("//a[text()='Logout']");
	private By oApplyForNewAccount = By.xpath("//div[@class='btn btn-white card-header-item']");
	//div[@class='btn btn-white card-header-item']
	//private By //div[contains(text(),'Apply For New Account')]
	private WebDriver driver;
	private SeleniumWrapper wrap;
	
	public HomePage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node =  node;
		wrap = new SeleniumWrapper(driver, node);
	}

	
	public HomePage validateHomePage() {
		if(wrap.verifyDisplayedwithReturn(driver.findElement(oWelcome)) && wrap.verifyDisplayedwithReturn(driver.findElement(oLogout))) {
			System.out.println("User Landed to the Home Page!!!");
			return this;
		}else {
			System.out.println("User not in Home Page.");
			return this;
		}
	}
	
	public ApplyForNewAccountPage clickApplyForNewAccount() {
		wrap.click(driver.findElement(oApplyForNewAccount));
		return new ApplyForNewAccountPage(driver,node);
	}
	 
	public LoginPage clickonLogout() {
		wrap.click(driver.findElement(oLogout));
		return new LoginPage(driver,node);
	}
	
	
}
