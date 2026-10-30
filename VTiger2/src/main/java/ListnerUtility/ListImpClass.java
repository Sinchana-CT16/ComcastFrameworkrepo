package ListnerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BaseClass;
import GenericUtility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {//this method is used to configure the report
		// spark report config
		//System.out.println("connect to db,report");
		String now = new Date().toString().replace(" ", "_").replace(":", "_");

		spark = new ExtentSparkReporter("./AdvanceReports/report"+now+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		// add env information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-152");
	}

	public void onFinish(ISuite suite) {
		report.flush();
		// report backup
	}

	public void onTestStart(ITestResult result) {// onTestStart will execute before each test so we we stored test = report.createTest(result.getMethod().getMethodName()); here 
		test = report.createTest(result.getMethod().getMethodName());//it will insert a test case in extent report
		// create test case inside extend report
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO,result.getMethod().getMethodName()+"==>STARTED<==" );
	}
	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.PASS,result.getMethod().getMethodName()+"==>COMPLETED<==" );
	}
	
	public void onTestFailure(ITestResult result) {
		//  this program is implemented  to take screenshot in case of failure
	    UtilityClassObject.getTest().log(Status.FAIL,result.getMethod().getMethodName() + " ==> FAILED <==");
		String testName = result.getMethod().getMethodName();
		String now = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);//return the screenshot location
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath, testName + "_" + now);
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./screenshots/" + testName + "_" + now + ".png");
//		FileUtils.copyFile(src, dest);
//		UtilityClassObject.getTest().addScreenCaptureFromPath(dest.getAbsolutePath());

	}
	public void onTestSkipped(ITestResult result) {
		    UtilityClassObject.getTest().log(Status.SKIP,result.getMethod().getMethodName() + " ==> SKIPPED <==");
		}
}
