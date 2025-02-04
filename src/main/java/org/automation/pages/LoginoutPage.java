package org.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginoutPage {
	private WebDriver driver;
	
	public LoginoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By loginEmail = By.xpath("//input[@data-qa='login-email']");
	private By loginPassword = By.xpath("//input[@data-qa='login-password']");
	private By loginButton = By.xpath("//button[@data-qa='login-button']");
	
	private By logoutTab = By.xpath("//a[contains(text(),'Logout')]");
	
	public void loginDetails(String name, String email) {
        driver.findElement(loginEmail).sendKeys(name);
        driver.findElement(loginPassword).sendKeys(email);
        driver.findElement(loginButton).click();
    }
	
	public void logout() {
		driver.findElement(logoutTab).click();
	}

}
