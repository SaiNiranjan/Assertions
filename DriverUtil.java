package com.qa.ExceleRATE.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ExceleRATE.Backend.pages.BasePage;

/**
 * 
 * @author SGajula
 *
 */
public class DriverUtil extends BasePage {
	WebDriver driver;

	public DriverUtil(WebDriver driver) {
		this.driver = driver;
	}
	

	/**
	 * This method will return page title
	 * @return title
	 */
	public String getPageTitle() {
		String title = null;
		try {
			title = driver.getTitle();
			System.out.println("Page title is: " + title);
		} catch (Exception e) {
			System.out.println("Some exception occured while getting the title");
		}
		return title;
	}

	/**
	 * This method waits until the specific web element is visible on the page
	 *   
	 * @return Web Driver Wait 
	 */
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, 16);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 *This method waits until the specific web element is visible on page - Using By locator
	 * @param Selector 
	 * 
	 */
	public void waitForElementToBeVisible(By Selector) {
		WebDriverWait wait = new WebDriverWait(driver, 16);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Selector));
	}
	
	/**
	 *This method waits until the specific web element is clickable on page 
	 * @param element
	 */
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, 16);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*
	 * This method uploads file of any type from Desktop to WebPage
	 */
	public void uploadFile() {
		//driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\Users\\sgajula\\source\\repos\\QA\\NextGen\\QA.png"); // Uploads file(Works)
		  String dirPath = System.getProperty("user.dir");	
		  String path = dirPath+"\\QA.png";
		  driver.findElement(By.xpath("//*[@type='file']")).sendKeys(path);  
	}
}