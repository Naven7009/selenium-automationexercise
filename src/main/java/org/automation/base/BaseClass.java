package org.automation.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    protected static WebDriver driver;

    public void initializeDriver() {
    	if (driver == null) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	}
    }

    public void loadUrl(String url) {
    	if (driver != null) {
            driver.get(url);
        }
    }

//    public void closeBrowser() {
//    	if (driver != null) {
//            driver.quit();
//            driver = null;  // Reset for next execution
//        }
//    }
}
