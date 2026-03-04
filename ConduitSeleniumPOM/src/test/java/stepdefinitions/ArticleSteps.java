package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import pages.*;

import java.util.List;
import java.util.Map;

public class ArticleSteps extends TestBase {

    LoginPage loginPage;
    NewArticlePage newArticlePage;
    ArticleDetailsPage articleDetailsPage;

    String dynamicTitle;   // store generated title

    @Given("user launches browser")
    public void launch_browser() {

        launchBrowser();
    }

    @Given("user opens conduit login page")
    public void open_login_page() {

        openUrl("https://conduit-realworld-example-app.fly.dev/#/login");

        loginPage = new LoginPage(driver);
        newArticlePage = new NewArticlePage(driver);
        articleDetailsPage = new ArticleDetailsPage(driver);
    }

    @When("user logs in with valid credentials")
    public void login_user() {

        loginPage.login("ravindra123@gmail.com","Test@123");
    }

    @When("user creates article {string} {string} {string}")
    public void create_article(String title,String description,String body) {

        // create unique title every run
        dynamicTitle = title + System.currentTimeMillis();

        newArticlePage.createArticle(dynamicTitle,description,body);
    }

    @Then("article should be created successfully")
    public void verify_create() {

        System.out.println("Article Created : " + dynamicTitle);
    }

    @When("user updates article using datatable")
    public void update_article(DataTable table) {

        List<Map<String,String>> data = table.asMaps();

        String body = data.get(0).get("body");

        articleDetailsPage.updateArticle(body);
    }

    @Then("article should be updated successfully")
    public void verify_update() {

        System.out.println("Article Updated");
    }

    @When("user deletes article using datatable")
    public void delete_article(DataTable table) {

        articleDetailsPage.deleteArticle();
    }

    @Then("article should be deleted successfully")
    public void verify_delete() {

        System.out.println("Article Deleted");

        quitBrowser();
    }
}