package downloadFileTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestUtilities;
import page.DownloadFilePage;
import page.HomePage;

public class DownloadFileTests extends TestUtilities{

	private static String downloadPath = "C:\\Users\\uyenttnguyen\\Desktop\\hello";
	
	@Test
	public void downLoadFileTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		DownloadFilePage downloadFilePage = homePage.clickDownloadFileLink();
		downloadFilePage.downloadFile();
		sleep(3000);
		Assert.assertTrue(downloadFilePage.isFileDownloaded(downloadPath, "some-file.txt"), "Failed to download Expected document");
		sleep(3000);
		
	}
	
}
