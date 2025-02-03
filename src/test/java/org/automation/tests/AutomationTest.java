/*Class Name - PascalCase AutomationTest (not Automationtest)
Method Names → CamelCase initializeDriver(),loadUrl()
Instance Variables → private WebDriver driver
*/
//intializeDriver() or constructor -- which is best??
package org.automation.tests;

import org.automation.base.*;
import org.automation.pages.SignupPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTest extends BaseClass {
	private SignupPage signupPage;

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loadUrl("https://www.automationexercise.com");
		signupPage = new SignupPage(driver);
	}

	@Test
	public void testSignup() {
		signupPage.clickSignupTab();
		signupPage.enterSignupDetails("automationexercise", "automationexercise12@gmail.com");

		if (signupPage.isEmailAlreadyRegistered()) {
			System.out.println("Email already registered. Login instead.");
		} else {
			System.out.println("New user detected. Proceeding with signup...");
			signupPage.fillSignupForm();
			signupPage.createAccount();

			if (signupPage.isAccountCreated()) {
				System.out.println("Account created successfully.");
				signupPage.continueToHomePage();
			} else {
				System.out.println("Account creation failed.");
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
}
