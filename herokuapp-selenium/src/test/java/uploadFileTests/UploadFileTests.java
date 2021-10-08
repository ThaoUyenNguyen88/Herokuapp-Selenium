package uploadFileTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestUtilities;
import page.HomePage;
import page.UploadFilePage;

public class UploadFileTests extends TestUtilities{

	@Test
	public void UploadFileTest() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/Test-Report/UploadFileTests/UploadFileTest.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("UploadFileTest", "Test function upload file");
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		test.pass("Navigate to the-internet.herokuapp.com");
		UploadFilePage uploadFilePage = homePage.clickUploadFileLink();
		test.pass("Navigate to upload file page");
		uploadFilePage.uploadFile("D:\\info.txt");
		test.pass("Upload File info.txt");
		Assert.assertTrue(uploadFilePage.getFileName().equals("info.txt"));
		test.pass("Compare file uploaded");
		sleep(6000);
		test.pass("Close browser");
		test.info("Test Completed");
		extent.flush();
	}
	
}
