package loginTests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.CsvDataProviders;
import base.TestUtilities;
import page.HomePage;
import page.LoginPage;

public class NegativeLogInTests extends TestUtilities{

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTest(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username  = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLogInTest #" + no + " for " + description);
		
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		
		LoginPage loginPage = homePage.clickLogInLink();

		loginPage.negativeLogIn(username, password);

		String message = loginPage.getErrorMessage();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
}
	

