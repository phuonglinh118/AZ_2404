package Method;

import BaseSetup.LocalDriverManager;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;

import static BaseSetup.LocalDriverManager.getDriver;

public class Methods {
    //public static WebDriver driver = LocalDriverManager.getDriver();
    //NAVIGATOR URL
    public static void Navigator_Web (String url){
        WebDriver driver = getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(NullPointerException.class)
                .until(driver1 -> {
                    driver.navigate().to(url);
                    return driver;
                });
    }
    public static void Navigator_Web1 (String url,WebDriver driver){
       // WebDriver driver = LocalDriverManager.getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(NullPointerException.class)
                .until(driver1 -> {
                    driver.navigate().to(url);
                    return driver;
                });
    }
    // SEND KEY = STRING
    public static void sendKey (By locator, String text){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }
    public static void sendKeyEnterWithUrlElement() throws AWTException, InterruptedException {
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_F6);
        Thread.sleep(500);
        rb.keyPress(KeyEvent.VK_ENTER);
    }
    public static void sendKeyDownWithoutElement () throws AWTException, InterruptedException {
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_DOWN);
    }
    public static void sendKeyEnterWithoutElement() throws AWTException, InterruptedException {
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
    }

    // SEND KEY = NUMBER
    public static void sendKeyNumber (By locator, int number){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(String.valueOf(number));
    }
    // SEND KEY = NUMBER + ENTER
    public static void sendKeyNumberEnter (By locator, int number){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(String.valueOf(number)+Keys.ENTER);
    }
    // SEND KEY = NUMBER
    public static void sendKeyNumber (By locator, String text){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.valueOf(text));
    }
    //SEND KEY = STRING + ENTER
    public static void sendKeyEnter(By locator, String text){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text + Keys.ENTER);
    }
    //SEND KEY = STRING + WAIT 3 SECONDS + ENTER
    public static void sendKeyWait3SEnter(By locator, String text) throws Exception{
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ENTER);
    }
    //SEND KEY = STRING + DOWN KEY + ENTER
    public static void sendKeyAddDownKeyEnter(By locator, String text) throws Exception{
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ENTER);
    }
    //SEND KEY = DOWN KEY + ENTER
    public static void sendKeyDownThenEnter(By locator) throws Exception{
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ENTER);
    }
    //SEND KEY = STRING + WAIT N SECONDS + ENTER
    public static void sendKeyWaitTimeEnter(By locator, String text, int seconds) throws Exception{
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        Thread.sleep(seconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ENTER);

    }
    //SEND KEY = STRING + WAIT 5 SECONDS + ENTER
    public static void sendKeyWaitingFor5SecondThenEnter(By locator, String text) throws Exception{
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ENTER);
    }

    public static boolean checkElementDisplay (By locator){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        boolean display = wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
        return display;
    }
    //CLICK ELEMENT
    public static void click (By locator){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Đợi có điều kiện đến khi element to be click-able
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    //DOUBLE CLICK ELEMENT
    public static void doubleClick (By locator){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Đợi có điều kiện đến khi element to be click-able
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    //GET STRING
    public static String getString (By locator){
        String text;
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        text = wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
        return text.trim();
    }
    //EDIT INNER HTML
    public static String getString_RemoveAttribute(String attribute, By locator){
        String text;
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].removeAttribute('" + attribute + "')",driver.findElement(locator));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        text = wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
        return text;
    }
    public static void removeAttribute(String attribute, By locator){
        String text;
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].removeAttribute('" + attribute + "')",driver.findElement(locator));
    }
    public static void setAttribute(String nameAttribute, String valueAttribute, By locator){
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('" + nameAttribute + "', '" + valueAttribute +"')",driver.findElement(locator));
    }

    public static String getStringNonWait (By locator){
        String text;
        WebDriver driver = getDriver();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        text = driver.findElement(locator).getText();
        return text;
    }
    //get number
    public static String getNumberToString (By locator){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String textToString = wait.until(ExpectedConditions.elementToBeClickable(locator)).getText().toString();
        return textToString;
    }
    //GET VALUE OF ATTRIBUTE
    public static String getValueAttribute (By locator, String attribute){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String valueAttribute = wait.until(ExpectedConditions.elementToBeClickable(locator)).getAttribute(attribute);
        return valueAttribute.trim();
    }
    public static void waitTitleShow (String title) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs(title));
    }
    public static String getTitle () {
        WebDriver driver = getDriver();
        String title = driver.getTitle();
        return title;
    }
    //CHECK ELEMENT DISPLAY NOT CONDITION
    public static boolean elementDisplay(By locator){
        WebDriver driver = getDriver();
        boolean display = driver.findElement(locator).isDisplayed();
        return display;
    }
    //CHECK ELEMENT EXIST => CHECK ELEMENT SHOW OR NOT SHOW
    public static boolean elementExist(By locator){
        WebDriver driver = getDriver();
        List<WebElement> element = driver.findElements(locator);
//        System.out.println("Element Size: "+ element.size());
        if (element.size()>0){
            return true;
        }
        return false;
    }
    public static int countElementExist (By locator){
        WebDriver driver = getDriver();
        List<WebElement> element = driver.findElements(locator);
        return element.size();
    }
