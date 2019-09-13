package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.HotelPage;
import com.automation.pages.HotelResultPage;
import com.automation.pages.TravelHomePage;

public class Exercise3 extends BaseTests {

	@Test
	public void selectFlight() throws Exception {
		TravelHomePage home = getTravelHomePage();
		HotelPage hotelPage = home.changeToHotel();
		hotelPage.choiceFlight("Montevideo, Uruguay");
		hotelPage.datePicker();
		HotelResultPage hotelResult = hotelPage.searchFlight();
		Assert.assertEquals(hotelResult.getOffer(), "Get an extra 10% off");
	}
}
