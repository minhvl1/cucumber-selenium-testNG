package Steps;

import cucumberHooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ShadowRoot {
    WebDriver driver;

    public ShadowRoot() {
        this.driver = Hooks.openAndQuitBrowser();

    }

    @Given("go to selectorhub")
    public void goToSelectorhub() {
        driver.get("https://selectorshub.com/xpath-practice-page/");
    }

    @When("input username textbox")
    public void inputUsernameTextbox() {

        //Scroll intoview
        WebElement element = driver.findElement(By.xpath("//h2[text()='Memory Test']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        //single shadow
        //shadow root1
        WebElement shadowHost = driver.findElement(By.cssSelector("#userName"));
        SearchContext shadowRoot1 = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot1.findElement(By.cssSelector("#kils"));
        shadowContent.sendKeys("minh");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("input pizza textbox")
    public void inputPizzaTextbox() {

        //multiple shadow
        //shadow root2 in shadow 1
        WebElement shadowHost = driver.findElement(By.cssSelector("#userName"));
        SearchContext shadowRoot1 = shadowHost.getShadowRoot();
        WebElement app2 = shadowRoot1.findElement(By.cssSelector("#app2"));
        SearchContext shadowRoot2 = app2.getShadowRoot();
        WebElement pizza = shadowRoot2.findElement(By.cssSelector("#pizza"));
        pizza.sendKeys("PIZZA");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Given("go to shopee")
    public void goToShopee() {
        driver.get("https://shopee.vn/");
    }

    @When("close popup")
    public void closePopup() {
        WebElement shadowHost = driver.findElement(By.cssSelector("shopee-banner-popup-stateful[spacekey='PC-VN-HOME_POPUP_01']"));
        SearchContext shadowRoot1 = shadowHost.getShadowRoot();
        WebElement app2 = shadowRoot1.findElement(By.cssSelector(".shopee-popup__close-btn"));
        app2.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}