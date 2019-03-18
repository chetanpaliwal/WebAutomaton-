package com.petpooja.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.petpooja.Pages.BaseClass;
import com.petpooja.Pages.LoginPage;


/*
 * Author QA_Chetan
 */

public class LoginTestPetpooja extends BaseClass {

	@Test(priority = 1)
	public void loginApp() {

		logger = report.createTest("Login to Petpooja");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginPage.loginToPetpooja(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

		logger.pass("Login Done Successfully");

	}

	
	@Test(priority = 2)
	public void SelectRestaurant() throws InterruptedException {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.SelectRes();
		
	 }
	 

}
