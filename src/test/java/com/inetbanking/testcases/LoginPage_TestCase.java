package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class LoginPage_TestCase extends BaseClass
{
	@Test
	public void login_test() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage login_obj= new LoginPage(driver);
		login_obj.setUserName(username);
		logger.info("Entered username");
		login_obj.setPassword(password);
		logger.info("Entered Password");
		login_obj.click_submit();
		logger.info("Clicked Login button");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
			
		}
	}

}
