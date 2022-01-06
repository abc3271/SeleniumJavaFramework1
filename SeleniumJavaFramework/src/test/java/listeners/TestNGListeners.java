package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestNGListeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("******** Test Started: " + result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("******** Test Successful: " + result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("******** Test Failed: " + result.getName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("******** Test Skipped: " + result.getName());
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("******** Test Barely Failed: " + result.getName());
		
	}
	
	public void onStart(ITestResult context) {
		System.out.println("******** Test Begins: " + context.getName());
		
	}
	
	public void onFinish(ITestResult context) {
		System.out.println("******** Test Completed: " + context.getName());
		
	}

}
