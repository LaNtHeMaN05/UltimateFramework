package mobilePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ApiDemosPreferencePage {
	
	public WebDriver driver;
	
	public ApiDemosPreferencePage(AppiumDriver driver) {
		this.driver=driver;
	}

	private By prefDependencies=AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']");
	
	public WebElement prefDepClick() {
		return driver.findElement(prefDependencies);
	}
}
