package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

 public class ExtentReporter {
	
	static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport() {
		
		String extentReportPath = System.getProperty("user.dir")+"\\report\\extentreports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("Chiru report");
		reporter.config().setDocumentTitle("chiru document");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Window 10");
		extentReport.setSystemInfo("Tested by", "N. Chiranjeevi");
		return extentReport;
	}
}
