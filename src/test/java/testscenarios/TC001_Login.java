package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFile = "TC001";
		authors = "Ramanan";
		category = "Smoke";
		testCaseName = "Login";
		testDescription = "Validating Login Functionality!!!";
		module = "Login module";
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage().verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String userName,String password) {
		boolean result = new LoginPage()
		.typeUserName(userName)
		.typePassword(password)
		.clickSignOn()
		.validateHomePage()
		.clickonLogout()
		.verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.typeUserName("Mathan")
		.typePassword("Testing231")
		.clickSingOnWithInValidCredential()
		.validateLoginFailedText();
		Assert.assertTrue(result);
	}

}
