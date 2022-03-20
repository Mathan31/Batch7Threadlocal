package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class ApplyPage extends BaseClass {
	
	private By oWelcome = By.xpath("//h1[contains(text(),'Congrats,')]");
	private By oNewAccountId = By.xpath("//span[@id='accountId']");
	private By oAccountName = By.xpath("//span[@id='accountName']");
	//private By oViewAccountBtn = By.id("//div[@id='viewAccounts']");
	private By oViewAccountBtn = By.xpath("//a[contains(text(),'Accounts')]");
	
	private WebDriver driver;
	
	public ApplyPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ApplyPage verifyAccountCreatePage() {
		boolean displayed = driver.findElement(oWelcome).isDisplayed();
		if(displayed) {
			System.out.println("User in Account created Page");

		return this;
		//return true;
		}else {
			System.out.println("User Not in Account created Page");
		//return false;
			return this;
		}
	} 
	
	
	public boolean verifyAccountCreateResult( ) {
		String oNewAccountIdText = driver.findElement(oNewAccountId).getText();
		String oAccountNameText = driver.findElement(oAccountName).getText();
	if(!oNewAccountIdText.equalsIgnoreCase("0")) {
		System.out.println("Account successfully created");
		System.out.println("New Account ID is : "+oNewAccountIdText);
		if(!oAccountNameText.equalsIgnoreCase("0")) {
		System.out.println("New Account Name is : "+oAccountNameText);
		}
		return true;
	}else {
		System.out.println("Apply Account Not Successfull!!!");
		return false;
	}
	}
	
	//navigate back to home page
	public HomePage clickOnViewAccout() {
		driver.findElement(oViewAccountBtn).click();
		return new HomePage(driver);
	}
	
	public HomePage clickOnViewAccout(String accountNickName) {
		driver.findElement(oViewAccountBtn).click();
		return new HomePage(driver, accountNickName);
	}

}
