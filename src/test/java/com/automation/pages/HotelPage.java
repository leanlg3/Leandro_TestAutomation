package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelPage extends BasePage {
	public HotelPage(WebDriver driver) {
		super(driver);
	}

@FindBy(id="hotel-destination-hp-hotel")
private WebElement goingTO;

@FindBy(id="hotel-checkin-hp-hotel")
private WebElement Checkin;

@FindBy(id="hotel-checkout-hp-hotel")
private WebElement Checkout;

@FindBy(xpath="(//*[@class='btn-primary btn-action gcw-submit '])[2]")
private WebElement searchButton;

@FindBy(xpath="//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[3]/table/tbody/tr[1]/td[7]/button")
private WebElement dateCheckin;

@FindBy(xpath="//*[@id=\"hotel-checkout-wrapper-hp-hotel\"]/div/div/div[3]/table/tbody/tr[3]/td[5]/button")
private WebElement dateCheckout;

@FindBy(xpath="//*[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
private WebElement nextButton;

@FindBy(xpath="(//*[@class='results-item'])[1]")
private WebElement firstResult;


public HotelPage choiceFlight(String going) {
	getWait().until(ExpectedConditions.elementToBeClickable(goingTO));
	goingTO.sendKeys(going);
	getWait().until(ExpectedConditions.elementToBeClickable(firstResult));
	firstResult.click();
	return new HotelPage(getDriver());
	
}



public HotelResultPage searchFlight() {
	searchButton.click();
	return new HotelResultPage(getDriver());
}


public HotelPage datePicker(){
	Checkin.click();
	nextButton.click();
	nextButton.click();
	dateCheckin.click();
	Checkout.click();
	dateCheckout.click();
	return new HotelPage(getDriver());
}
}
