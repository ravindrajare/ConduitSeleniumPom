package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By emailField = By.cssSelector("input[placeholder='Email']");
    By passwordField = By.cssSelector("input[placeholder='Password']");
    By loginButton = By.cssSelector("button.btn.btn-lg.btn-primary");

    // Better locator for New Article
    By newArticleLink = By.linkText("New Article");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login(String email, String password) {

        // Wait for email field
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));

        // Enter credentials
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        // Click login
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        // Wait until login success (New Article visible)
        wait.until(ExpectedConditions.visibilityOfElementLocated(newArticleLink));
    }
}