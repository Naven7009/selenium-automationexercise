package org.automation.tests;

import org.automation.base.*;
import org.automation.pages.LoginoutPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginoutTest extends BaseClass {
    private LoginoutPage loginoutPage;

    @BeforeClass
    public void setUp() {
        initializeDriver();
        loginoutPage = new LoginoutPage(driver);
    }

    @Test(priority = 2 )
    public void testLogin() {
        loginoutPage.loginDetails("automationexercise16@gmail.com", "password");
    }
//Priority is not required if dependsOnGroups or dependsOnMethods are used
    @Test(dependsOnMethods = {"org.automation.tests.SignupTest.testSignup","org.automation.tests.LoginoutTest.testLogin"}, alwaysRun = true)
    public void testLogout() {
        loginoutPage.logout();
        System.out.println("User logged out successfully.");
    }
}
