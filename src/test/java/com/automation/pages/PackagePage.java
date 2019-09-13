package com.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PackagePage extends BasePage {
	public PackagePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "#section-package-tab-hp")
	private WebElement packages;

	@FindBy(xpath = "//*[@id=\"package-returning-wrapper-hp-package\"]/div/div/div[3]/table/tbody/tr[3]/td[5]/button")
	private WebElement pickDateReturning;

	@FindBy(xpath = "//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/div[3]/table/tbody/tr[1]/td[7]/button")
	private WebElement pickDateDeparting;

	@FindBy(id = "package-departing-hp-package")
	private WebElement departing;

	@FindBy(id = "search-button-hp-package")
	private WebElement searchButton;

	@FindBy(id = "package-returning-hp-package")
	private WebElement returning;

	@FindBy(xpath = "//a[contains(@id,'aria-option-0')]")
	private WebElement firstResult;

	@FindBy(id = "package-origin-hp-package")
	private WebElement flyingfrom;

	@FindBy(id = "package-destination-hp-package")
	private WebElement flyingTo;

	@FindBy(xpath = "//button[contains(@class,'datepicker-paging datepicker-next btn-paging btn-secondary next')]")
	private WebElement nextMonth;

	@FindBy(id = "package-1-adults-hp-package")
	private WebElement adults;

	@FindBy(xpath = "//*[@id=\"package-checkin-wrapper-hp-package\"]/div/div/div[2]/table/tbody/tr[3]/td[5]/button")
	private WebElement newCheckIn;

	@FindBy(xpath = "//*[@id=\"package-checkout-wrapper-hp-package\"]/div/div/div[2]/table/tbody/tr[3]/td[6]/button")
	private WebElement newCheckOut;

	@FindBy(id = "partialHotelBooking-hp-package")
	private WebElement checkBox;

	@FindBy(xpath = "//*[@id=\"gcw-packages-form-hp-package\"]/div[2]/div/ul/li/a")
	private WebElement errorBelow;

	@FindBy(id = "package-checkin-hp-package")
	private WebElement checkin;

	@FindBy(id = "package-checkout-hp-package")
	private WebElement checkout;

	public PackagePage changeToPage() {
		getWait().until(ExpectedConditions.elementToBeClickable(packages));
		packages.click();
		return new PackagePage(getDriver());
	}

	public PackagePage selectfrom(String from) {
		getWait().until(ExpectedConditions.elementToBeClickable(flyingfrom));
		flyingfrom.sendKeys(from);
		getWait().until(ExpectedConditions.elementToBeClickable(firstResult));
		firstResult.click();
		return new PackagePage(getDriver());
	}

	public PackagePage selectTo(String to) {
		getWait().until(ExpectedConditions.elementToBeClickable(flyingTo));
		flyingTo.sendKeys(to);
		getWait().until(ExpectedConditions.elementToBeClickable(firstResult));
		firstResult.click();
		return new PackagePage(getDriver());
	}

	public PackagePage datePicker() {
		departing.click();
		nextMonth.click();
		nextMonth.click();
		pickDateDeparting.click();
		returning.click();
		pickDateReturning.click();
		return new PackagePage(getDriver());
	}

	public PackageResultPage searchFlight() {
		adults.sendKeys("1" + Keys.TAB);
		searchButton.click();
		return new PackageResultPage(getDriver());
	}

	public PackagePage newDatePicker() {
		checkBox.click();
		getWait().until(ExpectedConditions.elementToBeClickable(checkin));
		checkin.click();
		newCheckIn.click();
		checkout.click();
		newCheckOut.click();
		searchButton.click();
		return new PackagePage(getDriver());
	}

	public String getOffer() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return errorBelow.getText();
	}

}
