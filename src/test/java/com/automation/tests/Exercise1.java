package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.FlightInformation;
import com.automation.pages.FlightPage;
import com.automation.pages.FlightResultPage;
import com.automation.pages.TravelHomePage;

public class Exercise1 extends BaseTests {

	@Test
	public void Excercise1() throws Exception {
		TravelHomePage home = getTravelHomePage();
		FlightPage flightPage = home.navigateToFlight();
		flightPage.selectfrom("LAS");
		flightPage.selectto("LAX");
		flightPage.datePicker();
		Assert.assertEquals(flightPage.getSearchButton(), "Search");
		FlightResultPage flightResultPage = flightPage.searchFlight();
		flightResultPage.testListOfElements();
		flightResultPage.sortedVerify();
		flightResultPage.selectFirstResult();
		FlightInformation flightInformation = flightResultPage.selectThirdResult();
		Assert.assertTrue(flightInformation.verifyDeparture(), "Check the departure information");
		Assert.assertTrue(flightInformation.verifyReturnInfo(), "Check the return information");
		Assert.assertTrue(flightInformation.verifyPriceGuarantee(),"Check if Price Guarantee is present");
		Assert.assertTrue(flightInformation.verifyTotalPrice(), "Check the total price");
		flightInformation.clickBookButton();
		Assert.assertTrue(flightInformation.verifyFirstName(), "Check if first name field is present");
		Assert.assertTrue(flightInformation.verifyMiddleName(), "Check if middle name field is present");
		Assert.assertTrue(flightInformation.verifyLastName(), "Check if last name field is present");
		Assert.assertTrue(flightInformation.verifyCountry(), "Check if country field is present");
		Assert.assertTrue(flightInformation.verifyPhone(), "Check if number phone field is present");
	}
}
