package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;

public class UserLogin {

	private final WebDriver driver;
	private WebElement signIn;
	private WebElement userName;
	private WebElement passwordField;
	private WebElement logInButton;
	private WebElement logInVerification;

	public UserLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void signInButton() {
		signIn = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
		signIn.click();
		TestUtils.testSleep();
	}

	public void userNameField(String username) {
		userName = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		userName.sendKeys(username);
		TestUtils.testSleep();
	}

	public void passwordField(String password) {
		passwordField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='password'])[1]")));
		passwordField.clear();
		passwordField.sendKeys(password);
		TestUtils.testSleep();
	}

	public void logInButtonClick() {
		logInButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
		logInButton.click();
		TestUtils.testSleep();
	}

	public void verifyLogIn() {
		logInVerification = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#WelcomeContent")));
		assertEquals(logInVerification.getText(), "Welcome Pet!");
		TestUtils.testSleep();
	}

}
