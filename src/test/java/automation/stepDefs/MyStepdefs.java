package automation.stepDefs;

import automation.utils.ElementUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class MyStepdefs {

  private static final String BASE_URL = "https://forms.gle/eiiqRfHiRAiCXgPX7";
  private static final Logger LOGGER = LoggerFactory.getLogger(MyStepdefs.class);
  public WebDriver driver;
  ElementUtils elementUtils = new ElementUtils();

  @Given("I am on the Ki Insurance Mock Platform page")
  public void iAmOnTheKiInsuranceMockPlatformPage() {
    System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(BASE_URL);
    LOGGER.info("Web automation testing begins");
  }

  @And("I click the button to Create a new quote")
  public void iClickTheButtonToCreateANewQuote() {
    String xpath =
        "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[3]/div[1]";
    elementUtils.findElementByXpath(driver, xpath);
  }

  @And("I click the button to See my pending quotes")
  public void iClickTheButtonToSeeMyPendingQuotes() {
    String xpath =
        "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/label[1]/div[1]/div[1]/div[1]/div[3]/div[1]";
    elementUtils.findElementByXpath(driver, xpath);
  }

  @And("I click the button to the next page")
  public void iClickTheButtonToTheNextPage() {
    String xpath =
        "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]";
    elementUtils.findElementByXpath(driver, xpath);
  }

  @Then("I select a country from the drop down menu for primary country {string}")
  public void iSelectACountryFromTheDropDownMenuForPrimaryCountry(String country) {
    String questionGroupsXpath =
        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]";
    String selectionPath =
        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[contains(@data-value, '";
    String listBoxXpath =
        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[@role='listbox']";

    elementUtils.selectElementFromDropdownMenu(
        driver, selectionPath, country, listBoxXpath, questionGroupsXpath);
  }

  @Then("I select a company from the drop down menu for primary insured {string}")
  public void iSelectACompanyFromTheDropDownMenuForPrimaryInsured(String primaryInsured) {
    String questionGroupsXpath =
        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div[1]/div[1]";
    String selectionPath =
        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[2]/div[contains(@data-value, '";
    String listBoxXpath =
        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div[@role='listbox']";

    elementUtils.selectElementFromDropdownMenu(
        driver, selectionPath, primaryInsured, listBoxXpath, questionGroupsXpath);
  }

  @Then("I select a business type from the list of options for class of business {string}")
  public void iSelectABusinessTypeFromTheListOfOptionsForClassOfBusiness(String businessType) {
    String cyberXpath =
        "/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[1]/div[contains(@data-value, '";
    String energyXpath =
        "/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[1]/div[contains(@data-value, '";
    String propertyXpath =
        "/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[1]/div[contains(@data-value, '";

    elementUtils.selectBusinessClass(driver, cyberXpath, energyXpath, propertyXpath, businessType);
  }

  @When("I click on the Next button")
  public void iClickOnTheNextButton() throws InterruptedException {
    String xpath =
        "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/span[1]/span[1]";
    elementUtils.findElementByXpathWithActions(driver, xpath);
  }

  @Then("I input the Inception date {string}, {string}, {string}")
  public void iInputTheInceptionDate(String date, String month, String year)
      throws InterruptedException {
    elementUtils.dateEntry(driver, date, month, year);
  }

  @And("I enter the {string} for the quote")
  public void iEnterTheAUMValueForTheQuote(String aumValue) {
    String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div";

    elementUtils.dataInput(driver, xpath, aumValue);
  }

  @And("I enter the {string} in dollars for the quote")
  public void iEnterThePremiumValueInDollarsForTheQuote(String premiumValue) {
    String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div";

    elementUtils.dataInput(driver, xpath, premiumValue);
  }

  @Then("I verify that the first quote is for {string}")
  public void iVerifyThatTheFirstQuoteIsFor(String businessName) throws InterruptedException {
    String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[contains(., '";
    Assert.assertNotNull(elementUtils.findTextElement(driver, xpath, businessName));
  }

  @And("I verify that the class and premium is {string}")
  public void iVerifyThatTheClassAndPremiumIs(String values) throws InterruptedException {
    String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[contains(., '";
    Assert.assertNotNull(elementUtils.findTextElement(driver, xpath, values));
  }

  @Then("I verify that a quote for {string} is present in the pending quotes")
  public void iVerifyThatAQuoteForIsPresentInThePendingQuotes(String businessName) {
    Assert.assertNotNull(
        driver.findElement(
            By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[contains(., '" + businessName + "')]")));
  }

  @And("I verify that the message body contains {string}")
  public void iVerifyThatTheMessageBodyContains(String message) {
    Assert.assertNotNull(
        driver.findElement(
            By.xpath(
                "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div[contains(., '"
                    + message
                    + "')]")));
  }

  @Then("I leave the Ki Insurance Mock Platform page")
  public void iLeaveTheKiInsuranceMockPlatformPage() {
    driver.quit();
  }
}
