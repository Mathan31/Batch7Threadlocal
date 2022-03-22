package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFile = "TC002";
		authors = "Sri";
		category = "Sanity";
		testCaseName = "User Registration";
		testDescription = "Validating User Registration Functionality!!!";
		module = "Registration module";
	}	
	
	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean result = new LoginPage(driver,node)
		.clickOnRegistrationLink()
		.verifyAllTheFields();
		new RegistrationPage(driver,node)
		.clickOnUILogo();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void registrationWithMandatoryFields(String firstName,String lastName,String userName,String email,String password) {
		new LoginPage(driver,node)
		.clickOnRegistrationLink()
		.enterFirstName(firstName)
		.selectTitle("Mr")
		.enterMiddleName()
		.enterLastName(lastName)
		.selectGender("Male")
		.enterUserName(userName+getRandomIntNumber(1000,10000))
		.enterEmail(email+getRandomIntNumber(1000,10000)+"@credosystemz.com")
		.enterPassword(password)
		.clickRegisterLink()
		.verifyUserRegistration()
		.clickOnLogin();
	}
	
	@Test(priority = 3)
	public void registrationWithMandatoryAndOptionalFields() {
		new LoginPage(driver,node)
		.clickOnRegistrationLink()
		.enterFirstName("Credo")
		.selectTitle("Mr")
		.enterMiddleName()
		.enterLastName("Systemz")
		.selectGender("Male")
		.enterUserName("Credo"+getRandomIntNumber(10000,100000))
		.enterEmail("credo"+getRandomIntNumber(10000,100000)+"@credosystemz.com")
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
