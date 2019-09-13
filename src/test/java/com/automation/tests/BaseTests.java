package com.automation.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.pages.FlightInformation;
import com.automation.pages.FlightResultPage;
import com.automation.pages.TravelHomePage;

public class BaseTests {

	MyDriver myDriver;
		
	private TravelHomePage travelHome;
	private FlightResultPage flightResult;
	private FlightInformation flightInformation;
	
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(@Optional String browser) {
		if(null== browser) {
			browser = "chrome";
		}
		myDriver = new MyDriver(browser);
		travelHome = new TravelHomePage(myDriver.getDriver());
		
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		travelHome.dispose();
	}
	
	public TravelHomePage getTravelHomePage() {
		return travelHome;
	}
	
	public FlightResultPage getFlightResult() {
		flightResult = new FlightResultPage(myDriver.getDriver());
		return flightResult;
	}
	public FlightInformation getFlightInformation() {
		return flightInformation;
	}
	
	

}
