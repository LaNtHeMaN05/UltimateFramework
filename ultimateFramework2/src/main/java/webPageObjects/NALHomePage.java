package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NALHomePage {
	
	public WebDriver driver;

	@FindBy(css=".caret")
	private WebElement myAcc;
	
	@FindBy(xpath = "//ul[@class='list-inline']/li[2]/ul/li[2]")
	private WebElement login;
	
	public NALHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement myAccount() {
		return myAcc;
	}
	
	public WebElement loginDropDown() {
		return login;
	}
	
}
