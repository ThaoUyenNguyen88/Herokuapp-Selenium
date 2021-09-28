package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AlertPage extends BasePageObject{
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/ul/li[1]/button")
	WebElement JSAlertBtn;
	@FindBy (xpath = "//*[@id=\"content\"]/div/ul/li[2]/button")
	WebElement JSConfirmBtn;
	@FindBy (xpath = "//*[@id=\"content\"]/div/ul/li[3]/button")
	WebElement JSPromptBtn;
	@FindBy (id = "result")
	WebElement AlertResult;

	public AlertPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	//Click JS Alert button
	public void clickJSAlertBtn() {
		JSAlertBtn.click();
	}
	
	//Click JS Confirm button
	public void clickJSConfirmBtn() {
		JSConfirmBtn.click();
	}
	//Click JS Prompt
	public void clickJSPromptBtn() {
		JSPromptBtn.click();
	}
	
	//Get Alert Text 
	public String getAlertText() {
		Alert alert = switchToArlet();
		return alert.getText();
	}
	//Get Alert result
	public String getAlertResult() {
		return AlertResult.getText();
	}
	
	//Send text to alert
	public void sendTextAlert(String text) {
		Alert alert = switchToArlet();
		alert.sendKeys(text);
	}
	
	//Accept Alert
	public void acceptAlert() {
		Alert alert = switchToArlet();
		alert.accept();
	}
	
	//Dimiss Alert
	public void dimissAlert() {
		Alert alert = switchToArlet();
		alert.dismiss();
	}
	
}
