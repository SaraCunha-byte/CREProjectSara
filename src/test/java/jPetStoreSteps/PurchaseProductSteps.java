package jPetStoreSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PurchaseProduct;
import testsWebDriver.testsWebDriver;

public class PurchaseProductSteps {
	testsWebDriver testsWebDriver;
	WebDriver driver;
	PurchaseProduct purchaseProduct;

	public PurchaseProductSteps(testsWebDriver webDriver) {
		this.testsWebDriver = webDriver;
		this.driver = testsWebDriver.getDriver();
		purchaseProduct = new PurchaseProduct(driver);
	}

	@And("I am autenticated with {string} and {string}")
	public void i_am_autenticated_with_and(String username, String password) {
		purchaseProduct.accountLogin(username, password);
	}

	@And("I add a product to the cart using {string}")
	public void i_add_a_product_to_the_cart_using(String searchTerm) {
		purchaseProduct.searchAndAddToCart(searchTerm);
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		purchaseProduct.productCheckOut();
	}

	@And("I fill out my payment details")
	public void i_fill_out_my_payment_details() {
		purchaseProduct.paymentDetails();
	}

	@And("I click the Continue button")
	public void i_click_the_continue_button() {
		purchaseProduct.continueOrder();
	}

	@And("I confirm the order")
	public void i_confirm_the_order() {
		purchaseProduct.confirmOrder();
	}

	@Then("I should see a confirmation message")
	public void i_should_see_a_confirmation_message() {
		purchaseProduct.orderConfirmed();
	}

}
