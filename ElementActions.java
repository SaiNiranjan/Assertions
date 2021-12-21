package com.qa.ExceleRATE.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.ExceleRATE.Backend.pages.BasePage;

/**
 * 
 * @author SGajula wrapper class
 *
 */
public class ElementActions {
	WebDriver driver;

	/**
	 * 
	 * @param driver
	 */
	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnWebElement(By Selector) {
		 driver.findElement(Selector).click();
	}

	/**
	 * This method waiting for element and returning the element once found
	 * 
	 * @param Selector
	 * @return element from the method
	 */
	public WebElement getElement(By Selector) {
		waitForElementToBeClickable(Selector);
		WebElement element = driver.findElement(Selector);
		return element;
	}

	public Alert IsAlertPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 16); 
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	/**
	 * This method will wait until visibility of the web element is located on the
	 * page - Using By Locator
	 * 
	 * @param Selector
	 * @return
	 */
	public WebElement waitForElement(By Selector) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(Selector));
		}catch(Exception e) {
			System.out.println(Selector + " is not visible on page");
		}
		return null;
		
	}
	

	/**
	 * This method will wait until web element on page is clickable - Using By
	 * Locator
	 * 
	 * @param Selector
	 */
	public void waitForElementToBeClickable(By Selector) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(Selector));
	}

	public void waitUntilPresenceOfElementLocatedOnPage(By Selector) {
		WebElement navigationPageButton = (new WebDriverWait(driver, 16))
				.until(ExpectedConditions.presenceOfElementLocated(Selector));
		navigationPageButton.click();
	}
	
	public void waitUntilVisibilityOfElementLocated(By Selector) {
		WebElement wait = (new WebDriverWait(driver, 16))
				.until(ExpectedConditions.visibilityOfElementLocated(Selector));
		wait.click();
	}

	/**
	 * This method will perform sendKeys operation - Using By Locator
	 * 
	 * @param Selector
	 * @param value
	 */
	public void doSendKeysUsingByLocator(By Selector, String value) {
		try {
			getElement(Selector).clear();
			getElement(Selector).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Exception occured with locator: " + Selector);
		}
	}

	/**
	 * This method will perform SendKeys operation
	 * 
	 * @param element
	 * @param value
	 */
	public void doSendKeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Exception occured with Web Element: " + e.getMessage());
		}
	}

	/**
	 * This method will get the web element and do click operation - Using By
	 * Locator
	 * 
	 * @param Selector
	 */
	public void doClick(By Selector) {
		try {
			getElement(Selector).click();
		} catch (Exception e) {
			System.out.println("Exception occured with locator: " + Selector);
		}
	}

	/**
	 * This method will check if the web element is displayed on the page and
	 * performs click operation
	 * 
	 * @param element
	 */
	public void clickOnWebElement(WebElement element) {
		element.isDisplayed();
		element.click();
		new WebDriverWait(driver, 5);
	}

	public String getWebElementText(WebElement element) {
		return element.getText();
	}

	/**
	 * This method will get the element and checks if if is displayed on page -
	 * Using By Locator
	 * 
	 * @param Selector
	 * @return boolean
	 */
	public boolean elementIsDisplayed(By Selector) {
		return driver.findElement(Selector).isDisplayed();
	}

	/**
	 * This method will check if the element is displayed on web page
	 * 
	 * @param element
	 * @return True if the Web Element is Displayed
	 */
	public boolean elementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * @param Selector
	 * @return True if the Web Element is selected
	 */
	public boolean IsSelected(By Selector) {
		return getElement(Selector).isSelected();
	}

	/**
	 * @param Selector
	 * @return True if the Web Element is Enabled
	 */
	public boolean IsEnabled(By Selector) {
		return getElement(Selector).isEnabled();
	}
	
	/**
	 * Function to Select by Select dropdown values by visible text
	 * @param locator
	 * @param value
	 */
	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
	}

	/**
	 * This method perform click operation on Radio buttons on a page - Using By
	 * Locator
	 * 
	 * @param Selector
	 */
	public void DropdownList(By Selector, String value) {
		List<WebElement> list = driver.findElements(Selector);
		for (int i = 0; i < list.size(); i++) {
			WebElement RadioBtn = list.get(i);
			String val = RadioBtn.getAttribute(value);
			if (val.equalsIgnoreCase(Integer.toString(10005))) {
				doClick(Selector);
			}
		}
	}

	public void selectDropdownValues(By Selector, String[] value) {
		List<WebElement> choiceList = driver.findElements(Selector);
		if (!value[0].equalsIgnoreCase("All")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
//				System.out.println(choiceList.size());
				for (int k = 0; k < value.length; k++) {
					if (text.equals(value[k])) {
						choiceList.get(i).click();
						break;
					}
				}
			}
		}
	}

	public void selectDropDownList(By Locator, String DropDownOption) {
		List<WebElement> lists = driver.findElements(Locator);
		for (int i = 0; i < lists.size(); i++) {
			// System.out.println(lists.get(i).getText());
			if (lists.get(i).getText().contains(DropDownOption)) {
				lists.get(i).click();
				break;
			}
		}
	}

	public void waitUntilInvisibilityOfElementLocated(By Locator) {
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(Locator));
	}

	/**
	 * This method perform click operation on Radio buttons on a page - Using By
	 * Locator
	 * 
	 * @param Selector
	 */
	public void doClickLicensedProdcuts(By Locator, String value) {
		List<WebElement> DropdownList = driver.findElements(Locator);
		for (int i = 0; i < DropdownList.size(); i++) {
			String listValues = DropdownList.get(i).getText();
			System.out.println(listValues);
			if (listValues.equalsIgnoreCase(value)) {
				doClick(Locator);
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void SelectItemFromDropDown(By Selector, String value) {
		List<WebElement> DropDownlist = driver.findElements(Selector);
		for (WebElement button : DropDownlist) {
			if (button.getAttribute("value").equals(value) || button.getAttribute("name").equals("Dafault Dataset User")
					|| button.getAttribute("data-id").equals(value)) {
				button.click();
				break;
			}
		}
	}

	/**
	 * 
	 * @param Selector
	 * @param value
	 */
	public void selectValueFromDropDown(By Selector, String value) {

		List<WebElement> DropDownlist = driver.findElements(Selector);
		System.out.println(DropDownlist.size());
		for (int i = 0; i <= DropDownlist.size() - 1; i++) {
			String strText = DropDownlist.get(i).getText();
			System.out.println(strText);
			if (strText.equals(value)) {
				DropDownlist.get(i).click();
				break;
			}
		}
	}

	public void selectDropDownValues(By Selector, String Value) {
		List<WebElement> DropDownlist = driver.findElements(Selector);
		for (int i = 0; i < DropDownlist.size(); i++) {
			String strText = DropDownlist.get(i).getText();
			if(DropDownlist.get(i).getText().contains(Value)) {
				DropDownlist.get(i).click();
				break;
			}			
		}
	}

	/**
	 * This method performs drop down operation and selects specified web elements -
	 * By Locator
	 * 
	 * @param Selector
	 */
	public void doClickTestLanguage(By Selector) {
		WebElement ProductsList = driver.findElement(Selector);
		Actions action = new Actions(driver);
		action.moveToElement(ProductsList).build().perform();
		doClick(Selector);
	}

	/**
	 * This method perform drop down operation and deselects the specified web
	 * elements
	 * 
	 * @param element
	 * @param value
	 */
	public void selectFromDropDown(WebElement element, String value) {
		Select noOfRows = new Select(element);
		noOfRows.deselectByValue(value);
	}

	/**
	 * This method will display page info like number of links on page, text
	 */
	public void doOrganizationPageInfo() {
		List<WebElement> PageLinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of links available in Organization Page is:  " + PageLinks.size());
		for (int i = 0; i < PageLinks.size(); i++) {
			String LinkText = PageLinks.get(i).getText();
			System.out.println("Link text name for " + i + " ------->" + LinkText);
		}
		List<WebElement> ClientDetails = driver
				.findElements(By.xpath("//*[name()='svg' and contains(@data-icon, 'arrow-alt-circle-right')]"));
		System.out.println();
		System.out.println("Number of Client Details page links on the page: " + ClientDetails.size());
		System.out.println();
	}

	/*
	 * This method uploads file of any type from Desktop to WebPage
	 */
	public void doUploadFile() {
		// driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\Users\\sgajula\\source\\repos\\QA\\NextGen\\QA.png");
		// // Uploads file(Works but need to update the path to the image stored in
		// project folder)
		String dirPath = System.getProperty("user.dir");
		String path = dirPath + "\\QA.png";
		WebElement element = driver.findElement(By.xpath("//*[@type='file']"));
		JSUtil.sendKeysUsingJSWithXpath(driver, element, path);
	}

	public WebElement getWebElement(By Selector) {
		WebElement element = driver.findElement(Selector);
		return element;
	}

	/**
	 * This method will return page title
	 * 
	 * @return title
	 */
	public String getPageTitle() {
		String title = null;
		try {
			title = driver.getTitle();
			System.out.println("Page title: " + title);
		} catch (Exception e) {
			System.out.println("Some exception occured while getting page title");
			e.printStackTrace();
		}
		return title;
	}

	public String getElementText(By Selector) {
		return driver.findElement(Selector).getText();
	}

}
