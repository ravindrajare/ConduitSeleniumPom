package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    By userName = By.cssSelector("input[placeholder='Your Name']");
    By email = By.cssSelector("input[placeholder='Email']");
    By password = By.cssSelector("input[placeholder='Password']");
    By signUpBtn = By.xpath("//button[text()='Sign up']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void register(String name, String mail, String pass) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));

        driver.findElement(userName).sendKeys(name);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signUpBtn).click();

        // Wait until New Article link is visible (means login success)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'New Article')]")
        ));
    }
}