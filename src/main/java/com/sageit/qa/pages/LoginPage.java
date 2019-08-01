package com.sageit.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sageit.qa.utilities.CommonFunctions;

public class LoginPage {
	
	WebDriver driver;
	CommonFunctions key;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		key = new CommonFunctions();
	}
	
	
	By clientiden = By.id("ClientID");
	By username = By.id("UserID");
	By password = By.id("Password");
	By login = By.name("Command");
	By logout= By.id("button_Group");
	By logout2 = By.id("button_LogOut");
	
	
	public void login(String cid,String uid, String pass) throws Exception
	{
		key.sendValue(clientiden, cid, "Client ID");
		key.sendValue(username, uid, "Username");
		key.sendValue(password, pass, "Password");
		key.clickElement(login, "Login Button");

		
	}
	
	
	public void logoutApp() throws Exception
	{
		key.clickElement(logout, "PageLogout");
		key.clickElement(logout2, "Logout Button");
	}

}
