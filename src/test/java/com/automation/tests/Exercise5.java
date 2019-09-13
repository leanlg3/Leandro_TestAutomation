package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.CruiseInfoPage;
import com.automation.pages.CruisePage;
import com.automation.pages.CruiseResultPage;
import com.automation.pages.TravelHomePage;

public class Exercise5 extends BaseTests {

	@Test
	public void selectCruise() throws Exception {
		TravelHomePage home = getTravelHomePage();
		CruisePage cruisePage = home.changeToCruises();
		cruisePage.goTo("Europe");
		cruisePage.Departure("March");
		CruiseResultPage cruiseResutlPage = cruisePage.searchCruise();
		cruiseResutlPage.popUp();
		Assert.assertEquals(cruiseResutlPage.getGoingText(),"Europe");
		Assert.assertEquals(cruiseResutlPage.getDepartureText(),"Mar 2019");
		cruiseResutlPage.cruiseLength();
		CruiseInfoPage cruiseInfoPage = cruiseResutlPage.selectDiscount();
		String durationText = cruiseResutlPage.getDuration();
		String departureText = cruiseResutlPage.getDepartingInfo();
		String durationText2 = cruiseInfoPage.getDepartureDate();
		String departureText2 = cruiseInfoPage.getDeparturePort();
		Assert.assertTrue(durationText.toLowerCase().contains(durationText2.toLowerCase()), "Check date from Cruise page to Info Page");
		Assert.assertTrue(departureText.contains(departureText2), "Check departure from Cruise page to Info page");
	}
}
