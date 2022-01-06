package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsDemoWithTestNG {
	
	private static ExtentReports extent;
	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		
		extent = new ExtentReports("extentReports.html", true); 
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
        		
	}
	
	@Test
	public void test1() {
		
		ExtentTest test = extent.startTest("My First Test", "Sample description");

		// log(LogStatus, details)
        test.log(LogStatus.INFO, "This step shows usage of log(logStatus, details)");
        
        driver.get("https://www.google.com");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("q")).sendKeys("Searching for things.");
		
		test.log(LogStatus.PASS, "This step shows usage of log(logStatus, details)");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        
        // report with snapshot
        String img = test.addScreenCapture("screenshot.png");
        test.log(LogStatus.INFO, "Image", "Image example: " + img);
		
	}
	
	@Test
	public void test2() {
		
		ExtentTest test = extent.startTest("My First Test", "Sample description");

		// log(LogStatus, details)
        test.log(LogStatus.INFO, "This step shows usage of log(logStatus, details)");

        test.log(LogStatus.FAIL, "This step shows usage of log(logStatus, details)");
        
        // report with snapshot
        String img = test.addScreenCapture("screenshot.jpg");
        test.log(LogStatus.INFO, "Image", "Image example: " + img);
		
	}

	@AfterTest
	public void tearDown() {
		
		driver.close();
		
		// calling flush writes everything to the log file
        extent.flush();
		
	}
	
}
