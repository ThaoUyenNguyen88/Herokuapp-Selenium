package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject {

	@FindBy(id = "username")
	WebElement usernameTxt;
	@FindBy(id = "password")
	WebElement passwordTxt;
	@FindBy(xpath = "//*[@id=\"login\"]/button")
	WebElement logInBtn;
	private By errorMessage = By.id("flash");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public SecureAreaPage logIn(String usename, String password) {
		usernameTxt.sendKeys(usename);
		passwordTxt.sendKeys(password);
		logInBtn.click();
		return new SecureAreaPage(driver, log);
	}

	public void negativeLogIn(String usename, String password) {
		usernameTxt.sendKeys(usename);
		passwordTxt.sendKeys(password);
		logInBtn.click();
	}

	public String getErrorMessage() {
		waitForVisibilityOf(errorMessage, 5);
		return driver.findElement(errorMessage).getText();

	}

}
