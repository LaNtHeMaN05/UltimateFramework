package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NALLoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login;
	
	@FindBy(xpath = "//div[@id='logo']")
	private WebElement homeLogo;
	
	
	public NALLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement loginEmail() {
		return email;
	}
	
	public WebElement loginPassword() {
		return password;
	}
	
	public WebElement loginButton() {
		return login;
	}
	
	public WebElement homoLogoButton() {
		return homeLogo;
	}
	
}
