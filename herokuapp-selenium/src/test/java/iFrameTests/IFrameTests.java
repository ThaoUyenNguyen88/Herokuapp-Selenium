package iFrameTests;

import org.testng.annotations.Test;

import base.TestUtilities;
import page.HomePage;
import page.IframePage;

public class IFrameTests extends TestUtilities{
	
	@Test 
	public void IFrameTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		IframePage iframePage = homePage.clickIframeLink();
		iframePage.typeIntoIframe("hello123");
		sleep(3000);
		
	}

}
