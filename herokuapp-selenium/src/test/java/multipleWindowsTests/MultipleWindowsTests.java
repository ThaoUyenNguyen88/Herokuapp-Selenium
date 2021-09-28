package multipleWindowsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestUtilities;
import page.HomePage;
import page.MultipleWindowsPage;

public class MultipleWindowsTests extends TestUtilities{

	@Test
	public void newTab() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		MultipleWindowsPage multiWin = homePage.clickMultiWinDowsLink();
		multiWin.openNewTab();
		Assert.assertTrue(multiWin.getNewTabText().equals("New Window"));
	}
	
}
