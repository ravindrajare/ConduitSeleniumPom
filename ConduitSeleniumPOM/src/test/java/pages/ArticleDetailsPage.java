package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class ArticleDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    By deleteBtn = By.xpath("//button[contains(text(),'Delete Article')]");

    // ADD THESE (for update)
    By editBtn = By.xpath("//a[contains(text(),'Edit Article')]");
    By bodyField = By.cssSelector("textarea[placeholder='Write your article (in markdown)']");
    By updateBtn = By.xpath("//button[contains(text(),'Update Article')]");

    public ArticleDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // NEW METHOD (Update Article)
    public void updateArticle(String newBody) {

        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();

        WebElement body = wait.until(
                ExpectedConditions.visibilityOfElementLocated(bodyField)
        );

        body.clear();
        body.sendKeys(newBody);

        wait.until(ExpectedConditions.elementToBeClickable(updateBtn)).click();
    }

    public void deleteArticle() {

        wait.until(ExpectedConditions.urlContains("#/article/"));

        WebElement delBtn = wait.until(
                ExpectedConditions.elementToBeClickable(deleteBtn)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", delBtn);

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.urlContains("#/"));
    }
}