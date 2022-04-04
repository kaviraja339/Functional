package com.saucedemo.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ExcelUtil;

public class TC_001_Customer_Login extends BaseTest{
	
	@Test
	public void Verify_TC_001_Customer_Login() throws IOException {
		
		LoginPage login = new LoginPage(driver);
		
		Map<String, String[]> map = ExcelUtil.readdata();
		
		login
		.Enter_UserName(map.get("Username")[0])
		.Enter_Password(map.get("Password")[0])
		.Click_Login_Button();	
		
	}

}
