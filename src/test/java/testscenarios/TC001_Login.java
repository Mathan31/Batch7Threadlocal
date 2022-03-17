package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage().verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2)
	public void loginWithValidCredential() {
		boolean result = new LoginPage()
		.typeUserName("Mathan")
		.typePassword("Testing123")
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
