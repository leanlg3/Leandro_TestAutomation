package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.SeleniumUtils;

public class HotelResultPage extends BasePage {
	public HotelResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[contains(text(),'Get an extra 10% off')]")
	private WebElement Offer;

	public String getOffer() {
		SeleniumUtils.visibilityToAllElements(driver, 10, By.xpath("//*[contains(text(),'Get an extra 10% off')]"));
		return Offer.getText();
	}

}
