package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass 
{
	ReadConfig readConfig= new ReadConfig();
	public String base_url=readConfig.getApplicationURL();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser)
	{
		logger= Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.setChromedriver());
			driver=new ChromeDriver();
			
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readConfig.setieBrowser());
			driver=new InternetExplorerDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.setgekoBrowser());
			driver=new FirefoxDriver();
		}
		driver.get(base_url);
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}


}
