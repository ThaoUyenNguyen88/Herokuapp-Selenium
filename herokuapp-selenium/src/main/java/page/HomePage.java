package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageObject {

	String HomePageUrl = "http://the-internet.herokuapp.com/";
	@FindBy(linkText = "JavaScript Alerts")
	WebElement AlertLink;
	@FindBy(linkText = "Multiple Windows")
	WebElement multiWindowsLink;
	@FindBy(linkText = "File Upload")
	WebElement uploadFileLink;
	@FindBy(linkText = "File Download")
	WebElement downloadFileLink;
	@FindBy(linkText = "Frames")
	WebElement frameLink;
	@FindBy(linkText = "iFrame")
	WebElement iFrameLink;

	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	// open Home Page Url
	public void openHomePageUrl() {
		log.info("Open url: " + HomePageUrl);
		openUrl(HomePageUrl);
	}

	// click alert link
	public AlertPage clickAlertLink() {
		log.info("Open Alert Page");
		AlertLink.click();
		return new AlertPage(driver, log);
	}

	// click multiple windows link
	public MultipleWindowsPage clickMultiWinDowsLink() {
		log.info("Open Multiple Windows Page");
		multiWindowsLink.click();
		return new MultipleWindowsPage(driver, log);
	}

	// click file upload link
	public UploadFilePage clickUploadFileLink() {
		log.info("Open Upload File Page");
		uploadFileLink.click();
		return new UploadFilePage(driver, log);
	}

	// click file download link
	public DownloadFilePage clickDownloadFileLink() {
		log.info("Open Download File Page");
		downloadFileLink.click();
		return new DownloadFilePage(driver, log);
	}

	// click iframe link
	public IframePage clickIframeLink() {
		log.info("Open Iframe Page");
		frameLink.click();
		iFrameLink.click();
		return new IframePage(driver, log);
	}
}