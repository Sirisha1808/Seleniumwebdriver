package day46Listeners;

//This is the extent report utility file

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;//UI of the report
	public ExtentReports extent;//populated commom info on the report
	public ExtentTest test;//Creating test case entries in the report and update status of the test method//this test only for storing the data not creating the data 
	
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		
		sparkReporter.config().setDocumentTitle("AutomationReport");//Title of the report
		sparkReporter.config().setReportName("Functional Tetsing");//Name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("ComputerName","localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("TesterName", "Sirisha");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("BrowserName", "Chrome");
	}
	
	public void onTestStart(ITestResult result) { // New method to create test instance
        test = extent.createTest(result.getMethod().getMethodName()); // Create new entry in the report
    }
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case PASSED is:"+result.getName());//Update the status p/f/s
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:"+result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is:"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());//create new entry in the report
		test.log(Status.SKIP, "Test case SKIPPED is:"+result.getName());//Update the status p/f/s
	}
	
	public void onFinish(ITestContext context) {
		
	            extent.flush(); // Save report
	}

	
}
