package automation.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
  WebDriverWait wait;
  Actions actions;

  public void findElementByXpath(WebDriver driver, String xpath) {
    driver.findElement(By.xpath(xpath)).click();
  }

  public void findElementByXpathWithActions(WebDriver driver, String xpath)
      throws InterruptedException {
    actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
    Thread.sleep(1000);
  }

  public WebElement findTextElement(WebDriver driver, String xpath, String quoteVariable)
      throws InterruptedException {
    Thread.sleep(1000);
    return driver.findElement(By.xpath(xpath + quoteVariable + "')]"));
  }

  public void selectElementFromDropdownMenu(
      WebDriver driver,
      String selectionPath,
      String variable,
      String listBoxXpath,
      String questionGroupsXpath) {
    actions = new Actions(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    WebElement questionGroups =
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(questionGroupsXpath)));

    actions.moveToElement(questionGroups).perform();
    wait.until(
        ExpectedConditions.elementToBeClickable(
            questionGroups.findElement(By.xpath(listBoxXpath))));
    questionGroups.click();

    String selectionXpath = selectionPath + variable + "')]";

    WebElement selection =
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectionXpath)));
    actions.moveToElement(selection).perform();
    wait.until(
        ExpectedConditions.elementToBeClickable(
            questionGroups.findElement(By.xpath(selectionXpath))));
    selection.click();
  }

  public void selectBusinessClass(
      WebDriver driver,
      String cyberXpath,
      String energyXpath,
      String propertyXpath,
      String businessType) {
    WebElement radioButtons;

    if (businessType.equals("Cyber")) {
      radioButtons =
          wait.until(
              ExpectedConditions.elementToBeClickable(
                  driver.findElement(By.xpath(cyberXpath + businessType + "')]"))));
    } else if (businessType.equals("Energy")) {
      radioButtons =
          wait.until(
              ExpectedConditions.elementToBeClickable(
                  driver.findElement(By.xpath(energyXpath + businessType + "')]"))));
    } else {
      radioButtons =
          wait.until(
              ExpectedConditions.elementToBeClickable(
                  driver.findElement(By.xpath(propertyXpath + businessType + "')]"))));
    }
    actions.moveToElement(radioButtons).click().build().perform();
    radioButtons.click();
  }

  public void dataInput(WebDriver driver, String xpath, String quoteVariableValue) {
    WebElement textBox =
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
    textBox.click();
    actions
        .moveToElement(driver.findElement(By.xpath(xpath)))
        .sendKeys(quoteVariableValue)
        .build()
        .perform();
  }

  public void dateEntry(WebDriver driver, String inceptionDate, String month, String year)
      throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //      long seconds = Long.parseLong(inceptionDate);
    //      Date date = new Date(seconds);
    //      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    //      dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    //      String formattedDate = dateFormat.format(date);

    WebElement dateElement =
        wait.until(
            ExpectedConditions.elementToBeClickable(
                driver.findElement(
                    By.xpath(
                        "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]"))));

    js.executeScript("arguments[0].setAttribute('date', '" + inceptionDate + "')", dateElement);

    actions.moveToElement(dateElement).click().build().perform();
    Thread.sleep(1000);
    WebElement dateEntry = driver.findElement(By.xpath("//input[@type='date']"));
    actions.moveToElement(dateEntry).sendKeys(inceptionDate).build().perform();
    Thread.sleep(1500);
    actions.moveToElement(dateEntry).sendKeys(month).build().perform();
    Thread.sleep(1500);
    actions.moveToElement(dateEntry).sendKeys(year).build().perform();
    Thread.sleep(1500);
  }
}
