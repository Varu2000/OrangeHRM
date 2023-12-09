package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_report {

public static ExtentReports getReport() {
		
		ExtentSparkReporter report = new ExtentSparkReporter("./Reports/TestReport.html");
		ExtentReports extntReport = new ExtentReports();
		extntReport.attachReporter(report);
		return extntReport;
	}
}
