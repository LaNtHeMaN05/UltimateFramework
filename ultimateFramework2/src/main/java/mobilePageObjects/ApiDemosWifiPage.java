package mobilePageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ApiDemosWifiPage {

	private By wifiCheckBox = AppiumBy.id("android:id/checkbox");
	private By relativeLayoutList = AppiumBy.xpath("//android.widget.RelativeLayout");
	private By editText = AppiumBy.id("android:id/edit");
	private By okButton = AppiumBy.androidUIAutomator("text(\"OK\")");

	public WebDriver driver;

	public ApiDemosWifiPage(AppiumDriver driver) {
		this.driver = driver;
	}

	public WebElement wifiCheckBoxClick() {
		return driver.findElement(wifiCheckBox);

	}

	public List<WebElement> relativeLayoutListClick() {
		return driver.findElements(relativeLayoutList);
	}

	public WebElement editTestEnter() {
		return driver.findElement(editText);
	}

	public WebElement okButtonClick() {
		return driver.findElement(okButton);
	}

}
