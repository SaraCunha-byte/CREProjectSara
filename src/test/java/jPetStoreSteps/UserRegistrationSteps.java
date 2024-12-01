package jPetStoreSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UserRegistration;
import testsWebDriver.testsWebDriver;

public class UserRegistrationSteps {
	testsWebDriver testsWebDriver;
	WebDriver driver;
	UserRegistration userRegistration;
	
	public UserRegistrationSteps(testsWebDriver webDriver) {
		this.testsWebDriver = webDriver;
		this.driver = testsWebDriver.getDriver();
		userRegistration = new UserRegistration(driver);
	}
	
	@And("I navigate to the Account registration page")
	public void i_navigate_to_the_account_registration_page() {
	    userRegistration.navigateToCreateAccount();
	}
	
	@When("I fill out the required account information with valid values")
	public void i_fill_out_the_required_account_information_with_valid_values() {
	    userRegistration.fillAccountInformation();
	}
	
	@And("I click the Save Account Information button")
	public void i_click_the_save_account_information_button() {
	    userRegistration.clickSaveAccountInformationButton();
	}
	
	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() {
	    userRegistration.accountCreated();
	}

}
