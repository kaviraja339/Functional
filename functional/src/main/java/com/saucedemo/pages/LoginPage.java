package com.saucedemo.pages;


import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.saucedemo.utilities.ExcelUtil;



public class LoginPage extends TestPageHandler{
	
	
	
	@FindBy(id = "user-name") WebElement Username_Textbox;
	@FindBy(id = "password") WebElement Password_Textbox;
	@FindBy(id = "login-button") WebElement Login_Button;
	@FindBy(xpath = "//h3[@data-test='error']") WebElement Locked_Out_User_Error;

//	private By Username_Textbox = By.id("user-name");
//	private By Password_Textbox = By.id("password");
//	private By Login_Button = By.id("login-button");
	
	Map<String, String[]> map = ExcelUtil.readdata();
	
	public LoginPage(WebDriver driver)throws IOException{
		driver = TestPageHandler.driver;
		PageFactory.initElements(driver, this);	
	}
	
	public LoginPage Enter_UserName(String Username) {
		if(Username_Textbox.isDisplayed() && Username_Textbox.isEnabled()) 
		{
			Username_Textbox.sendKeys(Username);
			logger.log(Status.PASS, "User entered the ["+Username+"] in Username textbox successfully");
			
			
		}
		else
		{
			logger.log(Status.FAIL, "Something went wrong can't able to enter the value in username textbox");
		}
		
		return this;
	}
	
	
	public LoginPage Enter_Password(String Password) {
		if(Password_Textbox.isDisplayed() && Password_Textbox.isEnabled()) 
		{
			
			Password_Textbox.sendKeys(Password);
			logger.log(Status.PASS, "User entered the ["+Password+"] in Psssword textbox successfully");
		}
		else
		{
			logger.log(Status.FAIL, "Something went wrong can't able to enter the value in Password textbox");
		}
		
		return this;	
	}

	public LoginPage Click_Login_Button() {
		if(Login_Button.isDisplayed() && Login_Button.isEnabled())
		{
			Login_Button.click();
			logger.log(Status.PASS, "User Clicked on login Button successfully");
		}
		else
		{
			logger.log(Status.FAIL, "Something went wrong can't able to click on login Button");
		}
		return this;
	}
	
	public LoginPage Verify_Locked_Out_User_Error_Msg() {
		
		String actual = Locked_Out_User_Error.getText();
		String expect = "Epic sadface: Sorry, this user has been locked out.";
		
		if(expect.equals(actual))
		{
			logger.pass("For Locked out user it's showing the "+expect+"  error message");
		}
		else
		{
			logger.fail("For Locked out it's not showing the valid error. Instead of it's showing the following error message "+actual);
		}
		return this;
		
	}

}
