package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CruisePage extends BasePage {
	public CruisePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "cruise-destination-hp-cruise")
	private WebElement goingTo;

	@FindBy(id = "cruise-departure-month-hp-cruise")
	private WebElement departure;

	@FindBy(xpath = "//*[@id=\"gcw-cruises-form-hp-cruise\"]/button")
	private WebElement search;

	public CruisePage goTo(String going) throws Exception {
		goingTo.click();
		getWait().until(ExpectedConditions.elementToBeClickable(goingTo));
		goingTo.sendKeys(going);
		getWait().until(ExpectedConditions.elementToBeClickable(goingTo));
		goingTo.sendKeys(Keys.ENTER);
		return new CruisePage(getDriver());
	}
//departure puede comenzar con minus
	public CruisePage Departure(String dep) throws Exception {
		getWait().until(ExpectedConditions.elementToBeClickable(departure));
		departure.click();
		departure.sendKeys(dep);
		getWait().until(ExpectedConditions.elementToBeClickable(departure));
		departure.sendKeys(Keys.ENTER);
		return new CruisePage(getDriver());
	}

	public CruiseResultPage searchCruise() {
		search.click();
		return new CruiseResultPage(getDriver());
	}
	

	
	
	


}
