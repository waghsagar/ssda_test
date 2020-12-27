package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

public WebDriver driver;
	
	By dashboard = By.xpath("//div[contains(text(),'DASHBOARD')]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getDashboard()
	{
		return driver.findElement(dashboard);
	}
	
}
