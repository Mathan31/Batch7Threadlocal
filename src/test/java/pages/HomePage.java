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

	public HomePage validateHomePage() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oWelcome)) && verifyDisplayedwithReturn(getDriver().findElement(oLogout))) {
			System.out.println("User Landed to the Home Page!!!");
			return this;
		}else {
			System.out.println("User not in Home Page.");
			return this;
		}
	}
	
	public ApplyForNewAccountPage clickApplyForNewAccount() {
		click(getDriver().findElement(oApplyForNewAccount));
		return new ApplyForNewAccountPage();
	}
	 
	public LoginPage clickonLogout() {
		click(getDriver().findElement(oLogout));
		return new LoginPage();
	}
	
	
}
