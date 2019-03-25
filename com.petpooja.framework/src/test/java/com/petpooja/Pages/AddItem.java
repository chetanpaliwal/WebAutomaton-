package com.petpooja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddItem {

	WebDriver driver;

	public AddItem(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//li[@class='dropdown pmd-dropdown open']//span[@class='media-body'][contains(text(),'Management')]")
	WebElement ManagementBtn;
	@FindBy(xpath = "//a[contains(text(),'Menu')]")
	WebElement ManuBtn;
	@FindBy(xpath = "//button[@id='add_item']")
	WebElement AddMenuItems;
	@FindBy(xpath = "//input[@id='name_0']")
	WebElement ItemNameArea;
	@FindBy(xpath = "//input[@id='shortname_0']")
	WebElement ShortCodeArea;
	@FindBy(xpath = "//div[@id='categoryid_0_chosen']//span[contains(text(),'Select Category')]")
	WebElement SelectCategorydd; // select Other
	@FindBy(xpath = "//input[@id='price_0']")
	WebElement PriceArea;
	@FindBy(xpath = "//input[@id='description_0']")
	WebElement DiscriptionArea;
	@FindBy(xpath = "//input[@id='onlinedisplayname_0']")
	WebElement OnlineNmae;
	@FindBy(xpath = "//label[@for='attributes02']")
	WebElement ChoiceradioBtn;
	@FindBy(xpath="//input[@id='tmpallowvariation_0']")WebElement HasVariation;
	@FindBy(xpath="//button[contains(text(),'Save & Exit')]")WebElement SaveExit;

	public void AddNewItem() {
		
		ManagementBtn.click();
		ManuBtn.click();
		AddMenuItems.click();
		ItemNameArea.sendKeys("Non Veg Special");
		ShortCodeArea.sendKeys("2700");
		
		//To select dropdown values
		Select dropdown1=new Select(SelectCategorydd);
		dropdown1.selectByVisibleText("Other");
		
		PriceArea.sendKeys("100");
		DiscriptionArea.sendKeys("This is automation test, please ignore");
		OnlineNmae.sendKeys("Non Veg Special");
		
		//To select radio btn
		Actions Choiceradio = new Actions(driver);
		Choiceradio.moveToElement(ChoiceradioBtn);
		ChoiceradioBtn.click();
		
		
		
		
		

	}
}