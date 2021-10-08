package alertTests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestUtilities;
import page.AlertPage;
import page.HomePage;
import page.MultipleWindowsPage;


public class AlertTests extends TestUtilities{
	
	@Test
	public void JSAlertTest() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Test-Report/AlertTests/JSAlertTest.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("JSAlertTest", "Test JS Alert");
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		test.pass("Navigate to the-internet.herokuapp.com");
		AlertPage alertPage = homePage.clickAlertLink();
		test.pass("Navigate to Alert Page");
		alertPage.clickJSAlertBtn();
		test.pass("Click JS button");
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS Alert"));
		test.pass("Compare Alert text");
		alertPage.acceptAlert();
		test.pass("Click Alert Ok button");
		Assert.assertTrue(alertPage.getAlertResult().equals("You successfully clicked an alert"));
		test.pass("Compare text after close Alert");
		test.pass("Close browser");
		test.info("Test Completed");
		extent.flush();
	}
	
	@Test
	public void JSConfirmAcceptTest() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Test-Report/AlertTests/JSConfirmAcceptTest.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("JSConfirmAcceptTest", "Test JS Confirm Accept Alert");
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		test.pass("Navigate to the-internet.herokuapp.com");
		AlertPage alertPage = homePage.clickAlertLink();
		test.pass("Navigate to Alert Page");
		alertPage.clickJSConfirmBtn();
		test.pass("Click JS Confirm button");
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS Confirm"));
		test.pass("Compare Alert text");
		alertPage.acceptAlert();
		test.pass("Click Alert Ok button");
		Assert.assertTrue(alertPage.getAlertResult().equals("You clicked: Ok"));
		test.pass("Compare text after close Alert");
		test.pass("Close browser");
		test.info("Test Completed");
		extent.flush();
	}
	
	@Test
	public void JSConfirmDismissTest() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Test-Report/AlertTests/JSConfirmDismissTest.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("JSConfirmAcceptTest", "Test JS Confirm Dismiss Alert");
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePageUrl();
		AlertPage alertPage = homePage.clickAlertLink();
		alertPage.clickJSConfirmBtn();
		alertPage.getAlertText();
		Assert.assertTrue(alertPage.getAlertText().equals("I am a JS Confirm"));
		alertPage.dimissAlert();
		test.pass("Click Alert Cancel button");
		Assert.assertTrue(alertPage.getAlertResult().equals("You clicked: Cancel"));
		test.pass("Compare text after close Alert");
		test.pass("Close browser");
		test.info("Test Completed");
		extent.flush();
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
