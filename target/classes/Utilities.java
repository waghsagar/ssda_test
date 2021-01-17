package resources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {

	public Select select;

	//To Select a value from Drop Down by using SelectByVisibleText Method.
	public void selectValueFromDropDownByText(WebElement element, String value) 
	{
		select = new Select(element);
		select.selectByVisibleText(value);
	}

	//To Select a value from Drop Down by using SelectByIndex Method.
	public void selectValueFromDropDownByIndex(WebElement element, int value) 
	{
		select = new Select(element);
		select.selectByIndex(value - 1);
	}

	//To Select a value from Drop Down by using SelectByValue Method.
	public void selectValueFromDropDownByValue(WebElement element, String value) 
	{
		select = new Select(element);
		select.selectByValue(value);
	}

	//To Select a value from Drop Down by using SelectByValue Method.
	public String getSelectedOption(WebElement element) 
	{
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}


	/*

	public boolean checkVisibilityofElement(WebElement element) {
		try {
		element.isDisplayed()
		return true
		} catch (Exception e) {
		return false
		}
		}



	public boolean isElementPresent(WebElement element) {
		try {
			driver.findElement(element);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementVisible(String cssLocator){
		return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
	}
	 */
}
