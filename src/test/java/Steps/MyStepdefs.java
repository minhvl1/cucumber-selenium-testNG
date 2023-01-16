package Steps;

import cucumberHooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageObject.GooglePageObject;
import org.apache.log4j.Logger;



public class MyStepdefs {

    WebDriver driver;

    private GooglePageObject googlePageObject;
    private static final Logger logger = Logger.getLogger(MyStepdefs.class);

    public MyStepdefs() {
//        BasicConfigurator.configure();
//        String log4jConfPath = "log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);
        this.driver = Hooks.openAndQuitBrowser();
        googlePageObject = new GooglePageObject(driver);
    }

    @Given("open browser")
    public void openBrowser() {
        driver.get("https://www.google.com.vn/?hl=vi");
        logger.info("===Open browser===");
    }

    @When("Search {string}")
    public void search(String arg0) {
        logger.info("===Start===");
        googlePageObject.sendKeySearchTextbox(arg0);

    }

    @And("Click search button")
    public void clickSearchButton() {
        googlePageObject.sendKeySearchTextbox("ENTER");
    }

    @Then("See result page")
    public void seeResultPage() {
        logger.info("===See result page===");
        System.out.println(driver.getCurrentUrl());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("URL contains {string}")
    public void urlContains(String arg0) {
        logger.info("===verify result page===");
        String url =driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(url.contains(arg0));
        softAssert.assertAll();
    }
}
