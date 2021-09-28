package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePageObject{

	@FindBy (xpath = "//*[@id=\"tinymce\"]")
	WebElement iFrameTxt;
	
	@FindBy (xpath = "//*[@id=\"tinymce\"]/p")
	WebElement iFrameTxt2;
	
	public IframePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	//type into iframe
	public void typeIntoIframe(String text) {
		driver.switchTo().frame("mce_0_ifr");
		iFrameTxt.clear();
		iFrameTxt.sendKeys(text);
	}
}
