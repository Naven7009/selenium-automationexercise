package org.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automationtest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
		driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("automationexercise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("automationexecrice5@gmail.com");
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		
		try {
		WebElement emailText = driver.findElement(By.xpath("//p[contains(text(),'Email Address')]"));
		System.out.println(emailText.getText());
		driver.close();
		}catch (NoSuchElementException e) {
		    System.out.println("New user......");
		    
		    driver.findElement(By.id("id_gender1")).click();
			driver.findElement(By.id("password")).sendKeys("password");
			
			WebElement days = driver.findElement(By.xpath("//select[@id='days']"));
			Select s_days = new Select(days);
			s_days.selectByVisibleText("19");
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			WebElement months = driver.findElement(By.xpath("//select[@id='months']"));
			Select s_month = new Select(months);
			s_month.selectByVisibleText("June");
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			WebElement years = driver.findElement(By.xpath("//select[@id='years']"));
			Select s_years = new Select(years);
			s_years.selectByVisibleText("1997");
			driver.findElement(By.id("newsletter")).click();
			driver.findElement(By.id("optin")).click();
			
			driver.findElement(By.id("first_name")).sendKeys("Naven");
			driver.findElement(By.id("last_name")).sendKeys("Raj");
			driver.findElement(By.id("company")).sendKeys("google");
			driver.findElement(By.id("address1")).sendKeys("perungudi");
			driver.findElement(By.id("address2")).sendKeys("chennai");
			
			WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
			Select s_country = new Select(country);
			s_country.selectByVisibleText("Israel");
			
			driver.findElement(By.id("state")).sendKeys("Tamilnadu");
			driver.findElement(By.id("city")).sendKeys("Chennai");
			driver.findElement(By.id("zipcode")).sendKeys("600001");
			driver.findElement(By.id("mobile_number")).sendKeys("9789789774");
			driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
			
			WebElement accountcreated = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
			System.out.println(accountcreated.getText());
			driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
			//driver.close();
		}
				
	}

}
