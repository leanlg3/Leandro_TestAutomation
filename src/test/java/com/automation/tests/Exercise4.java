package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.PackagePage;
import com.automation.pages.TravelHomePage;

public class Exercise4 extends BaseTests {

	@Test
	public void selectFlight() {
		TravelHomePage home = getTravelHomePage();
		PackagePage packagePage = home.changeToPackage();
		packagePage.datePicker();
		packagePage.selectfrom("LAS");
		packagePage.selectTo("LAX");
		packagePage.newDatePicker();
		Assert.assertEquals(packagePage.getOffer(),
				"Your partial check-in and check-out dates must fall within your arrival and departure dates. Please review your dates.");
	}
}
