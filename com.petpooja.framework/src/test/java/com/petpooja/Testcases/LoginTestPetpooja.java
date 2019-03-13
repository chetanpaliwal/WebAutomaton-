package com.petpooja.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.petpooja.Pages.BaseClass;
import com.petpooja.Pages.LoginPage;

/*
 * Author QA_Chetan
 */

public class LoginTestPetpooja extends BaseClass{
	
	@Test
	public void loginApp() {
		
		logger=report.createTest("Login to Petpooja");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToPetpooja(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Done Successfully");
	}

}

