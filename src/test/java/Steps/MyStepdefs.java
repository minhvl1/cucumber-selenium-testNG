package Steps;

import cucumberHooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {

    WebDriver driver;

    public MyStepdefs() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @Given("open browser")
    public void openBrowser() {
        driver.get("https://www.google.com.vn/?hl=vi");
//        System.out.println("go to google");
    }

    @When("Search {string}")
    public void search(String arg0) {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(arg0);
//        System.out.println("search "+ arg0);
    }

    @And("Click search button")
    public void clickSearchButton() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
//        System.out.println("send key enter");
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
}
