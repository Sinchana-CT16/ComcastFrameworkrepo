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

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {//this method is used to configure the report
		// spark report config
		//System.out.println("connect to db,report");
		spark = new ExtentSparkReporter("./AdvanceReports/reports.html");
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
		test.log(Status.INFO,result.getMethod().getMethodName()+"==>STARTED<==" );
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"==>COMPLETED<==" );

	}
	@Override
	public void onTestFailure(ITestResult result) {
		//  this program is implemented  to take screenshot in case of failure
		String testName = result.getMethod().getMethodName();
		String now = new Date().toString().replace(" ", "_").replace(":", "_");

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);//return the screenshot location
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + now);

	}

}
