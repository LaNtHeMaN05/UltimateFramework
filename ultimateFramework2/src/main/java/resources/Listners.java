package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listners extends WebBaseClass implements ITestListener {
	
	WebDriver driver=null;
	MobileBaseClass mbc=new MobileBaseClass();
	
	ExtentReps er=new ExtentReps();
	ExtentReports extent=er.getReports();
	
	ThreadLocal<ExtentTest> et=new ThreadLocal<ExtentTest>();
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		et.set(test);

	}


	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName);
		et.get().log(Status.PASS, "Test Passed Successfully");
		if (methodName.equalsIgnoreCase("Testing1")) {
			try {
				et.get().addScreenCaptureFromPath(mbc.mobileTakeScreenshot(methodName),result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				et.get().addScreenCaptureFromPath(webTakeScreenshot(methodName,driver),result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName);
		et.get().fail(result.getThrowable());
		if (methodName.equalsIgnoreCase("Testing1")) {
			try {
				et.get().addScreenCaptureFromPath(mbc.mobileTakeScreenshot(methodName),result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				et.get().addScreenCaptureFromPath(webTakeScreenshot(methodName,driver),result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	public void onTestSkipped(ITestResult result) {

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
;
	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}
	
	

}
