package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.SeleniumUtils;

public class CruiseInfoPage extends BasePage {
	public CruiseInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@class=\"small-title trip-title\"]")
	private WebElement duration;

	@FindBy(xpath = "//*[@class=\"departure-port\"]")
	private WebElement departurePort;

	public String getDeparturePort() {
		SeleniumUtils.visibilityToAllElements(driver, 20, By.xpath("//*[@class=\"departure-port\"]"));
		return departurePort.getText();
	}

	public String getDepartureDate() {
		SeleniumUtils.visibilityToAllElements(driver, 20, By.xpath("//*[@class=\"small-title trip-title\"]"));
		return duration.getText();
	}

}
