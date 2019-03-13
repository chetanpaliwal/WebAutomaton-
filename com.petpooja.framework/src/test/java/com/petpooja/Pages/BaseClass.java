package com.petpooja.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.petpooja.Utility.BrowserFactory;
import com.petpooja.Utility.ConfigDataProvider;
import com.petpooja.Utility.ExeclDataProvider;
import com.petpooja.Utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExeclDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		excel=new ExeclDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter (new File(System.getProperty("user.dir")+"/Reports/Petpooja"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
    public void tearDown() {
    	BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException 
	{
	    if(result.getStatus()==ITestResult.FAILURE)
	    {
	    	 logger.fail("Test failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenshot(driver)).build());
	    }
	    else if(result.getStatus()==ITestResult.SUCCESS)
	    {
	    	logger.pass("Test passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenshot(driver)).build());
	    }
	   
	    report.flush();
	}

}
