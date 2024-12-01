package jPetStoreSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.AddProductToCart;
import pageObjects.SearchAndCheckProducts;
import testsWebDriver.testsWebDriver;

public class AddProductToCartSteps {
	testsWebDriver testsWebDriver;
	WebDriver driver;
	AddProductToCart addProductsToCart;
	SearchAndCheckProducts searchAndCheckProducts;

	public AddProductToCartSteps(testsWebDriver webDriver) {
		this.testsWebDriver = webDriver;
		this.driver = testsWebDriver.getDriver();
		this.addProductsToCart = new AddProductToCart(driver);
		this.searchAndCheckProducts = new SearchAndCheckProducts(driver);
	}

	@And("I click on the item after searching {string}")
	public void i_click_on_the_item_after_searching(String searchTerm) {
		searchAndCheckProducts.clickSearchButton();
		addProductsToCart.selectProduct(searchTerm);
	}

	@Then("I click on the Add to cart button")
	public void i_click_on_the_add_to_cart_button() {
		addProductsToCart.addToCart();
	}
}
