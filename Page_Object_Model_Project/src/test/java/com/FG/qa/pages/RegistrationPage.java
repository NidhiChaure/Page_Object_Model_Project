package com.FG.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FG.qa.base.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(xpath = "//*[contains(text(),'BUY')]")
	WebElement Buy_Button;
	@FindBy(xpath = "//*[text()='Car Insurance']")
	WebElement carinsurance_button;
	
	@FindBy(xpath = "//*[@name=\"registrationNo\"]")
	WebElement regi_number;
	
	@FindBy(xpath = "//*[@name=\"registrationMobileNumber\"]")
	WebElement regi_mobile_num;
	
	@FindBy(xpath = "//*[@name=\"EmailId\"]")
	WebElement emailid;
	
	@FindBy(xpath = "//*[@type=\"checkbox\"]")
	WebElement checkbox;
	
	@FindBy(xpath = "//*[contains(text(),'quote')]")
	WebElement getQoute_button;
	
	@FindBy(xpath = "//*[@class=\"logo\"]")
	WebElement fg_logo;
	
	public  RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public  String verifyTitle()
	{
		return driver.getTitle();
	}
	public boolean logotest()
	{
		return fg_logo.isDisplayed();
	}
	
	public void test_Buy_Button()
	{
		Buy_Button.click();
	}
	public void test_carinsurance_Button()
	{
		carinsurance_button.click();
	}
	
	public CarDetails_Page test_Registration_Details(String renum,String mobilenum,String Eid)
	{
		regi_number.sendKeys(renum);
		regi_mobile_num.sendKeys(mobilenum);
		emailid.sendKeys(Eid);
		checkbox.click();
		getQoute_button.click();
		
		return new CarDetails_Page();

	}
	
}
