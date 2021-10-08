package downloadFileTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestUtilities;
import page.DownloadFilePage;
import page.HomePage;

public class DownloadFileTests extends TestUtilities {

	private static String downloadPath = "C:\\Users\\uyenttnguyen\\Desktop\\hello";

	@Test
	public void downLoadFileTest() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/Test-Report/DowloadFileTests/DowloadFileTests.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("DownloadFileTest", "Test function download file");

		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		test.pass("Navigate to the-internet.herokuapp.com");
		DownloadFilePage downloadFilePage = homePage.clickDownloadFileLink();
		downloadFilePage.downloadFile();
		sleep(3000);
		test.pass("Click file and download");
		Assert.assertTrue(downloadFilePage.isFileDownloaded(downloadPath, "some-file.txt"),
				"Failed to download Expected document");
		test.pass("Compare file downloaded be in folder");
		sleep(3000);
		test.pass("Close browser");
		test.info("Test Completed");
		extent.flush();

	}

}
