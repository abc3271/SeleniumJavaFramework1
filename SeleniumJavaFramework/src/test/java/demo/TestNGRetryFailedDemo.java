package demo;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {
	
	@Test
	public void test1() {
		System.out.println("Inside Test 1...");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside Test 2...");
//		int i = 1/0;
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void test3() {
		System.out.println("Inside Test 3...");
		Assert.assertTrue(false);
	}

}
