package com.saucedemo.commons;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.saucedemo.pages.TestPageHandler;

public class Screemshot extends TestPageHandler{
	
	public static String getBase64Image() {
		
	String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	return screenshot;
	
	}

}
