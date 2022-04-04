package com.saucedemo.commons;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.saucedemo.pages.TestPageHandler;

public class ExtentLogger extends TestPageHandler{
	
	
	private ExtentLogger() {}
	
	public static void info(String message) {
		
		logger.info(message);
	}
	
	public static void pass(String Message) {
		logger.pass(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(Screemshot.getBase64Image()).build());
	}
	
	public static void fail(String message) {
		logger.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(Screemshot.getBase64Image()).build());
	}

}
