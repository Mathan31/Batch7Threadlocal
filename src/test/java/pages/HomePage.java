package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	private By oWelcome = By.xpath("//h3[contains(text(),' Welcome!')]");
	private By oLogout = By.xpath("//a[text()='Logout']");
	private By oApplyForNewAccount = By.xpath("//div[@class='btn btn-white card-header-item']");
	//div[@class='btn btn-white card-header-item']
	private By oAccountName;
	//private By //div[contains(text(),'Apply For New Account')]
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage(WebDriver driver, String accountNickName) {
		this.driver = driver;
		try {
			oAccountName = (By) driver.findElement(By.xpath("//Strong[contains(text(),'accountNickName')]"));
			System.out.println("Account created in the giveng name : "+accountNickName);
		} catch (Exception e) {
			
			System.out.println("Account Not created for : "+accountNickName);
			
		}
	       {
			
		}
	}
	
	public HomePage validateHomePage() {
		if(driver.findElement(oWelcome).isDisplayed() && (driver.findElement(oLogout).isDisplayed())) {
			System.out.println("User Landed to the Home Page!!!");
			return this;
		}else {
			System.out.println("User not in Home Page.");
			return this;
		}
	}
	
	public ApplyForNewAccountPage clickApplyForNewAccount() {
		driver.findElement(oApplyForNewAccount).click();
		return new ApplyForNewAccountPage(driver);
	}
	 
	public LoginPage clickonLogout() {
		driver.findElement(oLogout).click();
		return new LoginPage(driver);
	}
	
	
}
