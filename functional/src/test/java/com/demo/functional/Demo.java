package com.demo.functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("www.google.com");
	}
	
	@Test
	public void googlesearch() {
		
	}
	
	@AfterTest
	public void closeBrowser() {
//		driver.quit();
	}

}
