package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import randomCredentialsGenerator.RandomCredentialsGenerator;
import utils.TestUtils;

public class UserRegistration {

	private final WebDriver driver;

	private WebElement signInButton;
	private WebElement registerAccountButton;
	private WebElement userIDField;
	private WebElement newPasswordField;
	private WebElement repeatPasswordField;
	private WebElement firstNameField;
	private WebElement lastNameField;
	private WebElement emailField;
	private WebElement phoneField;
	private WebElement addressField;
	private WebElement cityField;
	private WebElement stateField;
	private WebElement zipField;
	private WebElement countryField;
	private WebElement favouriteCategory;
	private WebElement saveAccountInformationButton;

	private RandomCredentialsGenerator credentialsGenerator;

	public UserRegistration(WebDriver driver) {
		credentialsGenerator = new RandomCredentialsGenerator();
		this.driver = driver;
	}

	public void navigateToCreateAccount() {
		signInButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
		signInButton.click();
		registerAccountButton = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a[href='/actions/Account.action?newAccountForm=']")));
		registerAccountButton.click();

	}

	public void fillAccountInformation() {
		userIDField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		userIDField.sendKeys(credentialsGenerator.randomUserID);
		TestUtils.testSleep();

		newPasswordField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		newPasswordField.sendKeys(credentialsGenerator.randomNewPassword);
		TestUtils.testSleep();

		repeatPasswordField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("repeatedPassword")));
		repeatPasswordField.sendKeys(credentialsGenerator.randomNewPassword);
		TestUtils.testSleep();

		firstNameField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.firstName")));
		firstNameField.sendKeys(credentialsGenerator.randomFirstName);
		TestUtils.testSleep();

		lastNameField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.lastName")));
		lastNameField.sendKeys(credentialsGenerator.randomLastName);
		TestUtils.testSleep();

		emailField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.email")));
		emailField.sendKeys(credentialsGenerator.randomEmail);
		TestUtils.testSleep();

		phoneField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.phone")));
		phoneField.sendKeys(credentialsGenerator.randomPhone);
		TestUtils.testSleep();

		addressField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.address1")));
		addressField.sendKeys(credentialsGenerator.randomAddress);
		TestUtils.testSleep();

		cityField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.city")));
		cityField.sendKeys(credentialsGenerator.randomCity);
		TestUtils.testSleep();

		stateField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.state")));
		stateField.sendKeys(credentialsGenerator.randomState);
		TestUtils.testSleep();

		zipField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.zip")));
		zipField.sendKeys(credentialsGenerator.randomZip);
		TestUtils.testSleep();

		countryField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("account.country")));
		countryField.sendKeys(credentialsGenerator.randomCountry);
		TestUtils.testSleep();

		favouriteCategory = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("select[name='account.favouriteCategoryId']")));
		favouriteCategory.sendKeys("DOGS");
		TestUtils.testSleep();

	}

	public void clickSaveAccountInformationButton() {
		saveAccountInformationButton = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Save Account Information']")));
		saveAccountInformationButton.click();

	}

	public void accountCreated() {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://petstore.octoperf.com/actions/Catalog.action");
	}
}
