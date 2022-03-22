package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class ApplyForNewAccountPage extends BaseClass{
	
	private By oAccountNickname = By.id("accountNickname");
	private By oTypeOfAccount = By.id("typeOfAccount");
	private By oApply = By.xpath("//button[contains(text(),'Apply')]");

	public boolean verifyAllTheAcctFields() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oAccountNickname)) && verifyDisplayedwithReturn(getDriver().findElement(oTypeOfAccount))
				&& verifyDisplayedwithReturn(getDriver().findElement(oApply))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public ApplyForNewAccountPage enterAccountNicktName(String accountNickname) {
		type(getDriver().findElement(oAccountNickname),accountNickname);
		return this;
	}
	
	public ApplyForNewAccountPage selectTypeOfAccount(String typeOfAccount) {
		selectDropDownUsingVisibleText(getDriver().findElement(oTypeOfAccount), typeOfAccount);
		return this;
	}
	
		
	public ApplyPage clickApply() {
		getDriver().findElement(oApply).click();
		return new ApplyPage();
		}
	


}
