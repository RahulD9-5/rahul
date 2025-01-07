package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportObject {
	
	public static ExtentReports createReportObject() {
       String path = System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Testing Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
