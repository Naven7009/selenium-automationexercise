package org.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Class Name - PascalCase AutomationTest (not Automationtest)
Method Names → CamelCase initializeDriver(),loadUrl()
Instance Variables → private WebDriver driver
*/

public class AutomationTest {
	private WebDriver driver;
	
	//intializeDriver() or constructor -- which is best??
	public void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void loadUrl(String url) {
		driver.get(url);
	}
	
	public void click(String locator) {
		By elementLocator = getBy(locator);
		driver.findElement(elementLocator).click();
	}

	public void enterText(String locator, String text) {
		By elementLocator = getBy(locator);
		driver.findElement(elementLocator).sendKeys(text);
	}
	
	public void getText(String locator) {
		By elementLocator = getBy(locator);
		WebElement element = driver.findElement(elementLocator);
		System.out.println(element.getText());
//		System.out.println(getText);
//		return getText;
	}
	
	public void selectDropdown(String locator, String text) {
		By elementLocator = getBy(locator);
		WebElement selectLocator = driver.findElement(elementLocator);
		Select selectDropdown = new Select(selectLocator);
		selectDropdown.selectByVisibleText(text);
	}
	
	public void wait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	private By getBy(String locator) {
		if (locator.startsWith("//")) {  // If it's an XPath
			return By.xpath(locator);
		} else {  // Else assume it's an ID 
			return By.id(locator);
		}
	}

	public static void main(String[] args) {
		AutomationTest test = new AutomationTest();
		test.initializeDriver();
		test.loadUrl("https://www.automationexercise.com");
		
		String signupTab = "//a[contains(text(),'Signup / Login')]";  
		String signupName = "//input[@data-qa='signup-name']";
		String signupEmail = "//input[@data-qa='signup-email']";
		String signupbutton = "//button[@data-qa='signup-button']";
		String emailText = "//p[contains(text(),'Email Address')]";
		String gender = "id_gender1";
		String password = "password";
		String days = "//select[@id='days']";
		String months = "//select[@id='months']";
		String years = "//select[@id='years']";
		String newsletter = "newsletter";
		String option = "optin";
		String firstName = "first_name";
		String lastName = "last_name";
		String company = "company";
		String addressLine1 = "address1";
		String addressLine2 = "address2";
		String country = "//select[@id='country']";
		String state = "state";
		String city = "city";
		String zipcode = "zipcode";
		String mobilenumber = "mobile_number";
		String createaccount = "//button[@data-qa='create-account']";
		String accountCreated = "//h2[@data-qa='account-created']";
		String continuebutton = "//a[@data-qa='continue-button']";
		
		test.click(signupTab);
		test.enterText(signupName,"automationexercise");
		test.wait(1000);
		test.enterText(signupEmail, "automationexecrice8@gmail.com");
		test.click(signupbutton);
			
		try {
			test.getText(emailText); 
			test.wait(5000);
//		//driver.close();
		}catch (NoSuchElementException e) {
		    System.out.println("New user......");
		    test.click(gender);
		    test.enterText(password,"password");
			
		    test.selectDropdown(days, "19");
		    test.selectDropdown(months, "June");
		    test.selectDropdown(years, "1997");

		    test.click(newsletter);
		    test.click(option);
			
		    test.enterText(firstName,"Naven");
			test.enterText(lastName,"Raj");
			test.enterText(company,"google");
			test.enterText(addressLine1,"Perungudi");
			test.enterText(addressLine2,"Chennai");
			
			test.selectDropdown(country, "Israel");
			test.enterText(state, "Tamilnadu");
			test.enterText(city,"Chennai");
			test.enterText(zipcode,"600001");
			test.enterText(mobilenumber,"9789789774");
			test.click(createaccount);
			
			test.getText(accountCreated);
			test.click(continuebutton);
			//driver.close();
		}
				
	}

}
