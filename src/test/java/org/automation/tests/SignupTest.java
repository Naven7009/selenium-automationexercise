/*Class Name - PascalCase AutomationTest (not Automationtest)
Method Names → CamelCase initializeDriver(),loadUrl()
Instance Variables → private WebDriver driver
*/
//intializeDriver() or constructor -- which is best??
package org.automation.tests;

import org.automation.base.*;
import org.automation.pages.SignupPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends BaseClass {
	private SignupPage signupPage;

	@BeforeClass
	public void setUp() {
		initializeDriver();
		loadUrl("https://www.automationexercise.com");
		signupPage = new SignupPage(driver);
	}

	@Test(priority = 1)
	public void testSignup() {
		signupPage.clickSignupTab();
		signupPage.enterSignupDetails("automationexercise", "automationexercise21@gmail.com");

		if (signupPage.isEmailAlreadyRegistered()) {
			System.out.println("Email already registered. Login instead.");
		} else {
			System.out.println("New user detected. Proceeding with signup...");
			signupPage.fillSignupForm();
			signupPage.createAccount();
			signupPage.continueToHomePage();
			
		}
	}
}
