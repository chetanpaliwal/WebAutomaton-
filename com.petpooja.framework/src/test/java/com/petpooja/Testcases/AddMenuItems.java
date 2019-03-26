package com.petpooja.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.petpooja.Pages.AddItem;
import com.petpooja.Pages.BaseClass;
import com.petpooja.Pages.LoginPage;

public class AddMenuItems extends BaseClass {

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
		 

	
  @Test(priority = 3)
  public void AdditmesInMenu() throws InterruptedException  {
	  
	  LoginTestPetpooja bb=new LoginTestPetpooja();
	  bb.loginApp();
	  bb.SelectRestaurant();
	
	  AddItem AddItem1 = PageFactory.initElements(driver, AddItem.class);
	  AddItem1.AddNewItem();
  }
}
