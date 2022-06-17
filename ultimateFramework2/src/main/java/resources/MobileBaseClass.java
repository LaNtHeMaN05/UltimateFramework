package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class MobileBaseClass {
	public static AppiumDriver driver;
	public static AppiumDriverLocalService service;
	
	public String userDir=System.getProperty("user.dir");
	
	public ProcessBuilder pb;
	
	
	public String directoryPath = System.getProperty("user.dir");
	public String webAutomationUrl;
	public String browser;
	public FileInputStream fis;
	public Properties prop;

	public AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunnning(4723);

		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
			
		}
		return service;
	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	@SuppressWarnings("deprecation")
	public void startEmulator() throws IOException, InterruptedException {
//		pb=new ProcessBuilder(userDir+"\\src\\main\\java\\resources\\startEmulator - Shortcut.bat");
//		pb.start();
		Runtime.getRuntime().exec("cmd /c start startEmulator.bat");
		Thread.sleep(3);
	}
	
	@SuppressWarnings("deprecation")
	public void killNodes() throws IOException, InterruptedException {
		
//		pb=new ProcessBuilder(userDir+"\\src\\main\\java\\resources\\killNode.bat");
//		pb.start();
		Runtime.getRuntime().exec("cmd /c start killNode.bat");
		Thread.sleep(3);
		
	}
	
	public AppiumDriver mobileWebDriverStart(String appN) throws IOException {
		
		fis=new FileInputStream(directoryPath+"\\src\\main\\java\\data.properties");
		
		prop=new Properties();
		prop.load(fis);
		
		String appName=prop.getProperty(appN);
		System.out.println(appName);
		
		File appDir=new File("src");
		File app=new File(appDir, "ApiDemos-debug.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 30");
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	public String mobileTakeScreenshot(String methodName) throws IOException {
		TakesScreenshot wts=(TakesScreenshot) driver;
		File source=wts.getScreenshotAs(OutputType.FILE);
		String dest = directoryPath + "\\reports\\" + methodName + ".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}

}
