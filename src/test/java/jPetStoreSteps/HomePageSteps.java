package jPetStoreSteps;

import org.openqa.selenium.WebDriver;

import browserConfiguration.BrowserConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import testsWebDriver.testsWebDriver;

public class HomePageSteps {
	private final testsWebDriver testsWebDriver;
	private BrowserConfiguration browserConfiguration;

	public HomePageSteps(testsWebDriver testsWebDriver) {
		this.testsWebDriver = testsWebDriver;
		this.browserConfiguration = new BrowserConfiguration();
	}

	@Given("I am on the homepage using {string}")
	public void i_am_on_the_homepage_using(String browser) {
		WebDriver driver = this.browserConfiguration.startBrowser(browser);
		testsWebDriver.setDriver(driver);
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	}

	@After
	public void closeBrowser() {
		this.browserConfiguration.closeBrowser();
	}

}
