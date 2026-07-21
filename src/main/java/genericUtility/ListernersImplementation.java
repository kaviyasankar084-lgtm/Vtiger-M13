package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//*ListernersImplementation :* 



public class ListernersImplementation implements ITestListener {

	ExtentReports reports;
	ExtentTest test;
	JavaUtility jutil = new JavaUtility();
	String dateTimeStamp = jutil.getCalendarDetails("dd-MM-YY hh-mm-ss");

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "--- on test start executed");

		// create field on the empty report for every @Test
		test = reports.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "--- on test success executed");

		// logging the status as PASS
		test.log(Status.PASS, methodName + "- successfully executed ");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "--- on test failure executed");

		// logging the status as FAIL
		test.log(Status.FAIL, methodName + "- failed");
		test.log(Status.INFO, result.getThrowable());

		// screenshot of webpage
		String screenshotName = methodName + "-" + dateTimeStamp;
		SeleniumUtility sutil = new SeleniumUtility();
		try {
			String path = sutil.takeWebpageScreenshot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "--- on test skipped executed");

		// logging the status as SKIP
		test.log(Status.SKIP, methodName + "- Skipped");

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(" on  start executed");

		// configuration of extend report
		ExtentSparkReporter reporter = new ExtentSparkReporter(".\\ExtentReports\\report -" + dateTimeStamp + ".html");
		reporter.config().setDocumentTitle("Extent Reports");
		reporter.config().setReportName("VTiger Report");
		reporter.config().setTheme(Theme.STANDARD);

		// generate an empty report
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Base OS", "Windows");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base browser", "Chrome");
		reports.setSystemInfo("Test Engineer", "kaviya");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" on finish executed");

		// flushing the report
		reports.flush();
	}

}

