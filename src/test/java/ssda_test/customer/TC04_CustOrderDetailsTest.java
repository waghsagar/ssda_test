package ssda_test.customer;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CustomerHomePage;
import pageObjects.CustomerOrderListPage;
import pageObjects.LoginPage;
import resources.TestBase;

public class TC04_CustOrderDetailsTest extends TestBase{

	public WebDriver driver;
	LoginPage lp;
	CustomerHomePage chp;
	CustomerOrderListPage colp;
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public int quantity = 1;
	
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
	}

	@Test(priority=1)
	public void testPlaceCustomerOrder() {
		log.info("Validate Customer order displayed on Order List page");
		lp = new LoginPage(driver);
		lp.getMobile().sendKeys(prop.getProperty("cust_mobile"));
		lp.getPassword().sendKeys(prop.getProperty("cust_password"));
		lp.getLogin().click();
		chp = new CustomerHomePage(driver);
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(chp.getSearchResults()));
		Assert.assertTrue(chp.getAddToCart().isDisplayed());
		chp.getSelectedQuantity(quantity);
		chp.getAddToCart().click();
		wait.until(ExpectedConditions.invisibilityOf(chp.getAlert()));
		chp.getCheckoutButton().click();
		wait.until(ExpectedConditions.visibilityOf(chp.getSelectDeliveryDate()));
		chp.getSelectDeliveryTimeSlot().click();
		chp.getSubmitDeliveryTimeSlot().click();
		Assert.assertTrue(chp.getAlert().isDisplayed());
		String orderPlacedAlertMessage = chp.getAlert().getText();
		wait.until(ExpectedConditions.invisibilityOf(chp.getAlert()));
		log.info("Customer clicks on UserMenu and then Orders link");
		chp.getUserMenu().click();
		chp.getOrdersLink().click();
		log.info("Order list page opens");
		colp = new CustomerOrderListPage(driver);
		wait.until(ExpectedConditions.visibilityOf(colp.getOrderListTable()));
		Assert.assertTrue(colp.getOrderListTable().isDisplayed());
		log.info("Customer orders displayed on Order list page");
		Actions action = new Actions(driver);
		action.doubleClick(colp.getOrderNoHeader()).build().perform();
		log.info("User double clicks on OrderNo header to sort by most recent orders");
		Assert.assertTrue(orderPlacedAlertMessage.contains(colp.getOrderNoDetails().getText()));
		log.info("New order by Customer displayed on order list page");
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	} 
}
