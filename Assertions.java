package com.qa.ExceleRATE.util;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Assertions {
	WebDriver driver1;

	public Assertions(WebDriver driver) {
		this.driver1 = driver;
	}

	public void softAssertTrue(boolean condition, String message) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(condition, message);
		softAssert.assertAll();
	}

	public void softAssertTrue(String ElementText, boolean True) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ElementText, True);
		softAssert.assertAll();
	}

	public void softAssertEquals(String actual, String expected, String message) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, message);
		softAssert.assertAll();
	}

}
