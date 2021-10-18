package loginTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestUtilities;
import page.HomePage;
import page.LoginPage;
import page.SecureAreaPage;

public class PositiveLoginTests extends TestUtilities{
	
	@Parameters({ "username", "password"})
	@Test
	public void PositiveTests(String username, String password) {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		
		LoginPage loginPage = homePage.clickLogInLink();
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);
		
		Assert.assertTrue(secureAreaPage.getMessageText().contains("You logged into a secure area!"), "Message doesn't contain expected text.");
		
	}

}
