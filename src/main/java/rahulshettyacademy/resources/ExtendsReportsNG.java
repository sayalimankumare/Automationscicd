package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendsReportsNG {
	
	
	public void getReortObject()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "SAYALI MANLKUMARE");
		extent.createTest(path);
		}

	public static ExtentReports getReportObject() {
		// TODO Auto-generated method stub
		return null;
	}
	}

