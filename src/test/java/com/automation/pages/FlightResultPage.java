package com.automation.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.utils.SeleniumUtils;

public class FlightResultPage extends BasePage {
	public FlightResultPage(WebDriver driver) {
		super(driver);
	}

	private static final String XPATH_FIRSTRULES = "(//*[@class=\"btn-text toggle-trigger basic-economy-toggle-link icon icon-toggle180 uitk-col all-col-1-1 secondary-content\"])[1]";

	@FindBy(xpath = "//*[@id=\"sortDropdown\"]/option[3]")
	private WebElement sortBy;

	@FindBy(id = "sortDropdown")
	private WebElement sortDropdown;

	@FindBy(xpath = "//span[contains(@class,'duration')]")
	private WebElement durationFlight;

	@FindBy(xpath = "//span[contains(@class,'show-flight-details')]")
	private WebElement detailFlight;

	@FindBy(xpath = "//div[@class='grid-container standard-padding ']/div/div[2]/div/div[2]/button")
	private WebElement firstResult;

	@FindBy(xpath = "((//*[@class=\"flight-module segment offer-listing\"])[3]//*[@class=\"btn-secondary btn-action t-select-btn\"])[1]")
	private WebElement thirdResult;

	@FindBy(xpath = "(//*[@class=\"flight-module segment offer-listing\"])[3]//*[@class=\"btn-secondary btn-action t-select-btn\"]")
	private WebElement selectThisFare;

	@FindBy(xpath = "(//*[@class=\"btn-secondary btn-action t-select-btn\"])[1]")
	private WebElement firstThisFare;

	@FindBy(id = "forcedChoiceNoThanks")
	private WebElement noThanks;

	@FindBy(xpath = "//*[@class=\"flight-module segment offer-listing\"][3]//*[@class=\"btn-text toggle-trigger basic-economy-toggle-link icon icon-toggle180 uitk-col all-col-1-1 secondary-content\"]")
	private WebElement rulesAndRestrictions;
	@FindBy(xpath = XPATH_FIRSTRULES)
	private WebElement firstRules;

//This method verify the amount of elements
	public FlightResultPage testListOfElements() {
		SeleniumUtils.visibilityToAllElements(driver, 30, By.id("flightModuleList"));
		List<WebElement> objLink = driver.findElements(By.id("flightModuleList"));
		int sizeSelect = 0;
		int sizeDetail = 0;
		int sizeDuration = 0;
		int bcontainer = objLink.size();

		for (@SuppressWarnings("unused") WebElement objCurrentLink : objLink) {

			List<WebElement> containerGrid = driver
			        .findElements(By.xpath("//div[contains(@class,'grid-container standard-padding ')]"));

			for (@SuppressWarnings("unused") WebElement objFlightLink : containerGrid) {

				System.out.println("Size of selects button: " + sizeSelect);
				System.out.println("Size of detail button: " + sizeDetail);
				System.out.println("Size of duration button: " + sizeDuration);

				for (int i = 0; i < bcontainer; i++) {
					if (driver
					        .findElement(
					                By.xpath(".//button[contains(@class,'btn-secondary btn-action t-select-btn')]"))
					        .isDisplayed()) {
						sizeSelect++;
					}

					if (driver.findElement(By.xpath(".//span[contains(@class,'show-flight-details')]")).isDisplayed()) {
						sizeDetail++;
					}

					if (driver.findElement(By.xpath(".//span[contains(@class,'medium-bold')]")).isDisplayed()) {
						sizeDuration++;
					}

				}
			}
		}
		return new FlightResultPage(getDriver());

	}
//This method 
	public boolean sortedVerify() {
		getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sortDropdown")));
		sortDropdown.click();
		sortDropdown.sendKeys("Duration (Shortest)" + Keys.TAB);
		getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".duration-sort")));
		List<WebElement> flightDuration = driver
		        .findElements(By.xpath("//div[contains(@class,'grid-container standard-padding ')]"));
		List<String> fdText = new ArrayList<>();
		List<String> fdTextSorted = new ArrayList<>();

		for (WebElement fd : flightDuration) {
			String text = fd.getText();
			if (text.startsWith("1h")) {
				text = text.replace("1h", "01h");
			}
			if (text.startsWith("2h")) {
				text = text.replace("2h", "02h");
			}
			if (text.startsWith("3h")) {
				text = text.replace("3h", "03h");
			}
			if (text.startsWith("4h")) {
				text = text.replace("4h", "04h");
			}
			if (text.startsWith("5h")) {
				text = text.replace("5h", "05h");
			}
			if (text.startsWith("6h")) {
				text = text.replace("6h", "06h");
			}
			if (text.startsWith("7h")) {
				text = text.replace("7h", "07h");
			}
			if (text.startsWith("8h")) {
				text = text.replace("8h", "08h");
			}
			if (text.startsWith("9h")) {
				text = text.replace("9h", "09h");
			}
			text = text.replace(" 1m", " 01m");
			text = text.replace(" 2m", " 02h");
			text = text.replace(" 3m", " 03m");
			text = text.replace(" 4m", " 04m");
			text = text.replace(" 5m", " 05m");
			text = text.replace(" 6m", " 06m");
			text = text.replace(" 7m", " 07m");
			text = text.replace(" 8m", " 08m");
			text = text.replace(" 9m", " 09m");

			fdText.add(text);
			fdTextSorted.add(text);
		}
		Collections.sort(fdTextSorted);
		return fdText.equals(fdTextSorted);
	}

	public FlightResultPage selectFirstResult() throws InterruptedException {
		boolean resultRules = false;
		try {
			SeleniumUtils.visibilityToAllElements(driver, 20, By.xpath(XPATH_FIRSTRULES));
			resultRules = true;
			System.out.println("Rules Present");
		} catch (Exception e) {
			System.out.println("Rules not present");
			resultRules = false;
		}
		firstResult.click();
		if (resultRules == true) {
			Thread.sleep(2000);
			firstThisFare.click();
		} else {
			System.out.println("Rules not Present");
		}
		return new FlightResultPage(getDriver());
	}

	public FlightInformation selectThirdResult() throws InterruptedException {
		boolean resultRules = false;
		try {
			SeleniumUtils.visibilityToAllElements(driver, 20, By.xpath(
			        "(//*[@class=\"flight-module segment offer-listing\"])[3]//*[@class=\"btn-text toggle-trigger basic-economy-toggle-link icon icon-toggle180 uitk-col all-col-1-1 secondary-content\"]"));
			resultRules = true;
			System.out.println("Rules Present");
		} catch (Exception e) {
			System.out.println("Rules not present");
			resultRules = false;
		}
		thirdResult.click();
		if (resultRules == true) {
			Thread.sleep(2000);
			selectThisFare.click();
		} else {
			System.out.println("Rules not Present");
		}
		SeleniumUtils.visibilityToAllElements(driver, 20, By.id("forcedChoiceNoThanks"));
		driver.findElement(By.id("forcedChoiceNoThanks")).click();
		System.out.println(driver.getTitle());
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentId =it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		return new FlightInformation(getDriver());
	}

}