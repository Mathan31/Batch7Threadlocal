package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Register For Account']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	
	
	public boolean verifyElement() {
		if(driver.findElement(oUsernameText).isDisplayed() && 
				driver.findElement(oPasswordText).isDisplayed() &&
				driver.findElement(oSignInBtn).isEnabled() &&
				driver.findElement(oForgotLink).isDisplayed() &&
				driver.findElement(oRegisterLink).isDisplayed()) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage typeUserName(String userName) {
		driver.findElement(oUsernameText).sendKeys(userName);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		driver.findElement(oPasswordText).sendKeys(password);
		return this;
	}
	
	public HomePage clickSignOn() {
		driver.findElement(oSignInBtn).click();
		return new HomePage();
	}
	
	public LoginPage clickSingOnWithInValidCredential() {
		driver.findElement(oSignInBtn).click();
		return this;
	}

	public boolean validateLoginFailedText() {
		boolean result = driver.findElement(oLoginFailedInnerText).isDisplayed();
		return result;
	}
	
	public RegistrationPage clickOnRegistrationLink() {
		driver.findElement(oRegisterLink).click();
		return new RegistrationPage();
	}


}
