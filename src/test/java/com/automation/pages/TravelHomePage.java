package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelHomePage extends BasePage {

	public TravelHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.travelocity.com/");
	}

	@FindBy(id = "tab-flight-tab-hp")
	private WebElement flightsButton;

	@FindBy(id = "tab-package-tab-hp")
	private WebElement packages;

	@FindBy(id = "tab-hotel-tab-hp")
	private WebElement hotelButton;

	@FindBy(id = "tab-cruise-tab-hp")
	private WebElement cruises;

	public FlightPage navigateToFlight() {
		flightsButton.click();
		getWait().until(ExpectedConditions.elementToBeClickable(flightsButton));
		return new FlightPage(getDriver());
	}

	public HotelPage changeToHotel() {
		getWait().until(ExpectedConditions.elementToBeClickable(hotelButton));
		hotelButton.click();
		return new HotelPage(getDriver());
	}

	public CruisePage changeToCruises() {
		getWait().until(ExpectedConditions.elementToBeClickable(cruises));
		cruises.click();
		return new CruisePage(getDriver());
	}

	public PackagePage changeToPackage() {
		packages.click();
		getWait().until(ExpectedConditions.elementToBeClickable(packages));
		return new PackagePage(getDriver());
	}

}