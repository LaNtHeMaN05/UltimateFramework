package webAutomation;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.WebBaseClass;
import webPageObjects.TicketNewHomePage;

public class WebAutoTest1 extends WebBaseClass {
	
	public WebDriver driver;
	Logger log=LogManager.getLogger(WebAutoTest1.class.getName());
	
	@BeforeTest
	public void driverStart() throws IOException {
		driver=WebdriverStart();
		log.info("Driver and Logs initiated");
	}
	
	@Test
	public void WAT1() {
		driver.get(webAutomationUrl);
		log.info("Launching the website");
		System.out.println(driver.getTitle());
		TicketNewHomePage tnhp=new TicketNewHomePage(driver);
		tnhp.clickCity().click();
		log.info("TestCompleted");
		
	}
	

}
