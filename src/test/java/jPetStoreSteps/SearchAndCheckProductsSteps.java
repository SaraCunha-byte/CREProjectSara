package jPetStoreSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchAndCheckProducts;
import testsWebDriver.testsWebDriver;

public class SearchAndCheckProductsSteps {
	
	testsWebDriver testsWebDriver;
	WebDriver driver;
	SearchAndCheckProducts searchAndCheckProducts;
	
	public SearchAndCheckProductsSteps(testsWebDriver webDriver) {
	this.testsWebDriver = webDriver;
	this.driver = testsWebDriver.getDriver();
	searchAndCheckProducts = new SearchAndCheckProducts(driver);
	}
	
	@When("I enter {string} in the search bar")
	public void i_enter_in_the_search_bar(String searchTerm) {
		searchAndCheckProducts.searchItem(searchTerm);
	}
	
	@And("I click the Search button")
	public void i_click_the_search_button() {
		searchAndCheckProducts.clickSearchButton();
	}
	
	@Then("I should see a list of products related to {string}")
	public void i_should_see_a_list_of_products_related_to(String searchTerm) {
		searchAndCheckProducts.verifyIfProducFoundandClick();
	}
	
	@And("I searched for {string} and results are displayed")
	public void i_searched_for_and_results_are_displayed(String searchTerm) {
		searchAndCheckProducts.searchItem(searchTerm);
		searchAndCheckProducts.clickSearchButton();
		searchAndCheckProducts.verifyIfProducFoundandClick();
	}
	@When("I click on the first item")
	public void i_click_on_the_first_item() {
		searchAndCheckProducts.chooseProductFromList();
	}
	
	@Then("I should be redirected to the product details page")
	public void i_should_be_redirected_to_the_product_details_page() {
		searchAndCheckProducts.verifyProductDetails();
	}
	

}
