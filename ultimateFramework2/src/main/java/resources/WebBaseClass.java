package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBaseClass {
	
	public static WebDriver driver;
	
	public String directoryPath = System.getProperty("user.dir");
	public String webAutomationUrl;
	public String browser;
	public FileInputStream fis;
	public Properties prop;
	
	public WebDriver WebdriverStart() throws IOException {
		
		
		fis=new FileInputStream(directoryPath+"\\src\\main\\java\\data.properties");
		
		prop=new Properties();
		prop.load(fis);
		browser=prop.getProperty("browser");
		webAutomationUrl=prop.getProperty("url");
		
		System.out.println(browser);
		System.out.println(webAutomationUrl);
		
		if(browser.equalsIgnoreCase("chrome"))
			driver=WebDriverManager.chromedriver().create();		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	public String webTakeScreenshot(String methodName, WebDriver driver) throws IOException {
		TakesScreenshot wts=(TakesScreenshot) driver;
		File source=wts.getScreenshotAs(OutputType.FILE);
		String dest = directoryPath + "\\reports\\" + methodName + ".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}
	

}
