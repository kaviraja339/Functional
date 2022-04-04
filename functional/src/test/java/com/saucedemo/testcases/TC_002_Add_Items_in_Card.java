package com.saucedemo.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ExcelUtil;

public class TC_002_Add_Items_in_Card extends BaseTest{
	
	@Test
	public void verify_TC_002_Add_Items_in_Card() throws IOException {

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);

		Map<String, String[]> map = ExcelUtil.readdata();

		login
		.Enter_UserName(map.get("Username")[1])
		.Enter_Password(map.get("Password")[1])
		.Click_Login_Button();
		
		home
		.Verify_HomePage()
		.Add_Red_TShirt_in_Cards();
	}

}
