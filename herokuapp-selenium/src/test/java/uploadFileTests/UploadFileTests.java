package uploadFileTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestUtilities;
import page.HomePage;
import page.UploadFilePage;

public class UploadFileTests extends TestUtilities{

	@Test
	public void UploadFileTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		UploadFilePage uploadFilePage = homePage.clickUploadFileLink();
		uploadFilePage.uploadFile("C:\\Users\\uyenttnguyen\\Desktop\\Squad 1 Sanofi\\info.txt");
		Assert.assertTrue(uploadFilePage.getFileName().equals("info.txt"));
		sleep(6000);
	}
	
}
