package day46Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListners implements ITestListener{
	
	public void onStart(ITestContext context) {
	   System.out.println("Test Execution is Started.........");
	  } 
	
	//Every before test method is executed
	public void onTestStart(ITestResult result) {
	    System.out.println("Test Started......");
	  }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed.....");
	  }

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed......");
	  }
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped......");
	  }
	
	public void onFinish(ITestContext context) {
		System.out.println("Test Execution is Completed.........");
	  }

}
