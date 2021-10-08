package iFrameTests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestUtilities;
import page.HomePage;
import page.IframePage;

public class IFrameTests extends TestUtilities{
	
	@Test 
	public void IFrameTest() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/Test-Report/IFrameTests/IFrameTests.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("IFrameTests", "Test function type into Irame");
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		test.pass("Navigate to the-internet.herokuapp.com");
		IframePage iframePage = homePage.clickIframeLink();
		test.pass("Navigate to IFrame page");
		iframePage.typeIntoIframe("hello123");
		test.pass("Type hello123 to Iframe");
		sleep(3000);
		test.pass("Close browser");
		test.info("Test Completed");
		extent.flush();

		
	}

}
