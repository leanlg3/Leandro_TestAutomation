package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.SeleniumUtils;

public class FlightInformation extends BasePage {
	public FlightInformation(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "bookButton")
	private WebElement bookButton;

	public FlightInformation clickBookButton() {
		bookButton.click();
		return new FlightInformation(getDriver());
	}

	public boolean verifyFirstName() {
		return SeleniumUtils.isPresent(driver, 10, By.id("firstname[0]"));
	}

	public boolean verifyMiddleName() {
		return SeleniumUtils.isPresent(driver, 10, By.id("middlename[0]"));
	}

	public boolean verifyLastName() {
		return SeleniumUtils.isPresent(driver, 10, By.id("lastname[0]"));
	}

	public boolean verifyPhone() {
		return SeleniumUtils.isPresent(driver, 10, By.id("phone-number[0]"));
	}

	public boolean verifyCountry() {
		return SeleniumUtils.isPresent(driver, 10, By.id("country_code[0]"));
	}

	public boolean verifyReturnInfo() {
		return SeleniumUtils.isPresent(driver, 15, By.xpath("(//*[@class='nonRefundableAfter24 nonTransferable nonChangeable'])[1]"));
	}

	public boolean verifyDeparture() {
		return SeleniumUtils.isPresent(driver, 15, By.xpath("//*[@class='importantInfoRuleOut0']"));
	}

	public boolean verifyTotalPrice() {
		return SeleniumUtils.isPresent(driver, 10, By.xpath("//*[@class='packagePriceTotal']"));
	}

	public boolean verifyPriceGuarantee() {
		return SeleniumUtils.isPresent(driver, 15, By.xpath("//*[@class='priceGuarantee']"));
	}

}
