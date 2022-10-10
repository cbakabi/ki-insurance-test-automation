//package automation.testUtils;
//
//import static automation.stepDefs.MyStepdefs.driver;
//
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ElementUtils {
//    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//    public static Actions actions = new Actions(driver);
//
//    public static void findElementByXpath(String xpath){
//        driver.findElement(By.xpath(xpath)).click();
//    }
//
//    public static void findElementByXpathWithActions(String xpath) throws InterruptedException {
//        actions.moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
//        Thread.sleep(1000);
//    }
//
//    public static Object findTextElement(String xpath, String quoteVariable){
//        driver.findElement(By.xpath(xpath + quoteVariable + "')]"));
//    }
//
//    public static void selectElementFromDropdownMenu(String selectionPath, String variable, String listBoxXpath, String questionGroupsXpath){
//        WebElement questionGroups =
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(questionGroupsXpath)));
//
//        actions.moveToElement(questionGroups).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(questionGroups.findElement(By.xpath(listBoxXpath))));
//        questionGroups.click();
//
//        String selectionXpath = selectionPath + variable + "')]";
//
//        WebElement selection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectionXpath)));
//        actions.moveToElement(selection).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(questionGroups.findElement(By.xpath(selectionXpath))));
//        selection.click();
//    }
//
//    public static void selectBusinessClass(String cyberXpath, String energyXpath, String propertyXpath, String businessType){
//        WebElement radioButtons;
//
//        if (businessType.equals("Cyber")){
//            radioButtons = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(cyberXpath + businessType + "')]"))));
//        }else if (businessType.equals("Energy")){
//            radioButtons = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(energyXpath + businessType + "')]"))));
//        } else{
//            radioButtons = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(propertyXpath + businessType + "')]"))));
//        }
//        actions.moveToElement(radioButtons).click().build().perform();
//        radioButtons.click();
//
//      List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div[@role='radiogroup']"));
////        int buttonQuantity = radioButtons.size();
//
////        for (int i = 1; i < buttonQuantity; i++) {
////            String buttonName = radioButtons.get(i).getAttribute(businessType);
////            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div["+ i + "]/label/div/div[1]/div[contains(@data-value, '"+ businessType + "')]"))));
////            if (buttonName.equalsIgnoreCase(businessType)) {
////                actions.moveToElement(button).click().build().perform();
////                button.click();
////                radioButtons.get(i).click();
////                break;
////            }
////        }
////        for  (int i = 1; i < buttonQuantity; i++) {
////            String buttonName = radioButtons.get(i).getAttribute(businessType);
////            if (buttonName.equalsIgnoreCase(businessType)){
////                actions.moveToElement(radioButtons.get(i).findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/span/div/div[" + i +"]/label/div/div[1]/div[contains(@data-value, '"+ businessType + "')]"))).click().build().perform();
////                break;
////            }
////        }
//    }
//
//    public static void dataInput(String xpath, String quoteVariableValue){
//        WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
//        textBox.click();
//        actions.moveToElement(driver.findElement(By.xpath(xpath))).sendKeys(quoteVariableValue).build().perform();
//    }
//
//
//}