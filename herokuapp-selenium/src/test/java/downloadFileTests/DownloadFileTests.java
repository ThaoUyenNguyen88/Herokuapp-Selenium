package downloadFileTests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestUtilities;
import page.DownloadFilePage;
import page.HomePage;
import org.apache.log4j.*;

public class DownloadFileTests extends TestUtilities {

	private static String downloadPath = "C:\\Users\\uyenttnguyen\\Desktop\\hello";

	@Test
	public void downLoadFileTest() {
		
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("DownloadFileTest.html");
		    
	        // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("DownloadFileTest", "Test function download file");
		
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		test.pass("Navigate to the-internet.herokuapp.com");
		DownloadFilePage downloadFilePage = homePage.clickDownloadFileLink();
		downloadFilePage.downloadFile();
		sleep(3000);
		test.pass("Click file and download");
		Assert.assertTrue(downloadFilePage.isFileDownloaded(downloadPath, "some-file.txt"), "Failed to download Expected document");
		test.pass("Compare file downloaded be in folder");
		sleep(3000);
		test.pass("Close browser");
		test.info("Test Completed");
		
		// calling flush writes everything to the log file
        extent.flush();
		
	}

}
