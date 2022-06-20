package webAutomation;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import resources.WebBaseClass;
import webPageObjects.NALHomePage;
import webPageObjects.NALLoggedHomePage;
import webPageObjects.NALLoginPage;

public class naveenAutomationLabsTest extends WebBaseClass{
	
	public static WebDriver driver;
	Logger log=LogManager.getLogger(naveenAutomationLabsTest.class.getName());
	
	
	@BeforeTest
	public void driverIn() throws IOException {
		driver=WebdriverStart();
		log.info("Driver initiated");
		
	}
	
	@Test
	public void nalTest1() throws InterruptedException {
		driver.get(naveenAutoUrl);
		System.out.println(driver.getTitle());
		log.info("Naveen Automation labs launched");
		
		NALHomePage nhp=new NALHomePage(driver);
		nhp.myAccount().click();
		nhp.loginDropDown().click();
		
		NALLoginPage nlp=new NALLoginPage(driver);
		nlp.loginEmail().sendKeys("lanaaroon5@gmail.com");
		nlp.loginPassword().sendKeys("Lan12");
		nlp.loginButton().click();
		nlp.homoLogoButton().click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		NALLoggedHomePage nall=new NALLoggedHomePage(driver);
		
		for(int i=0;i<nall.homeProductsList().size();i++) {
			js.executeScript("window.scrollBy(0,500)");
			nall.homeProdsikesList().get(i).click();
		}
		
		
	}

}
