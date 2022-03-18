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
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage(driver).verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String userName,String password) {
		boolean result = new LoginPage(driver)
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
		boolean result = new LoginPage(driver)
		.typeUserName("Mathan")
		.typePassword("Testing231")
		.clickSingOnWithInValidCredential()
		.validateLoginFailedText();
		Assert.assertTrue(result);
	}

}
