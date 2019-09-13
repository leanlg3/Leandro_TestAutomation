package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.PackagePage;
import com.automation.pages.PackageResultPage;
import com.automation.pages.RoomsPage;
import com.automation.pages.TravelHomePage;

public class Exercise2 extends BaseTests{	
	@Test
	public void selectFlight() throws Exception {
		TravelHomePage home = getTravelHomePage();
		PackagePage packagePage = home.changeToPackage();
		packagePage.selectfrom("LAS");
		packagePage.selectTo("LAX");
		packagePage.datePicker();
		PackageResultPage packageResultPage= packagePage.searchFlight();
		Assert.assertEquals(packageResultPage.getDestiny(), "DESTINATION");
		Assert.assertEquals(packageResultPage.getOrigin(), "ORIGIN");
		Assert.assertEquals(packageResultPage.getRooms(), "ROOMS");
		Assert.assertEquals(packageResultPage.getTravelers(), "TRAVELERS");
		packageResultPage.sortedVerify();
		RoomsPage roomPage = packageResultPage.chooseRoom();
		roomPage.firstRoom();
		roomPage.firstFlight();
		roomPage.thirdFlight();
		roomPage.Car();
		roomPage.verifyFirstName();
		roomPage.verifyCountry();
		roomPage.verifyLastName();
		roomPage.verifyMiddleName();
		roomPage.verifyPhone();
		
}


}

