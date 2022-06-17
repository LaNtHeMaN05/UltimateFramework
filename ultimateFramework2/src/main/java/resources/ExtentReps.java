package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReps {
	
	public ExtentReports extent;
	
	public ExtentReports getReports() {
		
		String directoryPath = System.getProperty("user.dir");
		String reportDest=directoryPath +"\\reports\\index.html";
		ExtentSparkReporter esr=new ExtentSparkReporter(reportDest);
		
		esr.config().setDocumentTitle("Testing by Lan");
		
		extent=new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("SDET", "LAN");
		return extent;
	}

}
