package com.saucedemo.pages;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebElement;

public class Verify extends TestPageHandler{
	
	
	public static void verify_page_title(String Expected, String Actual) {
		
		if(Expected.equals(Actual))
		{
			logger.pass("The User has been Navigated to "+Expected+" screen successfully");
		}
		else
		{
			logger.fail("Something went able to verify can't able to find the expected page. The current page title is "+ Actual);
		}
	}
	
	public static void click(String ElementName, WebElement element) {
		
		if(element.isDisplayed() && element.isEnabled())
		{
			element.click();
			logger.pass("The user has clicked on "+ElementName+" Successfully");
		}
		else
		{
			logger.fail("Something went wrong can't able to click on the"+ElementName);
		}
		
		
		
	}

}
