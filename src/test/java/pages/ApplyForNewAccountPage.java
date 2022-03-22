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
	private SeleniumWrapper wrap;
	
	private WebDriver driver;
	
	public ApplyForNewAccountPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node =  node;
		wrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyAllTheAcctFields() {
		if(wrap.verifyDisplayedwithReturn(driver.findElement(oAccountNickname)) && wrap.verifyDisplayedwithReturn(driver.findElement(oTypeOfAccount))
				&& wrap.verifyDisplayedwithReturn(driver.findElement(oApply))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public ApplyForNewAccountPage enterAccountNicktName(String accountNickname) {
		wrap.type(driver.findElement(oAccountNickname),accountNickname);
		return this;
	}
	
	public ApplyForNewAccountPage selectTypeOfAccount(String typeOfAccount) {
		wrap.selectDropDownUsingVisibleText(driver.findElement(oTypeOfAccount), typeOfAccount);
		return this;
	}
	
		
	public ApplyPage clickApply() {
		driver.findElement(oApply).click();
		return new ApplyPage(driver,node);
		}
	


}
