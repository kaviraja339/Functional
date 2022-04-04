package com.saucedemo.testcases;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.saucedemo.pages.TestPageHandler;
import com.saucedemo.utilities.ConfigUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends TestPageHandler{
	
	@BeforeSuite
	public void startReport() {
	}
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		String Executiontype = ConfigUtil.getpropertyvalue("EXECUTION").toLowerCase();
		System.out.println(Executiontype);
		String browser = ConfigUtil.getpropertyvalue("BROWSER").toLowerCase();
		System.out.println(browser);
		if(Executiontype.equalsIgnoreCase("local"))
		{		
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("Something went wrong can't able to initiate the browser");
			}
		}
		else if(Executiontype.equalsIgnoreCase("grid"))
		{
			DesiredCapabilities dr1 = new DesiredCapabilities();
			dr1.setCapability("browserName", browser);
			dr1.setCapability("platformName", Platform.LINUX);
			driver = new RemoteWebDriver(new URL(ConfigUtil.getpropertyvalue("DOCKER-GIRD")), dr1);
			System.out.println(browser);
			System.out.println(ConfigUtil.getpropertyvalue("DOCKER-GIRD"));
		}	

		driver.get(ConfigUtil.getpropertyvalue("ApplicationURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@AfterSuite
	public void CloseReport() {
	}

}
