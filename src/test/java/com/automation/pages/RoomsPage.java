package com.automation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.SeleniumUtils;

public class RoomsPage extends BasePage {
	public RoomsPage(WebDriver driver) {
		super(driver);
	}

	private static final String XPATH_ROOM = "(//*[@class='btn btn-secondary btn-sub-action book-button'])[1]";
	private static final String XPATH_THIRD = "(//div[contains(@class,\"grid-container standard-padding \")])[3]//button";
	private static final String XPATH_FIRSTRESULT = "(//button[@class=\"btn-secondary btn-action t-select-btn\"])[1]";
	private static final String XPATH_FIRSTRULES = "(//*[@class=\"btn-text toggle-trigger basic-economy-toggle-link icon icon-toggle180 uitk-col all-col-1-1 secondary-content\"])[1]";
	private static final String XPATH_THIRDRULES = "(//*[contains(@class,'flight-module segment offer')])[3]//div[@class='basic-economy-tray uitk-grid']";
	private static final String XPATH_FIRSTFARE = "//li[contains(@class,\"flight-module segment offer-listing\")][1]//button[@class=\"btn-secondary btn-action t-select-btn\"]";
	private static final String XPATH_THIRDFARE = "//li[contains(@class,\"flight-module segment offer-listing\")][3]//button[@class=\"btn-secondary btn-action t-select-btn\"]";

	// optional "//section[@id='rooms-and-rates']/article[2]//a[@role='button']"
	@FindBy(xpath = XPATH_ROOM)
	private WebElement selectRoom;

	@FindBy(xpath = XPATH_FIRSTRESULT)
	private WebElement firstResult;

	@FindBy(xpath = XPATH_THIRD)
	private WebElement thirdResult;

	@FindBy(xpath = "//div[@class=\"uitk-col   gt-tile  no-redesign\"][1]//button[@class=\"btn-secondary btn-sub-action  gt-add-btn\"]")
	private WebElement selectCar;

	@FindBy(xpath = "(//*[@class='btn-primary btn-action'])[1]")
	private WebElement finalDetails;

	@FindBy(id = "firstname[0]")
	private WebElement firstName;

	@FindBy(xpath = "//*[@class=\"text col middle-name field-contact-middle-name traveler-name-label\"]//input")
	private WebElement middleName;

	@FindBy(id = "lastname[0]")
	private WebElement lastName;

	@FindBy(xpath = "//*[@class=\"cko-field country-code always-include gb-whitelist alpha3CountryCode\"]")
	private WebElement countryCode;

	@FindBy(xpath = "//*[@class=\"text phone-number contact-phone contact-primary\"]//input")
	private WebElement phoneNumber;

	@FindBy(xpath = XPATH_FIRSTRULES)
	private WebElement firstRules;

	@FindBy(xpath = XPATH_THIRDRULES)
	private WebElement thirdRules;

	@FindBy(xpath = XPATH_FIRSTFARE)
	private WebElement selectThisFare;

	@FindBy(xpath = XPATH_THIRDFARE)
	private WebElement thirdSelectFare;

	@FindBy(xpath = "//*[@class=\"tot-price-margin secondary\"]")
	private WebElement totalPrice;

	@FindBy(xpath = "(//*[@class=\"package-important-notice\"])[1]")
	private WebElement packInfo;

	@FindBy(xpath = "(//*[@class=\"important-info-default\"])[1]")
	private WebElement importantInfo;

	@FindBy(xpath = "//*[@id=\"flight-card-details\"]/div/div/div/div[1]/a")
	private WebElement spiritDetails;

	@FindBy(xpath = "//*[@class=\"btn-text toggle-trigger  flight-details-toggle secondary\"]")
	private WebElement flightBaggageDetails;

	public RoomsPage firstRoom() throws InterruptedException {

		try {
			System.out.println(driver.getTitle());
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			String parentId =it.next();
			String childId = it.next();
			driver.switchTo().window(childId);
			System.out.println(driver.getTitle());
			SeleniumUtils.visibilityToAllElements(driver, 10, By.xpath(XPATH_ROOM));
			selectRoom.click();
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println("Room not found");
		}

		return new RoomsPage(getDriver());
	}

	public RoomsPage firstFlight() throws InterruptedException {
		boolean resultRules = false;
		try {
			SeleniumUtils.visibilityToAllElements(driver, 20, By.xpath(XPATH_FIRSTRULES));
			resultRules = true;
			System.out.println("Rules Present");
		} catch (Exception e) {
			System.out.println("Element is not present");
			resultRules = false;
		}
		Thread.sleep(2000);
		firstResult.click();
		if (resultRules == true) {
			Thread.sleep(2000);
			selectThisFare.click();
		} else {
			System.out.println("Rules not Present");
		}
		return new RoomsPage(getDriver());
	}

	public RoomsPage thirdFlight() throws InterruptedException {
		boolean resultRules = false;
		try {
			SeleniumUtils.visibilityToAllElements(driver, 20, By.xpath(XPATH_THIRDRULES));
			resultRules = true;
			System.out.println("Rules Present");
		} catch (Exception e) {
			System.out.println("Element is not present");
			resultRules = false;
		}
		Thread.sleep(2000);
		thirdResult.click();
		if (resultRules == true) {
			Thread.sleep(2000);
			thirdSelectFare.click();
		} else {
			System.out.println("Rules not Present");
		}
		return new RoomsPage(getDriver());
	}

	public RoomsPage Car() {
		boolean resultRules = false;
		try {
			SeleniumUtils.isNotPresent(driver, 20, By.xpath(
			        "//div[@class=\\\"uitk-col   gt-tile  no-redesign\\\"][1]//button[@class=\\\"btn-secondary btn-sub-action  gt-add-btn\\\"]"));
			resultRules = true;
		} catch (NoSuchElementException e) {
			System.out.println("a car is present");
			resultRules = false;
		}
		if (resultRules == true) {
			System.out.println("a car is not present");
		} else {
			selectCar.click();
		}
		finalDetails.click();

		return new RoomsPage(getDriver());
	}

	public String getSearchButton() {
		return firstName.getText();
	}

	public boolean verifyFirstName() throws InterruptedException {
		Thread.sleep(2000);
		return firstName.isDisplayed();
	}

	public boolean verifyMiddleName() throws InterruptedException {
		Thread.sleep(2000);
		return middleName.isDisplayed();
	}

	public boolean verifyLastName() {
		return lastName.isDisplayed();
	}

	public boolean verifyPhone() {
		return phoneNumber.isDisplayed();
	}

	public boolean verifyCountry() throws InterruptedException {
		return countryCode.isDisplayed();
	}

}
