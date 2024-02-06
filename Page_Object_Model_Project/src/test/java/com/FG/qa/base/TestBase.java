package com.FG.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.FG.qa.util.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
 public static WebDriver driver;
 
	public TestBase() {
         
		  try {
			prop=new Properties();
			FileInputStream inp=new FileInputStream("/home/apmosys/eclipse-workspace/Page_Object_Model_Project/src/test/java/com/FG/qa/configured/login.properties");
			prop.load(inp);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void initialization()
	{
	String	browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.implicit_timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
}
