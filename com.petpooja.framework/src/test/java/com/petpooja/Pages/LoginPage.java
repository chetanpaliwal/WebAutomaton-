package com.petpooja.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(xpath="//*[@id=\"dropdownMenu2\"]/div")WebElement allRestaurantbtn;
	@FindBy(xpath="//div[@class='navbar-header']//li[3]//a[1]")WebElement MyRetaurant;
	
	
	public void loginToPetpooja(String usernameApplication, String passwordApplication) {
		
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginbutton.click();
		
	}
	
	public void SelectRes() {
		Actions action = new Actions(driver);
		action.moveToElement(allRestaurantbtn);
		allRestaurantbtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("After 2 seconds try, Not able to find OR click on your restaurant" +e.getMessage());
		}
		MyRetaurant.click();
	}
	
}
