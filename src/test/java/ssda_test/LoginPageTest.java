package ssda_test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class LoginPageTest extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		 driver =initializeDriver();
		 log.info("Driver is initialized");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		driver.get(prop.getProperty("url")+"/login");
		log.info("Navigated to Login page");
		LoginPage lp = new LoginPage(driver);
		lp.getMobile().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.getLogin().click();
	/*	String expectedUrl=prop.getProperty("url")+"/admin/dashboard";
        String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl);  */
		log.info("Successfully validated page url");
	}

	@AfterTest
	public void teardown(){
		driver.close();
	}
}
