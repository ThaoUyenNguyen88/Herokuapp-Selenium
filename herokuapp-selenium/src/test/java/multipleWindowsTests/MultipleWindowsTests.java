package multipleWindowsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestUtilities;
import page.HomePage;
import page.MultipleWindowsPage;

public class MultipleWindowsTests extends TestUtilities{

	@Test
	public void newTab() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/Test-Report/MultipleWindowsTests/MultipleWindowsTest.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("MultipleWindowsTest", "Test function open new tab");
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		test.pass("Navigate to the-internet.herokuapp.com");
		MultipleWindowsPage multiWin = homePage.clickMultiWinDowsLink();
		test.pass("Navigate to Multiple WinDows page");
		multiWin.openNewTab();
		test.pass("Open new tab");
		Assert.assertTrue(multiWin.getNewTabText().equals("New Window"));
		test.pass("Compare text in new tab");
		test.pass("Close browser");
		test.info("Test Completed");
		extent.flush();
	}
	
}
