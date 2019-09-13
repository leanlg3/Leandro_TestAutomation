package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightPage extends BasePage {
	public FlightPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightsButton;
	
	@FindBy(xpath="//*[@id='flight-origin-hp-flight']")
	private WebElement flyingfrom;
	
	@FindBy(id="flight-destination-hp-flight")
	private WebElement flyingTo;
	
	@FindBy(xpath="//*[@id=\"gcw-flights-form-hp-flight\"]/div[3]/div[1]/div/div[1]/label/span[1]")
	private WebElement flyingTitle;
	
	@FindBy(id="flight-departing-hp-flight")
	private WebElement departing;
	
	@FindBy(id="flight-returning-hp-flight")
	private WebElement returning;
	
	@FindBy(xpath="//a[contains(@id,'aria-option-0')]")
	private WebElement firstResult;
	
	
	@FindBy(xpath="//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/div[2]/table/tbody/tr[2]/td[7]/button")
	private WebElement pickDateDeparting;
	
	@FindBy(xpath="//*[@id=\"flight-returning-wrapper-hp-flight\"]/div/div/div[2]/table/tbody/tr[3]/td[7]/button")
	private WebElement pickDateReturning;
	
	@FindBy(xpath="//button[contains(@class,'datepicker-paging datepicker-next btn-paging btn-secondary next')]")
	private WebElement nextbutton;
	
	@FindBy(xpath="//button[contains(@class,'datepicker-paging datepicker-next btn-paging btn-secondary next')]")
	private WebElement nextMonth;
	
	@FindBy(xpath="//*[@id=\"gcw-flights-form-hp-flight\"]/div[9]/label/button")
	private WebElement searchButton;

	
	public String getFlightTitle() {
		return  flyingTitle.getText();
	}
	
	public String getFlyingFrom() {
		return  flyingfrom.getText();
	}
	
	public String getFlyingTo() {
		return flyingTo.getText();
	}
	
	public String getSearchButton() {
		return searchButton.getText();
	}
	
	public FlightPage selectfrom(String from) {
		flightsButton.click();
		getWait().until(ExpectedConditions.elementToBeClickable(flightsButton));
		flyingfrom.sendKeys(from);
		getWait().until(ExpectedConditions.elementToBeClickable(firstResult));
		firstResult.click();
		return new FlightPage(getDriver());
	}
	
	public FlightPage selectto(String to) {
		flightsButton.click();
		getWait().until(ExpectedConditions.elementToBeClickable(flightsButton));
		flyingTo.sendKeys(to);
		getWait().until(ExpectedConditions.elementToBeClickable(firstResult));
		firstResult.click();	
		return new FlightPage(getDriver());
	}
	
	public FlightPage datePicker() {
		departing.click();
		nextMonth.click();
		nextMonth.click();
		pickDateDeparting.click();
		returning.click();
		pickDateReturning.click();
		return new FlightPage(getDriver());
	}
	
	public FlightResultPage searchFlight() {
		searchButton.click();
		return new FlightResultPage(getDriver());
	}

}
