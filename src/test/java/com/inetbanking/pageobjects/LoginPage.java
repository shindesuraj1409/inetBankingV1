package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePomObject
{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement login_username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement login_password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement submit_button;
	
	public void setUserName(String username)
	{
		login_username.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		login_password.sendKeys(password);
	}
	
	public void click_submit()
	{
		submit_button.click();
	}

}
