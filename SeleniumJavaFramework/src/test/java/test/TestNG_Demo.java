package test;

import org.testng.annotations.Test;

import config.PropertiesFile;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TestNG_Demo {
	
	static WebDriver driver = null;
	public static String browserName = null;
	
	 @BeforeTest
  public void beforeTest() {
		 String projectPath = System.getProperty("user.dir");
		 PropertiesFile.getProperties();
		 
		 if (browserName.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			 driver = new ChromeDriver();
		 }
		 else if(browserName.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
			 driver = new FirefoxDriver();
		 }
	  }
	
  @Test
  public static void googleSearch() {
	  	driver.get("https://www.google.com");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("q")).sendKeys("Searching for things.");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);		  
  }

  @AfterTest
  public void testDownTest() {
		driver.close();
		System.out.println("Test Completed Successfully!");
		PropertiesFile.setProperties();
  }

}