//    GET STRING READ ONLY
    public static String getValueReadOnly (By locator) {
        WebDriver driver = getDriver();
        WebElement elementReadOnly = driver.findElement(locator);
        String value = elementReadOnly.getAttribute("value");
        return value;
    }
    //CHECK ELEMENT DISPLAY
    public static void switchFirstTab(){
        WebDriver driver = getDriver();
        ArrayList <String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
    public static void switchTab(int numTab){
        WebDriver driver = getDriver();
        ArrayList <String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(numTab));
    }
    public static String getUrlOfCurrentPage(){
        WebDriver driver = getDriver();
        return driver.getCurrentUrl();
    }
    //=====SWITCH IFRAME======
    public static void switchIframe(String id){
        WebDriver driver = getDriver();
        driver.switchTo().frame("id");
    }
    //    TAKE A SCREEN SHOT
    public static void takeScreenShot  (String fileWithPath) throws Exception {
        WebDriver driver = LocalDriverManager.getDriver();
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destFile = new File(fileWithPath); //folderPath + fileName
        //Copy file at destination
        FileUtils.copyFile(srcFile, destFile);
    }
    //FIND ELEMENT EXIST RỒI MỚI GET NUMBER
    public static String getNumberToStringExist(By locator){
        //int number;
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        String textToString;
        List<WebElement> body = driver.findElements(By.xpath("//tbody"));
        //fine tagName <tr>
        //List<WebElement> rows = driver.findElements(By.tagName("tr"));
        int rowsSize = body.size();
       // System.out.println("rows: " + rowsSize);
        //int bodySize = driver.findElements(By.xpath("//tbody")).size();
        if (rowsSize==0){
            //System.out.println("is display");
            textToString =null;
        }
        else {
            //System.out.println("not display");
            textToString = wait.until(ExpectedConditions.elementToBeClickable(locator)).getText().toString();
        }
        return textToString;
    }
    //get size element -- CHECK ELEMENT EXIST
    public static int sizeElement (By locator){
        WebDriver driver = getDriver();
        int size = driver.findElements(locator).size();
        return size;
    }
    //COUNT ROWS OF TABLE = COUNT TAG <TR>
    public static int countTagTR(By locator){
        WebDriver driver = getDriver();
        int sizeTR;
        WebElement elementTBody = driver.findElement(locator);
        List<WebElement> rows = elementTBody.findElements(By.tagName("tr"));
        sizeTR = rows.size();
        return sizeTR;
    }
    //COUNT ROWS OF TABLE = COUNT TAG <div>
    public static int countTagDiv(By locator){
        WebDriver driver = getDriver();
        int sizeDiv;
        WebElement elementLocator = driver.findElement(locator);
        List<WebElement> rows = elementLocator.findElements(By.tagName("div"));
        sizeDiv = rows.size();
        return sizeDiv;
    }
    //====== COUNT TAG HTML ======
    public static int countTagHtml(By locator, String tagName){
        WebDriver driver = getDriver();
        int sizeTag;
        WebElement elementTBody = driver.findElement(locator);
        List<WebElement> rows = elementTBody.findElements(By.tagName(tagName));
        sizeTag = rows.size();
        return sizeTag;
    }
    //COUNT TAG <SVG>
    public static int countTagSVG(By locator){
        WebDriver driver = getDriver();
        int sizeSVG;
        WebElement elementTBody = driver.findElement(locator);
        List<WebElement> rows = elementTBody.findElements(By.tagName("svg"));
        sizeSVG = rows.size();
        return sizeSVG;
    }
    //Refresh Browser
    public static void refresh (){
        WebDriver driver = getDriver();
        driver.navigate().refresh();
    }
    //Back Browser
    public static void backBrowser (){
        WebDriver driver = getDriver();
        driver.navigate().back();
    }

    //GET CSS VALUE
    public static String getBackgroundColor (By locator){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        String hexbgColor = null;
        String backgroundColor = wait.until(ExpectedConditions.elementToBeClickable(locator)).getCssValue("background-color");
            //String backgroundColor = driver.findElement(locator).getCssValue("background-color");
        hexbgColor = Color.fromString(backgroundColor).asHex();
        return hexbgColor;
    }
    //CLEAR DATA IN TEXT BOX - INPUT
    public static void clearInput (By locator){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
    }
    public static void selectOption (By locator){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys (Keys.ENTER);
    }
    public static String imgURL (By locator){
        WebDriver driver = getDriver();
        String imgUrl = driver.findElement(locator).getAttribute("src");
        return imgUrl;
    }
    public static WebElement getElement (By locator){
        WebDriver driver = getDriver();
        WebElement getElement = driver.findElement(locator);
        return getElement;
    }
