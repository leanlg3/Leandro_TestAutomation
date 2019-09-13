package com.automation.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.SeleniumUtils;

public class PackageResultPage extends BasePage {
	public PackageResultPage(WebDriver driver) {
		super(driver);
	}

	private final String XPATH_DESTINATION = "//*[@class='labelRow destination']";
	private final String XPATH_HOTEL = "(//a[contains(@class,'flex-link')])[1]";
	private final String Xpath_opay = "//*[@class='opi-overlay']";

	@FindBy(xpath = "//*[@class='labelRow origin']")
	private WebElement origin;

	@FindBy(xpath = XPATH_HOTEL)
	private WebElement firstHotel;

	@FindBy(xpath = XPATH_DESTINATION)
	private WebElement destiny;

	@FindBy(xpath = "labelRow dates")
	private WebElement dates;

	@FindBy(xpath = "//*[@class='labelRow rooms']")
	private WebElement rooms;

	@FindBy(xpath = "//*[@class='labelRow travelers']")
	private WebElement travelers;

	@FindBy(xpath = "//*[@id=\"sortContainer\"]/div/div/div[2]/div/fieldset/ul/li[3]/button")
	private WebElement priceSort;

	public String getOrigin() {
		return origin.getText();
	}

	public String getDestiny() {
		SeleniumUtils.visibilityToAllElements(driver, 60, By.xpath(XPATH_DESTINATION));
		return destiny.getText();
	}

	public String getDates() {
		return dates.getText();
	}

	public String getRooms() {
		return rooms.getText();
	}

	public String getTravelers() {
		return travelers.getText();
	}

	// Verify the results were correctly sorted
	// after sort by Price.
	public boolean sortedVerify() {
		priceSort.click();
		SeleniumUtils.visibilityToAllElements(driver, 20, By.id("resultsContainer"));
		List<WebElement> flightPrice = driver.findElements(By.id("resultsContainer"));
		ArrayList<String> fdText = new ArrayList<>();
		ArrayList<String> fdTextSorted = new ArrayList<>();
		for (WebElement fd : flightPrice) {
			String text = fd.findElement(By.xpath("//li[@class='actualPrice price fakeLink ']")).getText();
			if (text.contains("$")) {
				fdText.add(text);
				System.out.println("Precio ordenado");
			}

			fdTextSorted.add(text);
		}
		Collections.sort(fdTextSorted);
		return fdText.equals(fdTextSorted);
	}

	public RoomsPage chooseRoom() throws InterruptedException {
		SeleniumUtils.visibilityToAllElements(driver, 10, By.id("star3"));
		driver.findElement(By.id("star3")).click();
		for (int i = 0; i < 10; i++) {
			boolean exitFlag = true;
			try {
				SeleniumUtils.invisibilityToAllElements(driver, 10, By.xpath(Xpath_opay));
				Thread.sleep(6000);
				firstHotel.click();
			} catch (TimeoutException e) {
				Thread.sleep(300);
				e.printStackTrace();
				exitFlag = false;
			}
			if (exitFlag) {
				break;
			}
		}
		SeleniumUtils.windowsChange(driver);
		return new RoomsPage(getDriver());
	}
}
