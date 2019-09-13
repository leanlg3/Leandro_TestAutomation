package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.SeleniumUtils;

public class CruiseResultPage extends BasePage {
	public CruiseResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"pax-popup-body\"]/button")
	private WebElement goButton;

	@FindBy(xpath = "(//input[@name='length-10-14'])[2]")
	private WebElement nights;

	@FindBy(id = "cruise-length-options")
	private WebElement cruiseLength;

	@FindBy(xpath = "//*[contains(@class, 'col cruise-card-content')]")
	private List<WebElement> cruiseDiscount;
	String durationInfo = null;
	String departingInfo = null;

	// this method is to verify the cruises with and without discount
	// and select the cruise with more discount

	public CruiseInfoPage selectDiscount() throws Exception {
		Thread.sleep(2000);
		List<WebElement> allContainers = driver
		        .findElements(By.xpath("//*[contains(@class, 'col cruise-card-content')]"));
		String discountXpath = ".//*[@class='message-flag flex-flag']";
		int greaterDiscount = 0;
		WebElement showIntinerary = null;
		WebElement selectCruise = null;
		WebElement greaterDiscountElement = null;
		for (WebElement cd : allContainers) {
			try {
				String discountText = cd.findElement(By.xpath(discountXpath)).getText();
				int discount = Integer.valueOf(discountText.replaceAll("[^0-9,]", ""));
				if (discount > greaterDiscount) {
					greaterDiscount = discount;
					greaterDiscountElement = cd;
				}
				System.out.println("Travel with discount: " + discount + "%");

			} catch (NoSuchElementException e) {
				System.out.println("Travel without discount");
			}
		}
		System.out.println("Travel with more discount: " + greaterDiscount + "%");
		showIntinerary = greaterDiscountElement.findElement(By.xpath(".//*[@class=\"btn-text toggle-trigger\"]"));
		selectCruise = greaterDiscountElement
		        .findElement(By.xpath(".//*[@class=\"btn btn-secondary btn-action select-sailing-button\"]"));
		durationInfo = greaterDiscountElement
		        .findElement(By.xpath(".//*[@class=\"title-on-ship-image\"]"))
		        .getText();
		departingInfo = greaterDiscountElement
		        .findElement(
		                By.xpath(".//*[@class=\"subtitle-on-ship-image\"]"))
		        .getText();
		showIntinerary.click();
		selectCruise.click();
		SeleniumUtils.windowsChange(driver);
		return new CruiseInfoPage(getDriver());

	}

	public String getDuration() {
		return durationInfo;
	}

	public String getDepartingInfo() {
		return departingInfo;
	}

	public CruiseResultPage popUp() {
		if (goButton.isDisplayed()) {
			goButton.click();
		}
		return new CruiseResultPage(getDriver());
	}

	public CruiseResultPage cruiseLength() {
		nights.click();
		return new CruiseResultPage(getDriver());
	}

	public String getGoingText() {
		return driver.findElement(By.id("destination-select")).getText();
	}

	public String getDepartureText() {
		return driver.findElement(By.id("month-select")).getText();
	}
}
