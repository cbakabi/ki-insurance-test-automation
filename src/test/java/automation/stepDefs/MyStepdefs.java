package automation.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class MyStepdefs {

    private static final String BASE_URL = "https://forms.gle/eiiqRfHiRAiCXgPX7";
    private static final Logger LOGGER = LoggerFactory.getLogger(MyStepdefs.class);
    private WebDriver driver;

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
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[3]/div[1]")).click();
    }

    @And("I click the button to See my pending quotes")
    public void iClickTheButtonToSeeMyPendingQuotes() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/label[1]/div[1]/div[1]/div[1]/div[3]/div[1]")).click();
    }

    @And("I click the button to the next page")
    public void iClickTheButtonToTheNextPage() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]")).click();
    }

    @Then("I select a country from the drop down menu for primary country {string}")
    public void iSelectACountryFromTheDropDownMenuForPrimaryCountry(String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement questionGroups =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(questionGroups).perform();
        wait.until(ExpectedConditions.elementToBeClickable(questionGroups.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[@role='listbox']"))));
        questionGroups.click();
        String selectionXpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[contains(@data-value, '" + country + "')]";
        WebElement selection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectionXpath)));
        actions.moveToElement(selection).perform();
        wait.until(ExpectedConditions.elementToBeClickable(questionGroups.findElement(By.xpath(selectionXpath))));
        selection.click();
    }

    @Then("I select a company from the drop down menu for primary insured {string}")
    public void iSelectACompanyFromTheDropDownMenuForPrimaryInsured(String primaryInsured) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement questionGroups =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div[1]/div[1]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(questionGroups).perform();
        wait.until(ExpectedConditions.elementToBeClickable(questionGroups.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div[@role='listbox']"))));
        questionGroups.click();
        String selectionXpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[2]/div[contains(@data-value, '" + primaryInsured + "')]";
        WebElement selection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectionXpath)));
        actions.moveToElement(selection).perform();
        wait.until(ExpectedConditions.elementToBeClickable(questionGroups.findElement(By.xpath(selectionXpath))));
        selection.click();
    }

    @Then("I select a business type from the list of options for class of business {string}")
    public void iSelectABusinessTypeFromTheListOfOptionsForClassOfBusiness(String businessType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Actions actions = new Actions(driver);
        WebElement radioButtons;

        if (businessType.equals("Cyber")){
            radioButtons = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[1]/div[contains(@data-value, '"+ businessType + "')]"))));
        }else if (businessType.equals("Energy")){
            radioButtons = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[1]/div[contains(@data-value, '"+ businessType + "')]"))));
        } else{
            radioButtons = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[1]/div[contains(@data-value, '"+ businessType + "')]"))));
        }
        actions.moveToElement(radioButtons).click().build().perform();
        radioButtons.click();
    }

    @When("I click on the Next button")
    public void iClickOnTheNextButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/span[1]/span[1]"))).click().build().perform();
        Thread.sleep(1000);
    }

    @Then("I input the Inception date {string}, {string}, {string}")
    public void iInputTheInceptionDate(String date, String month, String year)
        throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement dateElement =
        wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath(
                        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input"))).get(0);
    js.executeScript("arguments[0].setAttribute('value', '"+ date +"')",
     dateElement);
    actions.moveToElement(dateElement).click().build().perform();
        Thread.sleep(1000);
        WebElement dateEntry =
       driver.findElement(By.xpath("//input[@type='date']"));
        actions.moveToElement(dateEntry).sendKeys(date).build().perform();
        actions.moveToElement(dateEntry).sendKeys(month).build().perform();
        actions.moveToElement(dateEntry).sendKeys(year).build().perform();
    }

    @And("I enter the {string} for the quote")
    public void iEnterTheAUMValueForTheQuote(String aumValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Actions actions = new Actions(driver);
        WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div"))));
        textBox.click();
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div"))).sendKeys(aumValue).build().perform();

    }

    @And("I enter the {string} in dollars for the quote")
    public void iEnterThePremiumValueInDollarsForTheQuote(String premiumValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Actions actions = new Actions(driver);
        WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div"))));
        textBox.click();
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div"))).sendKeys(premiumValue).build().perform();

    }

    @Then("I leave the Ki Insurance Mock Platform page")
    public void iLeaveTheKiInsuranceMockPlatformPage() {
        driver.quit();
    }

    @Then("I verify that a quote for {string} is present in the pending quotes")
    public void iVerifyThatAQuoteForIsPresentInThePendingQuotes(String businessName) {
        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[contains(., '"+ businessName + "')]")));
    }

    @And("I verify that the class and premium is {string}")
    public void iVerifyThatTheClassAndPremiumIs(String values) {
        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[contains(., '"+ values + "')]")));
    }

    @And("I verify that the message body contains {string}")
    public void iVerifyThatTheMessageBodyContains(String message) {
        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div[contains(., '"+ message + "')]")));
    }

