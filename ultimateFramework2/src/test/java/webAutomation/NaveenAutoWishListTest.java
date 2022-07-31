package webAutomation;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.WebBaseClass;
import webPageObjects.NALHomePage;
import webPageObjects.NALLoggedHomePage;
import webPageObjects.NALLoginPage;
import webPageObjects.NALWishListPage;

public class NaveenAutoWishListTest extends WebBaseClass {
	
	public static WebDriver driver;
	Logger log=LogManager.getLogger(NaveenAutoWishListTest.class.getName());
	
	
	@BeforeTest
	public void driverInt() throws IOException {
		driver=WebdriverStart();
		log.info("Driver Initialized");
	}
	
	@Test
	public void wishListTest() throws InterruptedException {
		driver.get(naveenAutoUrl);
		NALHomePage nhp=new NALHomePage(driver);
		nhp.myAccount().click();
		nhp.loginDropDown().click();
		
		NALLoginPage nlp=new NALLoginPage(driver);
		nlp.loginEmail().sendKeys("lanaaroon5@gmail.com");
		nlp.loginPassword().sendKeys("Lan12");
		nlp.loginButton().click();
		nlp.homoLogoButton().click();
		
		NALLoggedHomePage nlhp=new NALLoggedHomePage(driver);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		for(int i=0;i<nlhp.homeProductsList().size();i++) {
			js.executeScript("window.scrollBy(0,500)");
			nlhp.homeProdsikesList().get(i).click();
		}
		nlhp.wishListBtnClick().click();
		
		NALWishListPage nwlp=new NALWishListPage(driver);
		

		
		
		List<String> ActualProdNames=new ArrayList<>();
		ActualProdNames.add("Canon EOS 5D");
		ActualProdNames.add("iPhone");
		ActualProdNames.add("Apple Cinema 30\"");
		ActualProdNames.add("MacBook");

		
		List<String> ExistingProdNames=new ArrayList<>();
		
		List<WebElement> prodsToCart=nwlp.addWishedtoCart();
		List<WebElement> prodNames= nwlp.getWishedProdNames();
		List<WebElement> deleteWished=nwlp.deleteFromWish();
		for(int i=0;i<prodNames.size();i++) {
			ExistingProdNames.add(prodNames.get(i).getText());
			System.out.println(prodNames.get(i).getText());
		}
		
		//Assert.assertEquals(ActualProdNames, ExistingProdNames);
		for(int i=0;i<prodNames.size();i++) {
			if(prodNames.get(i).getText().equalsIgnoreCase("Canon EOS 5D")) {
				Thread.sleep(1000);
				deleteWished.get(i).click();
				System.out.println("Canon delete");
			}
			if(prodNames.get(i).getText().equalsIgnoreCase("Apple Cinema 30\"")) {
				deleteWished.get(i).click();
			}
		}
		
		for(int i=0;i<prodsToCart.size();i++) {
			prodsToCart.get(i).click();
		}
	}

}
