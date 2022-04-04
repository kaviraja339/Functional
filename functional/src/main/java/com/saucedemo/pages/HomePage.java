package com.saucedemo.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utilities.ExcelUtil;


public class HomePage extends TestPageHandler{


	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)") WebElement Red_TShirt_Add_Card;
	@FindBy(id = "add-to-cart-sauce-labs-onesie") WebElement Sauce_Labs_Onsie;
	@FindBy(id ="add-to-cart-sauce-labs-backpack") WebElement Sauce_labs_packback;
	@FindBy(id = "react-burger-menu-btn") WebElement Menu_Button;
	@FindBy(id = "logout_sidebar_link") WebElement Logout_Button;

	Map<String, String[]> map = ExcelUtil.readdata();

	public HomePage(WebDriver driver)throws IOException{
		driver = TestPageHandler.driver;
		PageFactory.initElements(driver, this);	
	}

	public HomePage Verify_HomePage() {	
		Verify.verify_page_title("Swag Labs", driver.getTitle());
		return this;	
	}

	public HomePage Add_Red_TShirt_in_Cards() {
		Verify.click("Red T-Shirt Add Card Button", Red_TShirt_Add_Card);
		return this;
	}
	
	public HomePage Add_Sauce_Labs_Onsie_in_Card() {
		Verify.click("Sauce Labs Onsie Add Caes Button", Sauce_Labs_Onsie);
		return this;
	}
	
	
	public HomePage Add_Sauce_Labs_packback() {
		Verify.click("Sauce Labs packback Add Card Button", Sauce_labs_packback);
		return this;
	}
	
	public HomePage Click_Menu_Button() {
		Verify.click("Menu Button", Menu_Button);
		return this;
	}
	
	public HomePage Click_Logout_Button() throws InterruptedException {
		Thread.sleep(4000);
		Verify.click("Logout Button", Logout_Button);
		return this;
	}

}
