package downloadFileTests;

import org.testng.annotations.Test;

import base.TestUtilities;
import page.DownloadFilePage;
import page.HomePage;

public class DownloadFileTests extends TestUtilities{

	@Test
	public void downLoadFileTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		DownloadFilePage downloadFilePage = homePage.clickDownloadFileLink();
		downloadFilePage.downloadFile();
		sleep(3000);
	}
	
}
