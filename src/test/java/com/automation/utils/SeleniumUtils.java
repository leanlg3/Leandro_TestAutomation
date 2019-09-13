package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	private SeleniumUtils() {
	}
	
	public static void visibilityToAllElements(WebDriver driver, int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public static void invisibilityToAllElements(WebDriver driver, int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));				    
	}
	
	public static boolean isPresent(WebDriver driver, int timeout, By locator){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return true;
		}
	public static boolean isNotPresent(WebDriver driver, int timeout, By locator){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		return true;
		}
	
	public static void windowsChange(WebDriver driver) {
		int size = driver.getWindowHandles().size();
		driver.switchTo().window(driver.getWindowHandles().toArray(new String[size])[size - 1]);
	}
}
