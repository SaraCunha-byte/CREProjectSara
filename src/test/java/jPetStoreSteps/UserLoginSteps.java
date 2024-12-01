package jPetStoreSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UserLogin;
import testsWebDriver.testsWebDriver;

public class UserLoginSteps {
	testsWebDriver testsWebDriver;
	WebDriver driver;
	UserLogin userLogin;

	public UserLoginSteps(testsWebDriver webDriver) {
		this.testsWebDriver = webDriver;
		this.driver = testsWebDriver.getDriver();
		userLogin = new UserLogin(driver);
	}

	@And("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		userLogin.signInButton();
	}

	@When("I enter my {string} and {string}")
	public void i_enter_my_username_and_password(String username, String password) {
		userLogin.userNameField(username);
		userLogin.passwordField(password);
	}

	@And("I click the Login button")
	public void i_click_the_login_button() {
		userLogin.logInButtonClick();
	}

	@Then("I should see a welcome message")
	public void i_should_see_a_welcome_message() {
		userLogin.verifyLogIn();
	}

}
