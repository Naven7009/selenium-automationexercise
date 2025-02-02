package org.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By signupTab = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By emailText = By.xpath("//p[contains(text(),'Email Address')]");
    private By gender = By.id("id_gender1");
    private By password = By.id("password");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By newsletter = By.id("newsletter");
    private By option = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");
    private By addressLine1 = By.id("address1");
    private By addressLine2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobilenumber = By.id("mobile_number");
    private By createAccount = By.xpath("//button[@data-qa='create-account']");
    private By accountCreated = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    // Methods for interacting with the page
    public void clickSignupTab() {
        driver.findElement(signupTab).click();
    }

    public void enterSignupDetails(String name, String email) {
        driver.findElement(signupName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        driver.findElement(signupButton).click();
    }

    public boolean isEmailAlreadyRegistered() {
        return driver.findElements(emailText).size() > 0;
    }

    public void fillSignupForm() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(gender).click();
        driver.findElement(password).sendKeys("password");

        new Select(driver.findElement(days)).selectByVisibleText("19");
        new Select(driver.findElement(months)).selectByVisibleText("June");
        new Select(driver.findElement(years)).selectByVisibleText("1997");

        driver.findElement(newsletter).click();
        driver.findElement(option).click();

        driver.findElement(firstName).sendKeys("Naven");
        driver.findElement(lastName).sendKeys("Raj");
        driver.findElement(company).sendKeys("Google");
        driver.findElement(addressLine1).sendKeys("Perungudi");
        driver.findElement(addressLine2).sendKeys("Chennai");

        new Select(driver.findElement(country)).selectByVisibleText("Israel");
        driver.findElement(state).sendKeys("Tamil Nadu");
        driver.findElement(city).sendKeys("Chennai");
        driver.findElement(zipcode).sendKeys("600001");
        driver.findElement(mobilenumber).sendKeys("9789789774");
    }

    public void createAccount() {
        driver.findElement(createAccount).click();
    }

    public boolean isAccountCreated() {
        return driver.findElements(accountCreated).size() > 0;
    }

    public void continueToHomePage() {
        driver.findElement(continueButton).click();
    }
}
