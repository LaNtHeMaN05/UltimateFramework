package mobilePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ApiDemosHomePage {
	
	public WebDriver driver;
	
	public ApiDemosHomePage(AppiumDriver driver) {
		this.driver=driver;
	}

	private By peference=AppiumBy.xpath("//android.widget.TextView[@text='Preference']");
	
	public WebElement peferenceClick() {
		return driver.findElement(peference);
	}
	
}
