package testscripts;

import org.testng.annotations.*;
import base.TestBase;
import pages.LoginPage;
import pages.NewArticlePage;
import pages.ArticleDetailsPage;

public class ConduitTest extends TestBase {

    LoginPage loginPage;
    NewArticlePage newArticlePage;
    ArticleDetailsPage articleDetailsPage;

    @BeforeMethod
    public void setup() {

        launchBrowser();
        openUrl("https://conduit-realworld-example-app.fly.dev/#/login");

        loginPage = new LoginPage(driver);
        newArticlePage = new NewArticlePage(driver);
        articleDetailsPage = new ArticleDetailsPage(driver);
    }

    @Test(description = "Create and update Delete Article Flow")
    public void conduitFlowTest() {

    	loginPage.login("ravindra123@gmail.com","Test@123");

    	newArticlePage.createArticle(
    	        "My name is Ravindra",
    	        "About Ravi",
    	        "This article created"
    	);

    	// UPDATE ARTICLE
    	articleDetailsPage.updateArticle("This article updated by Ravindra");
    	articleDetailsPage.updateArticle("Updated text");

    	articleDetailsPage.deleteArticle();
    }

    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }
}