package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class ApplyForNewAccountPage extends BaseClass{
	
	private By oAccountNickname = By.id("accountNickname");
	private By oTypeOfAccount = By.id("typeOfAccount");
	private By oApply = By.xpath("//button[contains(text(),'Apply')]");
	
	
	private WebDriver driver;
	
	public ApplyForNewAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyAllTheAcctFields() {
		if(driver.findElement(oAccountNickname).isDisplayed() && driver.findElement(oTypeOfAccount).isDisplayed()
				&& driver.findElement(oApply).isDisplayed()) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public ApplyForNewAccountPage enterAccountNicktName(String accountNickname) {
		driver.findElement(oAccountNickname).sendKeys(accountNickname);
		return this;
	}
	
	public ApplyForNewAccountPage selectTypeOfAccount(String typeOfAccount) {
		Select oSelect = new Select(driver.findElement(oTypeOfAccount));
		oSelect.selectByVisibleText(typeOfAccount);
		return this;
	}
	
		
	public ApplyPage clickApply() {
		driver.findElement(oApply).click();
		return new ApplyPage(driver);
		}
	


}
