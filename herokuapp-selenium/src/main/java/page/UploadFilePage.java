package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFilePage extends BasePageObject{

	@FindBy (id = "file-upload")
	WebElement chooseFileElement;
	@FindBy (id = "file-submit")
	WebElement uploadBtn;
	@FindBy (id = "uploaded-files")
	WebElement fileNameText;
	
	public UploadFilePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	//upload File
	public void uploadFile(String path) {
		chooseFileElement.sendKeys(path);
		uploadBtn.click();
	}
	
	//get file name text
	public String getFileName() {
		return fileNameText.getText();
	}
}
