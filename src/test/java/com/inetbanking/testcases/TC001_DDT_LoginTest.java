package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC001_DDT_LoginTest extends BaseClass 
{
	@Test(dataProvider="LoginData")
	
	public void loginDDT(String user,String password)
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("usrname provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.click_submit();
		if(isAletPressent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			driver.findElement(By.xpath("//div[3]/div/ul/li[10]/a")).click();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}	
	}
	
	public boolean isAletPressent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String dataPath=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
		int rowNum=XLUtils.getRowCount(dataPath, "Sheet1");
		int cocount=XLUtils.getCellCount(dataPath, "Sheet1", rowNum);
		String logindata[][]=new String[rowNum][cocount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(dataPath,"Sheet1", i,j);
			}
		}
		
		return logindata;
	}

}
