package com.FG.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FG.qa.base.TestBase;
import com.FG.qa.pages.RegistrationPage;

public class Check_Resgistration_Page extends TestBase{
	
	RegistrationPage ragiPage;

	public Check_Resgistration_Page()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();

		ragiPage=new RegistrationPage();
	}
	@Test(priority = 0)
	public void testTitle()
	{
		String gettile= ragiPage.verifyTitle();
		Assert.assertEquals(gettile, "General Insurance: Buy & Renew Health & Car Insurance Online| Future Generali");
		System.out.println("title is print successfully");
	}
	@Test(priority = 1)
	public void testLogo()
	{
		boolean ll= ragiPage.logotest();
		System.out.println(ll);
	
	}
	@Test(priority = 2)
	public void testRegistaration_page()
	{
		ragiPage.test_Buy_Button();
		ragiPage.test_carinsurance_Button();
		ragiPage.test_Registration_Details(prop.getProperty("registration_number"), prop.getProperty("regi_mobilenum"), prop.getProperty("email"));
        System.out.println("done registration details of vehicles");

	}
	@AfterMethod
	public void close()
	{
		//driver.close();
	}
}
