package com.saucedemo.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ExcelUtil;

public class TC_004_Locked_Out_User extends BaseTest{

	@Test
	public void Verify_TC_004_Locked_Out_User() throws IOException {
		
		LoginPage login = new LoginPage(driver);

		Map<String, String[]> map = ExcelUtil.readdata();

		login
		.Enter_UserName(map.get("Username")[3])
		.Enter_Password(map.get("Password")[3])
		.Click_Login_Button()
		.Verify_Locked_Out_User_Error_Msg();

	}

}
