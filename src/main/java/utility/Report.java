package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
public static ExtentReports configureReports() {
		
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("extentReports.html");
		ExtentReports extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("TestType", "Regression");
		extentReports.setSystemInfo("Application", "Naptol");
		extentReports.setSystemInfo("Author", "Prashant");
		return extentReports;
		
	}

}
