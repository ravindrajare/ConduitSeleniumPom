package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class NewArticlePage {

    WebDriver driver;
    WebDriverWait wait;

    By newArticleLink = By.xpath("//a[normalize-space()='New Article']");
    By title = By.cssSelector("input[placeholder='Article Title']");
    By desc = By.cssSelector("input[placeholder=\"What's this article about?\"]");
    By body = By.cssSelector("textarea[placeholder='Write your article (in markdown)']");
    By publishBtn = By.xpath("//button[normalize-space()='Publish Article']");

    public NewArticlePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void createArticle(String t, String d, String b) {

        wait.until(ExpectedConditions.elementToBeClickable(newArticleLink)).click();

        // Wait until URL changes to editor page
        wait.until(ExpectedConditions.urlContains("#/editor"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(title));

        driver.findElement(title).sendKeys(t);
        driver.findElement(desc).sendKeys(d);
        driver.findElement(body).sendKeys(b);

        wait.until(ExpectedConditions.elementToBeClickable(publishBtn)).click();

        wait.until(ExpectedConditions.urlContains("#/article/"));
    }
}