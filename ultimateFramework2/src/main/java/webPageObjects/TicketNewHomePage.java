package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketNewHomePage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "Chennai")
	private WebElement city;
	
	public TicketNewHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement clickCity() {
		return city;
	}

}
