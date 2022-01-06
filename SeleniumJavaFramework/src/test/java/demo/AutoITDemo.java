package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://ezgif.com/gif-to-mp4");
		
		Thread.sleep(2000);
		
		WebElement m = driver.findElement(By.name("new-image"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].click();", m);
		
	    Thread.sleep(2000);
	    
		Runtime.getRuntime().exec("C:/Users/Orion4444/Desktop/Coding/SeleniumAutoITDemo.exe");
		
//		close();

	}

}
