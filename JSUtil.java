package com.qa.ExceleRATE.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author SGajula
 *
 */
public class JSUtil {
	
	/**
	 * This method will flash the web element
	 * 
	 * @param element
	 * @param driver
	 */
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 4; i++) {
			changeColor("rgb(0,128,0)", element, driver);// 1
			changeColor(bgcolor, element, driver);// 2
		}
	}
	
	/**
	 * This method will wait explicitly for the element on the page  and return the element
	 * 
	 * @param selector
	 * @param driver
	 * @param timeout
	 * @return element
	 */
	public static WebElement flashby(By selector, WebDriver driver, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(selector));
		WebElement element = driver.findElement(selector);
		flash(element, driver);
		return element;
	}
	

	/**
	 * This method changes the color of the specific web element
	 * 
	 * @param color
	 * @param selector
	 * @param driver
	 */
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 * This method changes the color of the specific web element  using By Selector
	 * 
	 * @param color
	 * @param element
	 * @param driver
	 */
	public static void changeColorForByLocators(String color, By Selector, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", Selector);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	

	/**
	 * This method will draw border on particular element. Apply this method for
	 * failed web element
	 * 
	 * @param element
	 * @param driver
	 */
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/**
	 * At run time JavaScript will generate Pop Alert
	 * 
	 * @param driver
	 * @param message
	 */
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	/**
	 * Type casting - converting driver into JSExecutor
	 * Clicking web element
	 * @param element
	 * @param driver
	 */
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Type casting - converting driver into JSExecutor
	 * Clicking web element using By selector
	 * @param element
	 * @param driver
	 */
	public static void clickElementUsingBySelector(By Selector, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", Selector);
	}
	
	/**
	 * This method will refresh the Browser using JavaScript Executor
	 * 
	 * @param driver
	 */
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	/**
	 * This method will returns title of the page
	 * 
	 * @param driver
	 * @return
	 */
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	/**
	 * This method will return the entire text of the web page
	 * 
	 * @param driver
	 * @return
	 */
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	/**
	 * This method will scroll down the page
	 * 
	 * @param driver
	 */
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method Scroll down the page by 1000 pixels
	 */
	public static void ScrollPageDownbyPixels(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,2000)"); // 1000 can be increased if the page is lengthy
	}

	/**
	 * 
	 * @param element
	 * @param driver
	 */
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method will return the browser info using JavaScript Executor
	 * 
	 * @param driver
	 * @return
	 */
	public static String getBrowserInfo(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

	/**
	 * This JavaScript Executor send keys with ID as parameter
	 * 
	 * @param driver
	 * @param id
	 * @param value
	 */
	public static void sendKeysUsingJSWithId(WebDriver driver, String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	/**
	 * This JavaScript Executor send keys with name as parameter
	 * 
	 * @param driver
	 * @param name
	 * @param value
	 */
	public static void sendKeysUsingJSWithName(WebDriver driver, String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
	}
	
	/**
	 * This JavaScript Executor send keys with xpath as parameter
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public static void sendKeysUsingJSWithXpath(WebDriver driver, WebElement element, String value) { //DOESNT WORK 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByXpath('" + element + "').value='" + value + "'"); 
	}
	
	public static void sendKeysUsingJSWithjQuery(WebDriver driver, By  Locator, String value) { //DOESNT WORK 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByXpath('" + Locator + "').value='" + value + "'"); 
	}

}
