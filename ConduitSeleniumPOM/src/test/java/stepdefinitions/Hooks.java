package stepdefinitions;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestBase {

    @Before
    public void setUp() {
        launchBrowser();
        openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
    }

    @After
    public void tearDown(Scenario scenario) {

        // Take screenshot only if scenario fails
        if (scenario.isFailed()) {

            final byte[] screenshot =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }

        quitBrowser();
    }
}