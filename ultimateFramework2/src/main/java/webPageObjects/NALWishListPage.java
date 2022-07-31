package webPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class NALWishListPage {
	
	public WebDriver driver;
	
	
	
	@FindBys(@FindBy(xpath = "//table/tbody/tr/td[@class='text-left']/a"))
	private List<WebElement> prodsNames;
	
	@FindBys(@FindBy(xpath = "//div/table/tbody/tr/td/button"))
	private List<WebElement> addCartWish;
	
	@FindBys(@FindBy(xpath = "//div/table/tbody/tr/td/a[@class='btn btn-danger']"))
	private List<WebElement> deleteCart;
	
	public NALWishListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getWishedProdNames() {
		return prodsNames;
	}
	
	public List<WebElement> addWishedtoCart() {
		return addCartWish;
	}
	
	public List<WebElement> deleteFromWish() {
		return deleteCart;
	}

}
