package com.petpooja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * Author Chetan
 */

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="email")WebElement uname;
	@FindBy(id="password")WebElement pass;
	@FindBy(xpath="//button[@type='submit']")WebElement loginbutton;
	
	public void loginToPetpooja(String usernameApplication, String passwordApplication) {
		
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginbutton.click();
	}
	
}
