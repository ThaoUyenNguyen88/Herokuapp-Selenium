package alertTests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestUtilities;
import page.AlertPage;
import page.HomePage;
import page.MultipleWindowsPage;


public class AlertTests extends TestUtilities{
	
	@Test
	public void JSAlertTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		AlertPage alertPage = homePage.clickAlertLink();
		alertPage.clickJSAlertBtn();
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS Alert"));
		alertPage.acceptAlert();
		Assert.assertTrue(alertPage.getAlertResult().equals("You successfully clicked an alert"));
	}
	
	@Test
	public void JSConfirmAcceptTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		AlertPage alertPage = homePage.clickAlertLink();
		alertPage.clickJSConfirmBtn();
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS Confirm"));
		alertPage.acceptAlert();
		Assert.assertTrue(alertPage.getAlertResult().equals("You clicked: Ok"));
	}
	
	@Test
	public void JSConfirmDismissTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		AlertPage alertPage = homePage.clickAlertLink();
		alertPage.clickJSConfirmBtn();
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS Confirm"));
		alertPage.dimissAlert();
		Assert.assertTrue(alertPage.getAlertResult().equals("You clicked: Cancel"));
	}
	
	@Test
	public void JSPromptAcceptTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		AlertPage alertPage = homePage.clickAlertLink();
		alertPage.clickJSPromptBtn();
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS prompt"));
		String text = "hello123"; 
		alertPage.sendTextAlert(text);
		alertPage.acceptAlert();
		Assert.assertTrue(alertPage.getAlertResult().equals("You entered: "+text));
	}
	
	@Test
	public void JSPromptDismissTest() {
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		AlertPage alertPage = homePage.clickAlertLink();
		alertPage.clickJSPromptBtn();
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS prompt"));
		String text = "hello123"; 
		alertPage.sendTextAlert(text);
		alertPage.dimissAlert();
		Assert.assertTrue(alertPage.getAlertResult().equals("You entered: null"));
	}
	


}
