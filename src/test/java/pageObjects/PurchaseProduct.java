package pageObjects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import randomCredentialsGenerator.RandomCredentialsGenerator;
import utils.TestUtils;

public class PurchaseProduct {
	private final WebDriver driver;

	private UserLogin userLogin;
	private SearchAndCheckProducts searchAndCheckProducts;
	private AddProductToCart addProductsToCart;
	private WebElement proceedToCheckOut;
	private WebElement cardTypeField;
	private WebElement continueButton;
	private WebElement confirmButton;
	private WebElement orderConfirmation;

	public PurchaseProduct(WebDriver driver) {
		new RandomCredentialsGenerator();
		this.driver = driver;
		this.userLogin = new UserLogin(driver); // Instantiate UserLogin
		this.addProductsToCart = new AddProductToCart(driver); // Instantiate AddProductToCart
		this.searchAndCheckProducts = new SearchAndCheckProducts(driver);
	}

	public void accountLogin(String username, String password) {
		userLogin.signInButton();
		userLogin.userNameField(username);
		userLogin.passwordField(password);
		userLogin.logInButtonClick();
		userLogin.verifyLogIn();
	}

	public void searchAndAddToCart(String searchTerm) {
		searchAndCheckProducts.searchItem(searchTerm);
		searchAndCheckProducts.clickSearchButton();
		addProductsToCart.selectProduct(searchTerm);
		addProductsToCart.addToCart();
	}

	public void productCheckOut() {
		proceedToCheckOut = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Proceed to Checkout']")));
		proceedToCheckOut.click();
	}

	public void paymentDetails() {
		cardTypeField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='order.cardType']")));
		cardTypeField.sendKeys("MasterCard");
		TestUtils.testSleep();
	}

	public void continueOrder() {
		continueButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='newOrder']")));
		continueButton.click();
	}

	public void confirmOrder() {
		confirmButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Confirm']")));
		confirmButton.click();
	}

	public void orderConfirmed() {
		orderConfirmation = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul[class='messages'] li")));
		assertEquals(orderConfirmation.getText(), "Thank you, your order has been submitted.");
	}
}
