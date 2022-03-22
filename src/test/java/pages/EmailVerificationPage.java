package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class EmailVerificationPage extends BaseClass {
	
	private By oWelcome = By.xpath("//h2[contains(text(),'Welcome To The UiBank Family!')]");
	private By oLogin = By.linkText("Login");
	private WebDriver driver;
	private SeleniumWrapper wrap;
	
	public EmailVerificationPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node =  node;
		wrap = new SeleniumWrapper(driver, node);
	}
	
	public EmailVerificationPage verifyUserRegistration() {
		boolean displayed = wrap.verifyDisplayedwithReturn(driver.findElement(oWelcome));
		if(displayed) {
			System.out.println("User Registration is Successfull!!!");
		}else {
			System.out.println("User Registration is Not Successfull!!!");
		}
		return this;
	} 
	
	public LoginPage clickOnLogin() {
		wrap.click(driver.findElement(oLogin));
		return new LoginPage(driver,node);
	}

}
