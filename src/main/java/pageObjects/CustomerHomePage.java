package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerHomePage {

	public WebDriver driver;
	
	private By checkout = By.xpath("//button[text()='CHECKOUT']");
	
	private By clearFilter = By.xpath("//*[text()='Clear All Filters']");
	
	private By category = By.xpath("//*[@class='btn btn-link btn-block text-left text-dark']");
	
	private By productName = By.xpath("//tbody/tr[1] //div[@class='fontsize15 fontweight pt-1']");
	
	private By productStock = By.xpath("//tbody/tr[1] //div[@class='pt-1']");
	
	private By productPrice = By.xpath("//tbody/tr[1] //div[@class='fontweight17 fontbold']");
	
	private By productQuantity = By.xpath("//select[@id='mat-input-3']");
	
	private By addToCart = By.xpath("//tbody/tr[1] //button[text()='Add to Cart']");
	
	private By allProductsName = By.xpath("//td[@role='gridcell']//div[@class='fontsize15 fontweight pt-1']");
	
	private By allproductStock = By.xpath("//tbody/tr //div[@class='pt-1']");
	
	private By allAddToCart = By.xpath("//tbody/tr //button[text()='Add to Cart']");
	
	private By searchProductBox = By.xpath("//span[contains(.,'Search Product')]//parent::div[1]/input");
	
	private By searchIcon = By.xpath("//span[contains(.,'Search Product')]//parent::div[1]/div/mat-icon");
	
	private By totalsearchResults = By.xpath("//table[@role='grid']/tbody/tr/td");
	
	private By productInCart = By.xpath("//div[@class='card-body cartbgcolor cardHeight'] //div[@class='ng-star-inserted']");
	
	private By deleteItemButton = By.xpath("//button[.='DELETE ITEM']");
	
	private By totalAmountPayable = By.xpath("//div[normalize-space()='Total Amount Payable']//following-sibling::div");
	
	private By deliveryDate = By.xpath("//div[@class='cdk-global-overlay-wrapper']//div[2]//mat-card[1]//mat-card-title[1]/child::h4");
	
	private By deliveryTimeSlot = By.xpath("//div[@class='cdk-global-overlay-wrapper']//div[2]//mat-card[1]//mat-card-content[1]//div[1]//div[1]//button[1]");
	
	private By submitDeliveryTimeSlot = By.xpath("//div[@class='cdk-overlay-pane']//button[contains(.,'Submit')]");
	
	private By cancelDeliveryTimeSlot = By.xpath("//div[@class='cdk-overlay-pane']//button[contains(.,'Cancel')]");
	
	private By UserMenu = By.xpath("//a[@id='dropdown']");
	
	private By ordersLink = By.xpath("//a[text()='Orders']");
	
	private By changeEmailLink = By.xpath("//a[text()='Change Email/Password']");
	
	private By logoutLink = By.xpath("//a[text()='Logout']");

	private By alert = By.xpath("//div[@role='alertdialog']");
	
	private By noRecordsFound = By.xpath("//div[@class='text-center']//parent::div[contains(.,'No Records Found!')]");
	
	private By itemsPerPage = By.xpath("//mat-select[@aria-label='Items per page:']");
	
	private By dropdownOptions = By.xpath("//div[@id='mat-select-1-panel']/mat-option");
			
	
	public CustomerHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getCheckoutButton(){
		return driver.findElement(checkout);
	}

	public WebElement getClearFiltersButton() {
		return driver.findElement(clearFilter);
	}
	
	public WebElement getCategory() {
		return driver.findElement(category);
	}
	
	public WebElement getAddToCart() {
		return driver.findElement(addToCart);
	}
	
	public WebElement getProductQuantity() {
		return driver.findElement(productQuantity);
	}
	
	public WebElement getSearchProductBox() {
		return driver.findElement(searchProductBox);
	}
	
	public WebElement getSearchProductIcon() {
		return driver.findElement(searchIcon);
	}
	
	public List<WebElement> getTotalSearchResults() {
		return driver.findElements(totalsearchResults);
	}
	
	public WebElement getProductInCart() {
		return driver.findElement(productInCart);
	}
	
	public WebElement getProductPrice() {
		return driver.findElement(productPrice);
	}
	
	public WebElement getproductName() {
		return driver.findElement(productName);
	}
	
	public WebElement getproductStock() {
		return driver.findElement(productStock);
	}
	
	public WebElement getDeleteItemButton() {
		return driver.findElement(deleteItemButton);
	}
	
	public WebElement getTotalAmountPayable() {
		return driver.findElement(totalAmountPayable);
	}
	
	public WebElement getSelectDeliveryDate() {
		return driver.findElement(deliveryDate);
	}
	
	public WebElement getSelectDeliveryTimeSlot() {
		return driver.findElement(deliveryTimeSlot);
	}
	
	public WebElement getSubmitDeliveryTimeSlot() {
		return driver.findElement(submitDeliveryTimeSlot);
	}
	
	public WebElement getCancelDeliveryTimeSlot() {
		return driver.findElement(cancelDeliveryTimeSlot);
	}
	
	public WebElement getAlert() {
		return driver.findElement(alert);
	}
	
	public WebElement getUserMenu() {
		return driver.findElement(UserMenu);
	}
	
	public WebElement getOrdersLink() {
		return driver.findElement(ordersLink);
	}
	
	public WebElement getChangeEmailLink() {
		return driver.findElement(changeEmailLink);
	}
	
	public WebElement getLogoutLink() {
		return driver.findElement(logoutLink);
	}
	
	public WebElement getNoRecordsFound() {
		return driver.findElement(noRecordsFound);
	}
	
	public WebElement getItemsPerPage() {
		return driver.findElement(itemsPerPage);
	}
	
	public List<WebElement> getDropdownOptions() {
		return driver.findElements(dropdownOptions);
	}
	
	public List<WebElement> getAllProductsName() {
		return driver.findElements(allProductsName);
	}
	
	public List<WebElement> getAllProductStock() {
		return driver.findElements(allproductStock);
	}
	
	public List<WebElement> getAllAddToCart() {
		return driver.findElements(allAddToCart);
	}
}