//    ========== CHECK ELEMENT IS ENABLE =========
    public static Boolean checkElementIsEnable (By locator){
        WebDriver driver = getDriver();
        return driver.findElement(locator).isEnabled();
    }
    //get rowsSize trong table body
    public static int getRowsSize (String tbody){
        int rowsSize =0;
        WebDriver driver = getDriver();
        //find table body
        WebElement elementTBody = driver.findElement(By.xpath(tbody));
        //fine tagName <tr>
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        rowsSize = rows.size();
        return rowsSize;

    }
    //  SELECT LOCATOR DROPDOWN LIST BY VALUE
    public static void clickValueExistInUL (By locator, String value){
        WebDriver driver = getDriver();
        List <WebElement>  listValues = driver.findElements(locator);
        for (WebElement liValue : listValues){
            if(liValue.getText().contains(value)){
                System.out.println("text: " + liValue.getText());
                liValue.click();
            }
        }
    }
    public static void clickValueExistInUL_Customize (By locator, String value, String subString, int startIndex){
        WebDriver driver = getDriver();
        String s;
        List <WebElement>  listValues = driver.findElements(locator);
        for (int i=startIndex; i<listValues.size(); i++){
            s = listValues.get(i).getText();
            s = s.trim();
            System.out.println("S original " + i + " :" + s);
            s = s.substring(0,s.indexOf(subString)).trim();
            System.out.println("S " + i + " :" + s);
            if(s.equals(value)){
                listValues.get(i).click();
                System.out.println("S click " + i + " :" + s);
                break;
            }
        }
    }
    public static ArrayList<String> getValueExistInDropDownList_UL (By locator){
        WebDriver driver = getDriver();
        List <WebElement>  listValues = driver.findElements(locator);
        ArrayList<String> valuesOfList = new ArrayList<>();
        String s;
        for (int i=0; i<listValues.size(); i++){
            s = listValues.get(i).getText();
            s=s.trim();
            valuesOfList.add(s);
            System.out.println("S " + i + " :" + s);
        }
        return valuesOfList;

    }
    public static void selectByVisibleTextInDropDownList(By locator, String value){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }
    public static void selectByValueInDropDownList(By locator, String value){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(value);
    }
    public static void selectValueInDropDownListWaitSeconds (By locator, String value, long seconds){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }
//    GET VALUE SELECTED IN DROPDOWN
    public static String getValueSelectedInDropDownList (By locator){
        WebDriver driver = getDriver();
        Select dropdown = new Select(driver.findElement(locator));
        return dropdown.getFirstSelectedOption().getText().trim();
    }
    //  SELECT LOCATOR DROPDOWN LIST BY ID
    public static void selectIdInDropDownList (By locator, int id){
        WebDriver driver = getDriver();
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(id);
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.elementToBeSelected(dropdown.selectByVisibleText(value));
    }
    public static void inputAndSelectValueInContainer (By locator, String value) throws Exception{
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(value);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ENTER);
    }
