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

	
	
	public boolean verifyElement() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oUsernameText))&& 
				verifyDisplayedwithReturn(getDriver().findElement(oPasswordText)) &&
				verifyDisplayedwithReturn(getDriver().findElement(oSignInBtn)) &&
				verifyDisplayedwithReturn(getDriver().findElement(oForgotLink)) &&
				verifyDisplayedwithReturn(getDriver().findElement(oRegisterLink))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage typeUserName(String userName) {
		type(getDriver().findElement(oUsernameText), userName);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(oPasswordText), password);
		return this;
	}
	
	public HomePage clickSignOn() {
		click(getDriver().findElement(oSignInBtn));
		return new HomePage();
	}
	
	public LoginPage clickSingOnWithInValidCredential() {
		click(getDriver().findElement(oSignInBtn));
		return this;
	}

	public boolean validateLoginFailedText() {
		boolean result = verifyDisplayedwithReturn(getDriver().findElement(oLoginFailedInnerText));
		return result;
	}
	
	public RegistrationPage clickOnRegistrationLink() {
		click(getDriver().findElement(oRegisterLink));
		return new RegistrationPage();
	}


}
