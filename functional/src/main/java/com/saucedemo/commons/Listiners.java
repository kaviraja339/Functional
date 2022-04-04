package com.saucedemo.commons;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.saucedemo.pages.TestPageHandler;

public class Listiners implements ITestListener{
	
	TestPageHandler tph = new TestPageHandler();
	
	@Override
	public void onTestStart(ITestResult result) {
		tph.logger = tph.extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		tph.logger.log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is passed successfully");
	}
	
	@Override
	public void onStart(ITestContext context) {
		tph.extent = ExtentReportSetup.setupExtentReport();
	}
	
	@Override
	public void onFinish(ITestContext context) {
		tph.extent.flush();
	}

}
