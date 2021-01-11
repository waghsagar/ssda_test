package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerHomePage {

	public WebDriver driver;
	
	private By checkout = By.xpath("//button[text()='CHECKOUT']");
	
	private By clearFilter = By.xpath("//*[text()='Clear Filters']");
	
	private By category = By.xpath("//*[@class='btn btn-link btn-block text-left text-dark']");
	
	private By addToCart = By.xpath("//tbody/tr[1] //button[text()='Add to Cart']");
	
	private By productPrice = By.xpath("//tbody/tr[1] //div[@class='fontweight17 fontbold']");
	
	private By productName = By.xpath("//tbody/tr[1] //div[@class='fontsize15 fontweight pt-1']");
	
	private By productStock = By.xpath("//tbody/tr[1] //div[@class='pt-1']");
	
	private By productQuantity = By.xpath("//select[@id='mat-input-3']");
	
	private By searchProductBox = By.xpath("//div[@class='mat-form-field-infix ng-tns-c47-0']");
	
	private By searchIcon = By.cssSelector("mat-icon[role='img']");
	
	private By searchResults = By.xpath("//table[@role='grid']/tbody/tr");
	
	private By productInCart = By.xpath("//div[@class='card-body cartbgcolor cardHeight'] //div[@class='ng-star-inserted']");
	
	private By deleteItemButton = By.xpath("//button[.='DELETE ITEM']");
	
	private By totalAmountPayable = By.xpath("//div[normalize-space()='Total Amount Payable']//following-sibling::div");
	
	private By productAddedAlert = By.xpath("//div[@aria-label='The product is added in the cart']");
	
	private By productRemoveAlert = By.xpath("//div[@aria-label='The item is removed from Cart!']");
	
	private By deliveryDate = By.xpath("//div[@class='cdk-global-overlay-wrapper']//div[2]//mat-card[1]//mat-card-title[1]/child::h4");
	
	private By deliveryTimeSlot = By.xpath("//div[@class='cdk-global-overlay-wrapper']//div[2]//mat-card[1]//mat-card-content[1]//div[1]//div[1]//button[1]");
	
	private By submitDeliveryTimeSlot = By.xpath("//div[@class='cdk-overlay-pane']//button[contains(.,'Submit')]");
	
	private By cancelDeliveryTimeSlot = By.xpath("//div[@class='cdk-overlay-pane']//button[contains(.,'Cancel')]");

	//private By selectTimeSlotAlert = By.xpath("//div[@aria-label='Please select timeslot']");
	
	private By UserMenu = By.xpath("//a[@id='dropdown']");
	
	private By ordersLink = By.xpath("//a[text()='Orders']");
	
	private By changeEmailLink = By.xpath("//a[text()='Change Email/Password']");
	
	private By logoutLink = By.xpath("//a[text()='Logout']");

	private By alert = By.xpath("//div[@role='alertdialog']");
	
			
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
	
	public WebElement getSearchResults() {
		return driver.findElement(searchResults);
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
	
	public WebElement getProductAddedAlert() {
		return driver.findElement(productAddedAlert);
	}
	
	public WebElement getProductRemoveAlert() {
		return driver.findElement(productRemoveAlert);
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
	
	public void getSelectedQuantity(int index) {
		Select select = new Select(getProductQuantity());
		select.selectByIndex(index - 1);
	}
}
