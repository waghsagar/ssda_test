package ssda_test.customer;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CustomerHomePage;
import pageObjects.LoginPage;
import resources.TestBase;

public class TC02_CustAddtoCartTest extends TestBase{

	public WebDriver driver;
	LoginPage lp;
	CustomerHomePage chp;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public int quantity = 1;
	public double pricePerItemDouble = 0;
	public double totalAmountDouble = 0;
	public String totalAmountString = "";

	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
	}

	@Test(priority=1)
	public void testCheckoutButtonWithEmptyCart() {
		log.info("Validate Checkout Button state with Empty Cart");
		lp = new LoginPage(driver);
		lp.getMobile().sendKeys(prop.getProperty("cust_mobile"));
		lp.getPassword().sendKeys(prop.getProperty("cust_password"));
		log.info("Enter valid customer credentials and click on Login button");
		lp.getLogin().click();
		chp = new CustomerHomePage(driver);
		Assert.assertFalse(chp.getCheckoutButton().isEnabled());
		log.info("On Customer home page Checkout button is in disabled state");
	}

	@Test(priority=2)
	public void testAddToCartButtonVisibility() {
		log.info("Validate Add to Cart button displayed only when Product is in Stock");
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(chp.getSearchResults()));
		if(!chp.getproductStock().getText().equalsIgnoreCase("Out of Stock"))
		{
			Assert.assertTrue(chp.getAddToCart().isDisplayed());
			log.info("Product is in stock. Add to Cart button is displayed");
		} else {
			Assert.assertFalse(chp.getAddToCart().isDisplayed());
			log.info("Product is Out of stock. Add to Cart button is not displayed");
		}
	}
	
	@Test(priority=3)
	public void testAddToCartFeature() {
		log.info("Validate Add to Cart feature");
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.visibilityOf(chp.getSearchResults()));
		Assert.assertTrue(chp.getAddToCart().isDisplayed());
		log.info("Select quantity of product as : " + quantity);
		chp.getSelectedQuantity(quantity);
		log.info("Click on Add to cart button for first product");
		chp.getAddToCart().click();
		wait.until(ExpectedConditions.invisibilityOf(chp.getAlert()));
		Assert.assertTrue(chp.getCheckoutButton().isEnabled());
		Assert.assertTrue(chp.getProductAddedAlert().isDisplayed());
		log.info("Product Added to cart and Checkout button is Enabled");
	}
	
	@Test(priority=4)
	public void testProductDetailsInCart() {
		log.info("Validate details of product added in Cart");
		String productName = chp.getproductName().getText();
		String cartDetails = chp.getProductInCart().getText();
		Assert.assertTrue(cartDetails.contains(productName));
		log.info("Name of the product in cart matches with selected product");
		
		Assert.assertTrue(cartDetails.contains("Qty: "+quantity));
		log.info("Quantity of the product in cart matches with selected quantity");
		
		String pricePerItem = chp.getProductPrice().getText();
		pricePerItemDouble=Double.parseDouble(pricePerItem.substring(1));
		Assert.assertTrue(cartDetails.contains(String.valueOf(pricePerItemDouble*quantity)));
		log.info("Product Amount in Cart matches as per selected quantity");
	}
	
	@Test(priority=5)
	public void testTotalAmountPayable() {
		log.info("Validate details of total amount payable");
		totalAmountString=chp.getTotalAmountPayable().getText();
		Assert.assertTrue(totalAmountString.contains(String.valueOf(pricePerItemDouble*quantity)));
		log.info("Total payable amount matches as per selected quantity");
	}
		
	@Test(priority=6)
	public void testDeleteItemFromCart() {
		log.info("Validate Delete Product from cart feature");
		Assert.assertTrue(chp.getProductInCart().isDisplayed());
		log.info("Product present in cart");
		totalAmountDouble=Double.parseDouble(totalAmountString.substring(1));
		double expectedTotalAmountAfterDeleteItem = (totalAmountDouble - (pricePerItemDouble*quantity));
		chp.getDeleteItemButton().click();
		log.info("Click on Delete Item button");
		Assert.assertTrue(chp.getProductRemoveAlert().isDisplayed());
		Assert.assertFalse(chp.getCheckoutButton().isEnabled());
		Assert.assertTrue(chp.getTotalAmountPayable().getText().contains(String.valueOf(expectedTotalAmountAfterDeleteItem)));
		log.info("Product removed from cart");
	}
/*	
	@Test
	public void testSearchItems(){
		log.info("Navigated to Customer Home page");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(chp.getSearchProductBox()));
		Assert.assertTrue(chp.getSearchProductBox().isDisplayed());
		chp.getSearchProductBox().click();
		chp.getSearchProductBox().sendKeys("GILL VECT RAZOR");
		log.info("Customer searches product in inventory");
		String actualString = chp.getSearchResults().getText();
		Assert.assertTrue(actualString.contains("GILL VECT RAZOR"));
		log.info("Customer entered product found in inventory"); 
	}
	*/
	@AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	} 
}
