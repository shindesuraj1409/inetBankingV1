package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePomObject
{
	WebDriver driver;  //WebDriver Interface and its instance
	
	//Create constructor
	public BasePomObject(WebDriver driver)
	{
		this.driver=driver;  //Initialize parametierized driver to local driver
		PageFactory.initElements(driver, this);
		
	}
	
	

}
