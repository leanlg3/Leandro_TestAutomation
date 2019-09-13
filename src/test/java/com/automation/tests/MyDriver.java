package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	private WebDriver driver;

	public MyDriver(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_XPI_PROPERTY,
			        "C:\\Users\\leandro.barrios\\Downloads\\globant TA\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
		default:
			System.setProperty("webdriver.chrome.driver",
			        "C:\\Users\\leandro.barrios\\Downloads\\globant TA\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}

	}

	public WebDriver getDriver() {
		return this.driver;

	}
}
