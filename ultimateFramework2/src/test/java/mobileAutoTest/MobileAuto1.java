package mobileAutoTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import mobilePageObjects.ApiDemosHomePage;
import mobilePageObjects.ApiDemosPreferencePage;
import mobilePageObjects.ApiDemosWifiPage;
import resources.MobileBaseClass;

public class MobileAuto1 extends MobileBaseClass {
	
	public AppiumDriver driver;
	Logger log=LogManager.getLogger(MobileAuto1.class.getName());
	
	@BeforeTest
	public void serverStart() throws IOException, InterruptedException {
		startServer();
		Thread.sleep(2000);
	}
	
	@Test
	public void Testing1() throws InterruptedException, IOException {
		startEmulator();
		log.info("Emulator Started");
		Thread.sleep(5);
		
		driver=mobileWebDriverStart("appN");
		log.info("Mobile Driver Initiated");
		
		ApiDemosHomePage adHP=new ApiDemosHomePage(driver);
		adHP.peferenceClick().click();
		log.info("App Launched");
		
		ApiDemosPreferencePage adPP=new ApiDemosPreferencePage(driver);
		adPP.prefDepClick().click();
		
		ApiDemosWifiPage adWP=new ApiDemosWifiPage(driver);
		adWP.wifiCheckBoxClick().click();
		adWP.relativeLayoutListClick().get(1).click();
		adWP.editTestEnter().sendKeys("Hello");
		adWP.okButtonClick().click();
		log.info("Appium Test completed");

	}
	
	@AfterTest
	public void close() {
		stopServer();
	}

}
