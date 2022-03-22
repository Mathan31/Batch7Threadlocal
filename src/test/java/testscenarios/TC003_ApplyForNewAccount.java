package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.ApplyForNewAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ApplyPage;

public class TC003_ApplyForNewAccount extends BaseClass{
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFile = "TC003";
		authors = "Arun";
		category = "Regression";
		testCaseName = "New Saving Account";
		testDescription = "Validating New Saving Account Functionality!!!";
		module = "New Saving Account module";
	}	
	
	@Test(priority = 1)
	public void ApplyForNewAccountValidation() {
		boolean result = new LoginPage()
		.typeUserName("ramnad")
		.typePassword("kannakku234")
		.clickSignOn()
		.validateHomePage()
		.clickApplyForNewAccount()
		.verifyAllTheAcctFields();
		
		new ApplyForNewAccountPage()
		.clickApply()
		.verifyAccountCreatePage()
		
		//new ApplyPage(driver)
		.clickOnViewAccout()
		.clickonLogout();
		
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void accountCreation(String accountNickName,String typeOfAccount) {
		boolean result = new LoginPage()
		.typeUserName("ramnad")
		.typePassword("kannakku234")
		.clickSignOn()
		.clickApplyForNewAccount()
		.enterAccountNicktName(accountNickName+getRandomIntNumber(1000,10000))
		.selectTypeOfAccount(typeOfAccount)
		.clickApply()
		.verifyAccountCreateResult();
		if (result) {
			
			System.out.println("Account Verified");
			new ApplyPage()
			.clickOnViewAccout(accountNickName)
			.clickonLogout();
			
			
			
		}else {
			System.out.println("Account not much with the Given Name");
			new ApplyPage()
			.clickOnViewAccout()
			.clickonLogout();
			
		}
		
	}
	public static int getRandomIntNumber(int min,int max) {
		Random ran = new Random();
		int result = ran.nextInt((max-min)+1)+min;
		return result;
	}

}
