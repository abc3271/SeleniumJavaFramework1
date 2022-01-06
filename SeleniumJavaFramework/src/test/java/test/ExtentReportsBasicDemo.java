package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsBasicDemo {
	
	private static ExtentReports extent;
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		extent = new ExtentReports("extentReports.html", true);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.startTest("Google Search Test One", "Testing Google search functionality.");

        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// log(LogStatus, details)
        test1.log(LogStatus.INFO, "Starting Test Case");
		
		driver.get("https://www.google.com");
		test1.log(LogStatus.PASS, "Navigated to google.com");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("q")).sendKeys("Searching for things.");
		test1.log(LogStatus.PASS, "Entered text in Searchbox");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.log(LogStatus.PASS, "Pressed Enter");
		
		driver.close();
		driver.quit();
		test1.log(LogStatus.PASS, "Closed browser");
		
		test1.log(LogStatus.INFO, "Test Completed!");

		// calling flush writes everything to the log file
        extent.flush();
        
        
	}

}
