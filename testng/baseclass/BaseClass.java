package testng.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.ReadExcel;

public class BaseClass {

	// declare a excelFileName
	public String excelFileName;
	// declare a ExtentReports
	public static ExtentReports extent;
	// declare a ExtentTest
	public static ExtentTest test;
	// declare test details
	public   String testName, testDescription, testCategory, testAuthor;
	// create a object for ThreadLocal of type RemoteWebDriver
	private static final ThreadLocal<RemoteWebDriver> rd = new ThreadLocal<RemoteWebDriver>();

	protected void setMethod() {
		rd.set(new ChromeDriver());

	}

	protected RemoteWebDriver getMethod() {
		return rd.get();
	}

	@BeforeSuite
	public void startReport() {
		// set the path
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}
	@BeforeClass
	public void testDetails() {
		test=extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);

	}

	public int takeSnap() throws IOException {
		int ranNum = (int) (Math.random() * 9999);
		File source = getMethod().getScreenshotAs(OutputType.FILE);
		File des = new File("./Snaps/img" + ranNum + ".png");
		FileUtils.copyFile(source, des);
		return ranNum;

	}

	@BeforeMethod
	public void preCondition() {
		setMethod();
		getMethod().get("http://leaftaps.com/crmsfa/control/main");
		getMethod().manage().window().maximize();
		getMethod().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterMethod
	public void postCondition() {
		// getMethod().close();
	}
	public void reportStep(String msg,String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			test.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/img"+takeSnap()+".png").build());	
		}
		else if(status.equalsIgnoreCase("fail")) {
			test.fail(msg, MediaEntityBuilder.createScreenCaptureFromPath("../Snaps./img"+takeSnap()+".png").build());
		}

	}
	
	@DataProvider(name = "fetch")
	public String[][] fetchData() throws IOException {
		return ReadExcel.excelData(excelFileName);
	}
	@AfterSuite
	public void stopReport() {
		extent.flush();

	}
	
}
