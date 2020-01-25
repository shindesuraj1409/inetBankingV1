package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File src= new File("E:\\Projects\\Eclipse_Project_WorkSpace\\inetBanking_VI_Webapp\\Configurations\\config.properties");
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());;
		}	
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("base_url");
		return url;
	}
	
	public String getUserName()
	{
		String url=pro.getProperty("username");
		return url;
	}
	public String getPassword()
	{
		String url=pro.getProperty("password");
		return url;
	}
	
	public String setChromedriver()
	{
		String url=pro.getProperty("chromePath");
		return url;
	}
	
	public String setieBrowser()
	{
		String url=pro.getProperty("ieBrowser");
		return url;
	}
	
	public String setgekoBrowser()
	{
		String url=pro.getProperty("gekoBrowser");
		return url;
	}

}