//    ========== SELECT VALUE IN DROPDOWN =================
    public static void inputValueToSelectOption (By option, By input, String value) throws Exception {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(input)).sendKeys(value + Keys.ENTER);
    }

    public static void inputValueWaitToSelectOption (By option, By input, String value) throws Exception {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(input)).sendKeys(value);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(input)).sendKeys(Keys.ENTER);
    }
//    =========== ALERT ===========
    //CLICK ON THE "OK" BUTTON OF THE ALERT
    public static void acceptAlert() throws Exception {
        WebDriver driver = getDriver();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
    //CLICK ON THE "OK" BUTTON OF THE ALERT
    public static void acceptAlert1() throws Exception {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    //CLICK ON THE "CANCEL" BUTTON OF THE ALERT
    public static void dismissAlert() throws Exception {
        WebDriver driver = getDriver();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
    }
//    ==== GET TEXT ON ALERT====
    public static String getTextAlert () throws Exception {
        WebDriver driver = getDriver();
        Thread.sleep(2000);
        return driver.switchTo().alert().getText();
    }
    //GET CONTENT JAVASCRIPT ALERT (NOTIFICATION)
    public static String getAlertText(){
        WebDriver driver = getDriver();
        String message =  driver.switchTo().alert().getText();
        return message;
    }
    //    ==== GET TEXT ON ALERT====
    public static void sendkeyAlert() throws Exception {
        WebDriver driver = getDriver();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Key");
    }
//    ========= CHECK ALERT IS PRESENT ==========
    public static void checkAlertIsPresent () throws Exception {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException noAlert){
            noAlert.getMessage();
        }
    }


//    UPLOAD FILE BY METHOD SEND SOURCE FILE
    public static void uploadFile (String filePath, By locator) throws Exception {
        WebDriver driver = getDriver();
        driver.findElement(locator).sendKeys(System.getProperty("user.dir")+filePath);
    }
// UPLOAD FILE BY METHOD CHOOSE FILE
    public static void uploadChooseFile (String filePath, By locator) throws Exception {
        WebDriver driver = getDriver();
        driver.findElement(locator).click();
        Thread.sleep(1000);
//        Init robot
        Robot rb = null;
        try{
            rb = new Robot();
        }
        catch (AWTException e){
            e.printStackTrace();
        }
//        Copy File Path to Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(1000);
        //        PRESS CTRL + V TO PAST
//        PRESS CTRL + V
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
//        CONFIRM CTRL + V
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
//        PRESS ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
    }
    public static void pressKeyCtrlW() throws Exception{
        WebDriver driver = getDriver();
        Actions pressKey = new Actions(driver);
        pressKey.keyDown(Keys.CONTROL)
                .sendKeys("W")
                .keyUp(Keys.CONTROL)
                .perform();
    }
    //TOGGLE DEVICE TOOLBAR
    public static void pressKey_Ctrl_Shift_M() throws Exception{
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_M);
        Thread.sleep(500);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_SHIFT);
        rb.keyRelease(KeyEvent.VK_M);
    }
    public static void pressKey_F12() throws Exception{
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_F12);
        Thread.sleep(500);
        rb.keyRelease(KeyEvent.VK_F12);

    }
