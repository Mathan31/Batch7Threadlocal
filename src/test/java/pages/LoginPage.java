package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class LoginPage extends BaseClass{
	
	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Register For Account']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private WebDriver driver;
	private SeleniumWrapper wrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		wrap = new SeleniumWrapper(driver, node);
	} 
	
	public boolean verifyElement() {
		if(wrap.verifyDisplayedwithReturn(driver.findElement(oUsernameText))&& 
				wrap.verifyDisplayedwithReturn(driver.findElement(oPasswordText)) &&
				wrap.verifyDisplayedwithReturn(driver.findElement(oSignInBtn)) &&
				wrap.verifyDisplayedwithReturn(driver.findElement(oForgotLink)) &&
				wrap.verifyDisplayedwithReturn(driver.findElement(oRegisterLink))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage typeUserName(String userName) {
		wrap.type(driver.findElement(oUsernameText), userName);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		wrap.type(driver.findElement(oPasswordText), password);
		return this;
	}
	
	public HomePage clickSignOn() {
		wrap.click(driver.findElement(oSignInBtn));
		return new HomePage(driver,node);
	}
	
	public LoginPage clickSingOnWithInValidCredential() {
		wrap.click(driver.findElement(oSignInBtn));
		return this;
	}

	public boolean validateLoginFailedText() {
		boolean result = wrap.verifyDisplayedwithReturn(driver.findElement(oLoginFailedInnerText));
		return result;
	}
	
	public RegistrationPage clickOnRegistrationLink() {
		wrap.click(driver.findElement(oRegisterLink));
		return new RegistrationPage(driver,node);
	}


}