//    public static WebDriver driver;
//
//    @Given("I am on the Ki Insurance Mock Platform page")
//    public void iAmOnTheKiInsuranceMockPlatformPage() {
//        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get(BASE_URL);
//        LOGGER.info("Web automation testing begins");
//    }
//
//    @And("I click the button to Create a new quote")
//    public void iClickTheButtonToCreateANewQuote() {
//        String xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]/div[3]/div[1]";
//        ElementUtils.findElementByXpath(xpath);
//    }
//
//    @And("I click the button to See my pending quotes")
//    public void iClickTheButtonToSeeMyPendingQuotes() {
//        String xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/label[1]/div[1]/div[1]/div[1]/div[3]/div[1]";
//        ElementUtils.findElementByXpath(xpath);
//    }
//
//    @And("I click the button to the next page")
//    public void iClickTheButtonToTheNextPage() {
//        String xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]";
//        ElementUtils.findElementByXpath(xpath);
//    }
//
//    @Then("I select a country from the drop down menu for primary country {string}")
//    public void iSelectACountryFromTheDropDownMenuForPrimaryCountry(String country) {
//        String questionGroupsXpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]";
//        String selectionPath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[contains(@data-value, '";
//        String listBoxXpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[@role='listbox']";
//
//        ElementUtils.selectElementFromDropdownMenu(selectionPath, country, listBoxXpath, questionGroupsXpath);
//    }
//
//    @Then("I select a company from the drop down menu for primary insured {string}")
//    public void iSelectACompanyFromTheDropDownMenuForPrimaryInsured(String primaryInsured) {
//        String questionGroupsXpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div[1]/div[1]";
//        String selectionPath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[2]/div[contains(@data-value, '";
//        String listBoxXpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div[@role='listbox']";
//
//        ElementUtils.selectElementFromDropdownMenu(selectionPath, primaryInsured, listBoxXpath, questionGroupsXpath);
//    }
//
//    @Then("I select a business type from the list of options for class of business {string}")
//    public void iSelectABusinessTypeFromTheListOfOptionsForClassOfBusiness(String businessType) {
//        String cyberXpath = "/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[1]/label/div/div[1]/div[contains(@data-value, '";
//        String energyXpath = "/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[1]/div[contains(@data-value, '";
//        String propertyXpath = "/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[3]/label/div/div[1]/div[contains(@data-value, '";
//
//        ElementUtils.selectBusinessClass(cyberXpath, energyXpath, propertyXpath, businessType);
//    }
//
//    @When("I click on the Next button")
//    public void iClickOnTheNextButton() throws InterruptedException {
//        String xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/span[1]/span[1]";
//        ElementUtils.findElementByXpathWithActions(xpath);
//    }
//
//    @Then("I input the Inception date {string}, {string}, {string}")
//    public void iInputTheInceptionDate(String date, String month, String year)
//        throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        Actions actions = new Actions(driver);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement dateElement =
//            wait.until(
//                ExpectedConditions.elementToBeClickable(
//                    driver.findElement(
//                        By.xpath(
//                            "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]"))));
//        js.executeScript("arguments[0].setAttribute('date', '"+ date +"')", dateElement);
//
//        actions.moveToElement(dateElement).click().build().perform();
//        Thread.sleep(3000);
//        WebElement dateEntry =
//            driver.findElement(By.xpath("//input[@type='date']"));
//        actions.moveToElement(dateEntry).sendKeys(date).build().perform();
//        actions.moveToElement(dateEntry).sendKeys(month).build().perform();
//        actions.moveToElement(dateEntry).sendKeys(year).build().perform();
//
//    }
//
//    @And("I enter the {string} for the quote")
//    public void iEnterTheAUMValueForTheQuote(String aumValue) {
//        String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div";
//
//        ElementUtils.dataInput(xpath, aumValue);
//    }
//
//    @And("I enter the {string} in dollars for the quote")
//    public void iEnterThePremiumValueInDollarsForTheQuote(String premiumValue) {
//        String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div";
//
//        ElementUtils.dataInput(xpath, premiumValue);
//    }
//
//    @Then("I leave the Ki Insurance Mock Platform page")
//    public void iLeaveTheKiInsuranceMockPlatformPage() {
//        driver.quit();
//    }
//
//
//    @Then("I verify that the first quote is for {string}")
//    public void iVerifyThatTheFirstQuoteIsFor(String businessName) {
//        String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[contains(., '";
//        Assert.assertNotNull(ElementUtils.findTextElement(xpath, businessName));
//    }
//
//    @And("I verify that the class and premium is {string}")
//    public void iVerifyThatTheClassAndPremiumIs(String values) {
//        String xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[contains(., '";
//        Assert.assertNotNull(ElementUtils.findTextElement(xpath, values));
//    }
}