//    ====== CLOSE NEW TAB =======
    public static void closeNewTab () throws Exception {
        String mainTab, newTab;
        WebDriver driver = getDriver();
        mainTab = driver.getWindowHandle();
        Set<String> listTab = driver.getWindowHandles();
        Iterator tab = listTab.iterator();
        while (tab.hasNext()){
            newTab = tab.next().toString();
            if(!mainTab.equalsIgnoreCase(newTab)){
                driver.switchTo().window(newTab);
                driver.close();
            }
        }
        driver.switchTo().window(mainTab);
    }
    public static void closePrintViewNewTab () throws Exception {
        String mainTab, newTab;
        WebDriver driver = getDriver();
        mainTab = driver.getWindowHandle();
        Set<String> listTab = driver.getWindowHandles();
        Iterator tab = listTab.iterator();
        while (tab.hasNext()){
            newTab = tab.next().toString();
            if(!mainTab.equalsIgnoreCase(newTab)){
                driver.switchTo().window(newTab);
                driver.switchTo().frame("pdf-viewer");
//                driver.quit();
//                Alert ale = driver.switchTo().alert();
//                ale.dismiss();
                Robot robo = new Robot();
                robo.keyPress(KeyEvent.VK_ESCAPE);
                robo.keyRelease(KeyEvent.VK_ESCAPE);

                driver.close();
            }
        }
        driver.switchTo().window(mainTab);
    }
    //    ========= STRING ==========
    public static boolean checkStringIsNotNull(String s) throws Exception {
        s=s.trim();
        if(s.length()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean compareTwoArray (ArrayList<String> a, ArrayList<String> b){
        Collections.sort(a);
        Collections.sort(b);
        Object [] obj1 = {a};
        Object [] obj2 = {b};
        if (Arrays.deepEquals(obj1, obj2)){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean compareList (ArrayList<String> a, ArrayList<String> b){
        Collections.sort(a);
        Collections.sort(b);
        return a.toString().contentEquals(b.toString())?true:false;
    }
    public static void printValueOfArray (ArrayList<String> a){
        for (String i: a){
            System.out.println(i);
        }
    }
    public static String findAndReplaceWord (String oldString, String oldWord, String newWord) {
        String newString;
        newString = oldString.replace(oldWord, newWord);
        return newString;
    }
    public static String getMonthFromYearMonth (String yearMonth) {
        int index;
        String month="";
        if(yearMonth.contains("-")){
            index = yearMonth.indexOf("-");

        }
        return month;
    }
    public static String getSystemDate (){
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = currentDate.format(ZonedDateTime.now());
        return date;
    }
    public static String getSystemMonth (){
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("MM");
        String date = currentDate.format(ZonedDateTime.now());
        return date;
    }
    public static String getSystemYear (){
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy");
        String date = currentDate.format(ZonedDateTime.now());
        return date;
    }
    public static String getSystemDateTime (){
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = currentDate.format(ZonedDateTime.now());
        return time;
    }
    public static String getSystemDateTimeFormatDate (){
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = currentDate.format(ZonedDateTime.now());
        return time;
    }
    public static String getResultMD5 (String input) throws Exception {
        try{
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte [] result = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger signum = new BigInteger(1, result);
            // Convert result of message digest into hex value
            String hashText = signum.toString(16);
            while (hashText.length()<32){
                hashText = "0" + hashText;
            }
            return hashText;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
    public static ArrayList initArrayList_FiveElements (String s1, String s2, String s3, String s4, String s5) throws Exception {
        ArrayList<String> arr = new ArrayList<>();
        if (s1.trim().length()>0){
            arr.add(s1);
        }
        if (s2.trim().length()>0){
            arr.add(s2);
        }
        if (s3.trim().length()>0){
            arr.add(s3);
        }
        if (s4.trim().length()>0){
            arr.add(s4);
        }
        if (s5.trim().length()>0){
            arr.add(s5);
        }
        return arr;
    }
    public static ArrayList initArrayList_TenElements (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) throws Exception {
        ArrayList<String> arr = new ArrayList<>();
        if (s1.trim().length()>0){
            arr.add(s1);
        }
        if (s2.trim().length()>0){
            arr.add(s2);
        }
        if (s3.trim().length()>0){
            arr.add(s3);
        }
        if (s4.trim().length()>0){
            arr.add(s4);
        }
        if (s5.trim().length()>0){
            arr.add(s5);
        }
        if (s6.trim().length()>0){
            arr.add(s6);
        }
        if (s7.trim().length()>0){
            arr.add(s7);
        }
        if (s8.trim().length()>0){
            arr.add(s8);
        }
        if (s9.trim().length()>0){
            arr.add(s9);
        }
        if (s10.trim().length()>0){
            arr.add(s10);
        }
        return arr;
    }
    public static String subStringMiddleByLength(String str, String subStr, int lengthStr) throws Exception{
        if((str.trim().contains("null")) || (str.trim().length()==0)){
            str = "";
        }
        else {
            if(str.contains(subStr)){
                int index;
                index = str.indexOf(subStr) + subStr.length() ;
                str = str.substring(index, lengthStr + index);
            }
            else {
                str = "";
            }
        }
        return str;
    }
    public static String subStringMiddleBySubStr (String str, String subStr1, String subStr2) throws Exception{
        if((str.trim().contains("null")) || (str.trim().length()==0)){
            str = "";
        }
        else {
            if(str.contains(subStr1)){
                int index;
                index = str.indexOf(subStr1) + subStr1.length();
                str = str.substring(index+1);
            }
            else {
                str = "";
            }
        }
        if((str.trim().contains("null")) || (str.trim().length()==0)){
            str = "";
        }
        else {
            if(str.contains(subStr2)){
                int index;
                index = str.indexOf(subStr2);
                str = str.substring(0,index);
            }
            else {
                str = "";
            }
        }
        return str;
    }
    public static String subStringSuffixAddIndex (String str, String subStr) throws Exception{
        if((str.trim().contains("null")) || (str.trim().length()==0)){
            str = "";
        }
        else {
            if(str.contains(subStr)){
                int index;
                index = str.indexOf(subStr) + subStr.length() ;
                str = str.substring(index);
            }
            else {
                str = "";
            }
        }
        return str;
    }
    public static String subStringSuffix (String str, String subStr) throws Exception{
        if((str.trim().contains("null")) || (str.trim().length()==0)){
            str = "";
        }
        else {
            if(str.contains(subStr)){
                int index;
                index = str.indexOf(subStr);
                str = str.substring(index+1).trim();
            }
            else {
                str = "";
            }
        }
        return str;
    }
    public static String subStringPrefix (String str, String subStr) throws Exception{
        if((str.trim().contains("null")) || (str.trim().length()==0)){
            str = "";
        }
        else {
            if(str.contains(subStr)){
                int index;
                index = str.indexOf(subStr);
                str = str.substring(0,index).trim();
            }
            else {
                str = "";
            }
        }
        return str;
    }
    public static int countCharInString (String str, char charAt) throws Exception {
        int length = str.trim().length();
        int countChar = 0;
        for (int i =0; i<length; i++){
            if(str.charAt(i)==charAt){
                countChar ++;
            }
        }
        return countChar;
    }
    public static String generateSha3_512 (String requestId, String transactionId, String requestAmountRefund) throws Exception {
        String secretKey, requestTime, merchantCode, typeRefund, paymentSource, checkSum;
        secretKey = "86bc21d0eb73ff06be46d078e8dbe2db";
        merchantCode = "448948921569";
        typeRefund = "1";
        paymentSource = "3";
        requestTime = getSystemDateTime();
//        secretKey|requestId|requestTime|transactionId|merchantCode|paymentSource|typeRefund|requestAmountRefund
        checkSum = secretKey + requestId +requestTime + transactionId + merchantCode + paymentSource + typeRefund + requestAmountRefund ;
        MessageDigest crypt = MessageDigest.getInstance("SHA3-512");
        crypt.update(checkSum.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = crypt.digest();
        BigInteger bi = new BigInteger(1, bytes);
        String digest = String.format("%0" + (bytes.length << 1) + "x", bi);
        System.out.println(digest);
        return digest;
    }
    public static String SHA3 (String message) {
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(message.getBytes());
        return Hex.encodeHexString(digest);
    }
    public static String decodeBase64 (String message) throws Exception{
//        String encoded = "QmFzZTY0IERlY29kZQ==";
        byte[] decoded = Base64.getDecoder().decode(message);
        String decodedStr = new String(decoded, StandardCharsets.UTF_8);
        Hex.decodeHex(message);

        System.out.println(decodedStr);
        return  decodedStr;
    }
    public static void exportConsoleOutputToTextFile (File file, String output) throws Exception {
        try {
            PrintStream ps = new PrintStream(file);
            System.setOut(ps);
//            ps.print(output);
            ps.println(output);
        }
        catch (FileNotFoundException fn){
            System.out.println(fn);
        }
    }

}
