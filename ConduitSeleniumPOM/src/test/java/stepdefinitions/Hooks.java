package stepdefinitions;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks extends TestBase {

    @Before
    public void setUp() {

        launchBrowser();   // creates driver
        openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
    }

    @After
    public void tearDown() {

        quitBrowser();
    }
}