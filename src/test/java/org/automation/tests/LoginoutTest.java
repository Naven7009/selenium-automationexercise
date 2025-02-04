package org.automation.tests;

import org.automation.base.*;
import org.automation.pages.LoginoutPage;
import org.automation.pages.SignupPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginoutTest extends BaseClass {
	private LoginoutPage loginoutPage ;

	@BeforeClass
	public void setUp() {
		initializeDriver();
		//loadUrl("https://www.automationexercise.com");
		loginoutPage = new LoginoutPage(driver);
	}

	@Test(priority = 2)
    public void testLogin() {
        loginoutPage.loginDetails("automationexercise12@gmail.com", "password");
    }
    
    @Test(priority = 3)
    public void testLogout() {
        loginoutPage.logout();
    }
}