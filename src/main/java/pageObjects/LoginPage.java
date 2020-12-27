package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

	public WebDriver driver;
	
	By loginMobile = By.xpath("//input[@id='mobileNumber']");
	By password = By.xpath("//input[@id='password']");
	By loginButton = By.xpath("//button[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getMobile()
	{
		return driver.findElement(loginMobile);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(loginButton);
	}
}
