package listerners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listners extends Base implements ITestListener {
	
	WebDriver driver = null;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName + " Test execution is started ");
		extentTestThread.set(extentTest);
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
	//	extentTest.log(Status.PASS, testName +" is passed");
		extentTestThread.get().log(Status.PASS, testName +" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		String testname = result.getName();
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String screenshotpath = takeScreenShot(testname, driver );
			extentTestThread.get().addScreenCaptureFromPath(screenshotpath,testname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		}

	@Override
	public void onStart(ITestContext context) {
		}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();
		}

	
}
