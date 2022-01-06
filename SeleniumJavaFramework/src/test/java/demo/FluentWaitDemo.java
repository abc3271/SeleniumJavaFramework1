package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

// not working as intended at the moment :(
public class FluentWaitDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Testing123");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		WebElement m = driver.findElement(By.linkText("2"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].click();", m);
		
//		driver.findElement(By.linkText("Testing123 - Twitch")).click();
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 2 seconds.
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

			WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					WebElement linkElement = driver.findElement(By.xpath("xpath=//div[@id='rso']/div/div/div/div/a/h3"));
					if(linkElement.isEnabled()) {
						System.out.println("Element Found");
					}
		       	return linkElement;
				}
			});
		
	    j.executeScript("arguments[0].click();", element);
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
