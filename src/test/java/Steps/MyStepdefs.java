package Steps;

import cucumberHooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageObject.GooglePageObject;

public class MyStepdefs {

    WebDriver driver;

    private GooglePageObject googlePageObject;

    public MyStepdefs() {
        this.driver = Hooks.openAndQuitBrowser();
        googlePageObject = new GooglePageObject(driver);
    }

    @Given("open browser")
    public void openBrowser() {
        driver.get("https://www.google.com.vn/?hl=vi");
    }

    @When("Search {string}")
    public void search(String arg0) {
        googlePageObject.sendKeySearchTextbox(arg0);
    }

    @And("Click search button")
    public void clickSearchButton() {
        googlePageObject.sendKeySearchTextbox("ENTER");
    }

    @Then("See result page")
    public void seeResultPage() {
        System.out.println(driver.getCurrentUrl());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("URL contains {string}")
    public void urlContains(String arg0) {
        String url =driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(url.contains(arg0));
        softAssert.assertAll();
    }
}
