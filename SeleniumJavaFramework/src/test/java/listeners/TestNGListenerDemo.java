package listeners;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("Inside Test 1!");
	}
	@Test
	public void test2() {
		System.out.println("Inside Test 2!");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing123");
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("testing123");
		
		driver.close();

	}
	@Test
	public void test3() {
		System.out.println("Inside Test 3!");
		throw new SkipException("This Test will be skipped...");
	}
	

}
