package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CustomerOrderListPage {

	public WebDriver driver;
	
	private By orderNoFilter = By.xpath("//*[contains(.,'Order No.')]/label/span");
	
	private By deliveryDateFilter = By.xpath("//span[contains(.,'Delivery Date')]");
	
	private By statusFilter = By.xpath("//span[contains(.,'Status')]/label/span");
	
	private By orderListTable = By.xpath("//table[@role='grid']/tbody/tr");
	
	private By orderNoHeader = By.xpath("//table[@role='grid']//button[contains(., 'ORDER NO')]");
	
	private By deliveryDateHeader = By.xpath("//table[@role='grid']//button[contains(.,'DELIVERY DATE')]");
	
	private By slotHeader = By.xpath("//table[@role='grid']//button[contains(.,'SLOT')]");
	
	private By amountHeader = By.xpath("//table[@role='grid']//button[contains(.,'AMOUNT')]");
	
	private By statusHeader = By.xpath("//table[@role='grid']//button[contains(.,'STATUS')]");
	
	private By orderNoDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[1]");
	
	private By deliveryDateDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[2]");
	
	private By slotDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[3]");
	
	private By amountDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[4]");
	
	private By statusDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]");
	
	private By clearFilterButton = By.xpath("//button[contains(.,'Clear Filters')]");
	
	private By refreshButton = By.xpath("//button[contains(.,'Refresh')]");
	
	private By backToHomeButton = By.xpath("//button[contains(.,'Back to Home')]");
	
	private By alert = By.xpath("//div[@role='alertdialog']");
	
			
	public CustomerOrderListPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getOrderNoFilter() {
		return driver.findElement(orderNoFilter);
	}
	
	public WebElement getDeliveryDateFilter() {
		return driver.findElement(deliveryDateFilter);
	}
	
	public WebElement getStatusFilter() {
		return driver.findElement(statusFilter);
	}
	
	public WebElement getOrderListTable() {
		return driver.findElement(orderListTable);
	}
	
	public WebElement getOrderNoHeader() {
		return driver.findElement(orderNoHeader);
	}
	
	public WebElement getDeliveryDateHeader() {
		return driver.findElement(deliveryDateHeader);
	}
	
	public WebElement getSlotHeader() {
		return driver.findElement(slotHeader);
	}
	
	public WebElement getAmountHeader() {
		return driver.findElement(amountHeader);
	}
	
	public WebElement getStatusHeader() {
		return driver.findElement(statusHeader);
	}
	
	public WebElement getOrderNoDetails() {
		return driver.findElement(orderNoDetails);
	}
	
	public WebElement getDeliveryDateDetails() {
		return driver.findElement(deliveryDateDetails);
	}
	
	public WebElement getSlotDetails() {
		return driver.findElement(slotDetails);
	}
	
	public WebElement getAmountDetails() {
		return driver.findElement(amountDetails);
	}
	
	public WebElement getStatusDetails() {
		return driver.findElement(statusDetails);
	}
	
	public WebElement getClearFiltersButton() {
		return driver.findElement(clearFilterButton);
	}
	
	public WebElement getRefreshButton() {
		return driver.findElement(refreshButton);
	}
	
	public WebElement getBackToHomeButton() {
		return driver.findElement(backToHomeButton);
	}
	
	public WebElement getAlert() {
		return driver.findElement(alert);
	}
	
}
