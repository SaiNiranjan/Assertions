package com.qa.ExceleRATE.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author SGajula
 *
 */
public class ExplicitWaits{
	static WebDriver driver;
	 JSUtil JavaScriptUtil;
	
	public WebElement getElement(By selector, int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(selector));
		
		WebElement element = driver.findElement(selector);
		JavaScriptUtil.flash(element, driver);
		return element;
	}	
}
