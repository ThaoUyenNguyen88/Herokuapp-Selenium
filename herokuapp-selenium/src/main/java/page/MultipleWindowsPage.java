package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowsPage extends BasePageObject{

	@FindBy (xpath = "//*[@id=\"content\"]/div/a")
	WebElement clickHereBtn;
	
	@FindBy (xpath = "/html/body/div/h3")
	WebElement newTabText;
	
	public MultipleWindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	//open new window
	public void openNewTab() {
		clickHereBtn.click();
		switchToWindowWithTitle("New Window");
		
	}
	
	//get new tab text
	public String getNewTabText() {
		return newTabText.getText();
	}
}
