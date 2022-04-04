package com.saucedemo.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.pages.TestPageHandler;

public class ExtentReportSetup extends TestPageHandler{

	public static ExtentReports setupExtentReport() {
		
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date date = new Date();
			String ReportDate = formatter.format(date);
			ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/ExtentReports "+ReportDate+".html");
			extent = new ExtentReports();
			extent.attachReporter(spark);

			spark.config().setDocumentTitle("Demo Automation Testing");
			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("practice");
			extent.attachReporter(spark);
			return extent;
		
	
	}

}
