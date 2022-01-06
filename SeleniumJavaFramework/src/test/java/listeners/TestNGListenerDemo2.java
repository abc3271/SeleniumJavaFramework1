package listeners;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo2 {
	
	@Test
	public void test4() {
		System.out.println("Inside Test 4!");
	}
	@Test
	public void test5() {
		System.out.println("Inside Test 5!");
		Assert.assertTrue(false);
	}
	@Test
	public void test6() {
		System.out.println("Inside Test 6!");
		throw new SkipException("This Test will be skipped...");
	}
	

}
