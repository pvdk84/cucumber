package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikipediaScreenTestSteps {

    private WebDriver driver = null;
    private WebDriverWait wait = null;
    private String url = null;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait =  new WebDriverWait(driver, 10);
        url = "https://en.wikipedia.org/wiki/Main_Page";
    }

    @Given("^that I am on the Wikipedia homepage$")
    public void goToWikipedia() {
        this.setUp();
        driver.get(url);
    }

    @When("^I search for \"(.*?)\"$")
    public void searchFor(String searchRequest) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchInput")));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchButton")));
        searchField.sendKeys(searchRequest);
        searchButton.click();
    }

    @Then("^I should be redirected to the page of Cucumber \\(software\\)$")
    public void checkPageOfCucumber() {
        String pageTitle = "Cucumber (software) - Wikipedia";
        wait.until(ExpectedConditions.titleIs(pageTitle));
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(pageTitle));
    }

    @And("^not to the page of the vegetable cucumber$")
    public void checkNotPageOfVegetable() throws InterruptedException {
        String otherPageTitle = "Cucumber = Wikipedia";
        Assert.assertFalse(driver.getTitle().equalsIgnoreCase(otherPageTitle));
        this.breakDown();
    }

    private void breakDown() throws InterruptedException {
        Thread.sleep(3000); // otherwise too fast
        driver.quit();
        url = null;
        driver = null;
        wait = null;
    }
}
