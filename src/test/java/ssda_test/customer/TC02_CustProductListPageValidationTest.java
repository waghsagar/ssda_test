package ssda_test.customer;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CustomerHomePage;
import pageObjects.LoginPage;
import resources.TestBase;
import resources.Utilities;

public class TC02_CustProductListPageValidationTest extends TestBase{

	public WebDriver driver;
	LoginPage lp;
	CustomerHomePage chp;
	Utilities util;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public int quantity = 2;
	public String searchProduct = "JOHNSON";
	public double pricePerItemDouble = 0;
	public double totalAmountDouble = 0;
	public String totalAmountString = "";

	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		util = new Utilities();
		lp = new LoginPage(driver);
		chp = new CustomerHomePage(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@Test(priority=1)
	public void testCheckoutButtonWithEmptyCart() {
		log.info("Validate Checkout Button state with Empty Cart");
		lp.getMobile().sendKeys(prop.getProperty("cust_mobile"));
		lp.getPassword().sendKeys(prop.getProperty("cust_password"));
		log.info("Enter valid customer credentials and click on Login button");
		lp.getLogin().click();
		wait.until(ExpectedConditions.invisibilityOf(chp.getNoRecordsFound()));
		Assert.assertFalse(chp.getCheckoutButton().isEnabled());
		log.info("On Customer home page Checkout button is in disabled state");
	}
	
	@Test(priority=2)
	public void testDefaultSelectedQuantityofProduct() {
		log.info("Validate if default quantity of product is set as '1' in dropdown");
		Assert.assertEquals(Integer.parseInt(util.getSelectedOption(chp.getProductQuantity())), 1);
		System.out.println("Default selected quantity is : "+util.getSelectedOption(chp.getProductQuantity()));
		log.info("Default selected quantity is : "+util.getSelectedOption(chp.getProductQuantity()));
	}
	
	@Test(priority=3)
	public void testItemsDisplayedPerPage() {
		log.info("Validate if items per page displayed as per dropdown selection");
		chp.getItemsPerPage().click();
		// Get the all WebElements inside the dropdown in List
		List<WebElement> dropdown_list = chp.getDropdownOptions();
	      // Iterating through the list and selecting the desired option
	      for( int j = 0; j < dropdown_list.size(); j++){
	    	  if( dropdown_list.get(j).getText().contains("30")){
	        	 dropdown_list.get(j).click();
	            break;
	         }
	      }
	      wait.until(ExpectedConditions.invisibilityOf(chp.getNoRecordsFound()));
	      Assert.assertEquals(chp.getItemsPerPage().getText(), "30");
	      List<WebElement> totalSearchResult = chp.getTotalSearchResults();
	      Assert.assertEquals(chp.getItemsPerPage().getText(), String.valueOf(totalSearchResult.size()));
	      log.info("On Customer product list page items per page are displayed as per dropdown selection");
	}
	
	@Test(priority=4)
	public void testAddtoCartButtonDisplayedAsPerInventory() {
		log.info("Validate whether 'Add to Cart' button is Enabled only if product is in stock");
		List<WebElement> allProductStock = chp.getAllProductStock();
		for( int i = 0; i < allProductStock.size(); i++){
			if(!allProductStock.get(i).getText().equalsIgnoreCase("Out of Stock")){
				Assert.assertTrue(chp.getAllAddToCart().get(i).isEnabled());
				log.info("Product is present in stock. Add to Cart button is Enabled");
			} else {
				Assert.assertFalse(chp.getAllAddToCart().get(i).isEnabled());
				log.info("Product is Out of stock. 'Add to Cart' button is Disabled");
			}
		}
	}
	
	@Test(priority=5)
	public void testSearchProductFunctionality(){
		log.info("Validate search product feature on product list page");
		Assert.assertTrue(chp.getSearchProductBox().isDisplayed());
		log.info("Customer enters product name to search in inventory");
		chp.getSearchProductBox().sendKeys(searchProduct);
		chp.getSearchProductIcon().click();
		wait.until(ExpectedConditions.invisibilityOf(chp.getNoRecordsFound()));
		List<WebElement> allProductsName = chp.getAllProductsName();
		System.out.println("Total products found after search : "+ allProductsName.size());
		log.info("Total products found after search : "+ allProductsName.size());
		for( int i = 0; i < allProductsName.size(); i++){
			Assert.assertTrue(allProductsName.get(i).getText().contains(searchProduct));
		}
		log.info("All products found contains text searched by customer");
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	} 
}
