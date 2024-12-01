package pageObjects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestUtils;

public class SearchAndCheckProducts {
	private final WebDriver driver;
	private WebElement searchBarField;
	private WebElement searchButton;
	private WebElement productLink;
	private WebElement productList;
	private WebElement productName;
	private WebElement productID;
	private WebElement productPrice;

	public SearchAndCheckProducts(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String searchTerm) {
		searchBarField = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='keyword']")));
		searchBarField.sendKeys(searchTerm);
		TestUtils.testSleep();
	}

	public void clickSearchButton() {
		searchButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Search']")));
		searchButton.click();
		TestUtils.testSleep();
	}

	public void verifyIfProducFoundandClick() {
		productLink = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[normalize-space()='Friendly dog from England']")));
		assertEquals(productLink.getText(), "Friendly dog from England");
		productLink.click();
		TestUtils.testSleep();
	}

	public void chooseProductFromList() {
		productList = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='EST-6']")));
		assertEquals(productList.getText(), "EST-6");
		productList.click();
		TestUtils.testSleep();
	}

	public void verifyProductDetails() {
		productName = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//font[contains(text(),'Male Adult')]")));
		assertEquals(productName.getText(), "Male Adult Bulldog");
		productID = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[normalize-space()='EST-6']")));
		assertEquals(productID.getText(), "EST-6");
		productPrice = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='$18.50']")));
		assertEquals(productPrice.getText(), "$18.50");
		TestUtils.testSleep();
	}

}
