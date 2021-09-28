package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadFilePage extends BasePageObject{

	@FindBy (xpath = "//*[@id=\"content\"]/div/a[1]")
	WebElement file1;
	
	public DownloadFilePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	//Download File
	public void downloadFile() {
		file1.click();
	}

}
