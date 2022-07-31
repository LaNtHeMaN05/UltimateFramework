package webPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class NALLoggedHomePage {
	
	public WebDriver driver;
	
	@FindBys(@FindBy(xpath="//div[@class='row']/div[@class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12']"))
	private List<WebElement> homeProducts;
	
	@FindBys(@FindBy(xpath="//div[@class='row']/div[@class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12']/div/div/button/i[@class='fa fa-heart']"))
	private List<WebElement> homeProdsLikes;
	
	@FindBy(xpath = "//i[@class='fa fa-check-circle']")
	private WebElement successMsg;
	
	@FindBy(xpath ="//ul/li/a/span[contains(text(),'Wish List')]")
	private WebElement wishListBtn;
	
	public NALLoggedHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> homeProductsList() {
		return homeProducts;
	}
	
	public List<WebElement> homeProdsikesList() {
		return homeProdsLikes;
	}
	
	public WebElement successMsgElement() {
		return successMsg;
	}
	
	public WebElement wishListBtnClick() {
		return wishListBtn;
	}

}
