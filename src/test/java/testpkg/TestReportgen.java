package testpkg;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basepkg.Baseclassopenherbals;
import pagepkg.Reportgenpage;

public class TestReportgen extends Baseclassopenherbals {
	ExtentSparkReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void beforeSetUp()
	{
		reporter = new ExtentSparkReporter("./Reports/RishiHerbals.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Testername", "Finita");
		extent.setSystemInfo("Browser name", "Chrome");
	}
	
	@Test(priority = 1)
	public void verifyPersonalTab()
	{
		test = extent.createTest("Personal Tab Verification");
		Reportgenpage objPersonal = new Reportgenpage(driver);
		objPersonal.selectPersonalTab();
	}
	
	@Test(priority = 2)
	public void verifyTxtPrdctAvailability()
	{
		test = extent.createTest("Product Availability Text Verification");
		Reportgenpage objprdctAvail = new Reportgenpage(driver);
		objprdctAvail.textProductAvailability();
	}
	
	@Test(priority = 3)
	public void verifyCheckBocClick()
	{
		test = extent.createTest("CheckBox Verification");
		Reportgenpage objCheckBox = new Reportgenpage(driver);
		objCheckBox.chckBoxClick();
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
	}
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test case failed is" + result.getName());
			test.log(Status.FAIL, "Test case failed is" + result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case skipped is" + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case Passed is" + result.getName());
		}
	}
}
