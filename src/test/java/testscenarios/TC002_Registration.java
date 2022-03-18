package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	
	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean result = new LoginPage()
		.clickOnRegistrationLink()
		.verifyAllTheFields();
		new RegistrationPage()
		.clickOnUILogo();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2)
	public void registrationWithMandatoryFields() {
		new LoginPage()
		.clickOnRegistrationLink()
		.enterFirstName("Credo")
		.selectTitle("Mr")
		.enterMiddleName()
		.enterLastName("Systemz")
		.selectGender("Male")
		.enterUserName("Credo"+getRandomIntNumber(1000,10000))
		.enterEmail("credo"+getRandomIntNumber(1000,10000)+"@credosystemz.com")
		.enterPassword("Credo@123")
		.clickRegisterLink()
		.verifyUserRegistration()
		.clickOnLogin();
	}
	
	@Test(priority = 3)
	public void registrationWithMandatoryAndOptionalFields() {
		new LoginPage()
		.clickOnRegistrationLink()
		.enterFirstName("Credo")
		.selectTitle("Mr")
		.enterMiddleName()
		.enterLastName("Systemz")
		.selectGender("Male")
		.enterUserName("Credo"+getRandomIntNumber(1000,10000))
		.enterEmail("credo"+getRandomIntNumber(1000,10000)+"@credosystemz.com")
		.enterPassword("Credo@123")
		.enterEmploymentStatus("Part-time")
		.enterAge("10/10/1980")
		.enterMartialStatus("Married")
		.enterNumberOfDependents("3")
		.clickRegisterLink()
		.verifyUserRegistration()
		.clickOnLogin();
	}
	
	public static int getRandomIntNumber(int min,int max) {
		Random ran = new Random();
		int result = ran.nextInt((max-min)+1)+min;
		return result;
	}

}
