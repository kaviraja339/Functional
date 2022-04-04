package com.saucedemo.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ExcelUtil;

public class TC_003_Standard_User_Add_Multiple_items_in_Card extends BaseTest{
	
	@Test
	public void Verify_TC_003_Standard_User_Add_Multiple_items_in_Card() throws IOException, InterruptedException {
	LoginPage login = new LoginPage(driver);
	HomePage home = new HomePage(driver);

	Map<String, String[]> map = ExcelUtil.readdata();

	login
	.Enter_UserName(map.get("Username")[2])
	.Enter_Password(map.get("Password")[2])
	.Click_Login_Button();
	
	home
	.Verify_HomePage()
	.Add_Red_TShirt_in_Cards()
	.Add_Sauce_Labs_Onsie_in_Card()
	.Add_Sauce_Labs_packback()
	.Click_Menu_Button()
	.Click_Logout_Button();
	

	}
}
