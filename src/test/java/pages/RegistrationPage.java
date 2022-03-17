package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class RegistrationPage extends BaseClass{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName");
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	private By oEmploymentStatus = By.id("employmentStatus");
	private By oAge = By.id("age");
	private By oMartialStatus = By.id("maritalStatus");
	private By oNumberOfDependents = By.id("numberOfDependents");
	
	
	public boolean verifyAllTheFields() {
		if(driver.findElement(oUserName).isDisplayed() && driver.findElement(oPassword).isDisplayed()
				&& driver.findElement(oEmail).isDisplayed()&& driver.findElement(oRegister).isDisplayed()) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public RegistrationPage enterFirstName(String firstName) {
		driver.findElement(oFirstName).sendKeys(firstName);
		return this;
	}
	
	public RegistrationPage selectTitle(String title) {
		Select oSelect = new Select(driver.findElement(oTitle));
		oSelect.selectByVisibleText(title);
		return this;
	}
	
	public RegistrationPage enterMiddleName() {
		driver.findElement(oMiddleName).sendKeys("");
		return this;
	}
	
	public RegistrationPage enterLastName(String lastName) {
		driver.findElement(oLastName).sendKeys(lastName);
		return this;
	}
	
	public RegistrationPage selectGender(String gender) {
		Select oSelect = new Select(driver.findElement(oGender));
		oSelect.selectByVisibleText(gender);
		return this;
	}
	
	public RegistrationPage enterUserName(String userName) {
		driver.findElement(oUserName).sendKeys(userName);
		return this;
	}
	
	public RegistrationPage enterEmail(String email) {
		driver.findElement(oEmail).sendKeys(email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		driver.findElement(oPassword).sendKeys(password);
		return this;
	}
	
	public RegistrationPage enterEmploymentStatus(String employmentStatus) {
		Select oSelect = new Select(driver.findElement(oEmploymentStatus));
		oSelect.selectByVisibleText(employmentStatus);
		return this;
	}
	
	public RegistrationPage enterAge(String age) {
		driver.findElement(oAge).sendKeys(age);
		return this;	
	}
	
	public RegistrationPage enterMartialStatus(String martialStatus) {
		driver.findElement(oMartialStatus).sendKeys(martialStatus);
		return this;
	}
	
	public RegistrationPage enterNumberOfDependents(String noOfDependents) {
		driver.findElement(oNumberOfDependents).sendKeys(noOfDependents);
		return this;
	}
	
	public EmailVerificationPage clickRegisterLink() {
		driver.findElement(oRegister).click();
		return new EmailVerificationPage();
		}
	
	public LoginPage clickOnUILogo() {
		driver.findElement(oUILogo).click();
		return new LoginPage();
	}
	
	

}
