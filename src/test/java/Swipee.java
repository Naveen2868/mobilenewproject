import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Swipee {

    public AppiumDriver<MobileElement> driver;

    public Swipee(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    public String getRandomPassportNumber() {
        long timeseed = System.nanoTime();
        double randseed = Math.random() * 1000;
        long midseed = (long) (timeseed * randseed);
        String s = midseed + "";
        String randomPassportNumber = s.substring(0, 10);
        return randomPassportNumber;
    }

    public void androidKeyBoardKeyDPADupAndDPADdown(String pageDirection, int swipeCount) {
        for (int i = 0; i <= swipeCount; i++) {
            switch (pageDirection) {
                case "DPAD_UP":
                    ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_UP));
                    break;
                case "DPAD_DOWN":
                    ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
                    break;
            }
        }
    }

    public void androidKeyBoardKeyPageUpAndPageDown(String pageDirection, int swipeCount) {
        for (int i = 0; i <= swipeCount; i++) {
            switch (pageDirection) {
                case "PAGE_UP":
                    ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.PAGE_UP));
                    break;
                case "PAGE_DOWN":
                    ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
                    break;
            }
        }
    }

    public void click(MobileElement element) throws InterruptedException {
        waitForVisibility(element);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        minimumWait();
    }

    public void click(By by) throws InterruptedException {
        waitForVisibility(by);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
        TimeUnit.SECONDS.sleep(1);
    }

    public void clearAndSendKeys(MobileElement element, String value) throws InterruptedException {
        waitForVisibility(element);
        element.click();
        element.clear();
        element.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(value);
        actions.build().perform();
        TimeUnit.SECONDS.sleep(1);
    }

    public void sendKeys(MobileElement element, String value) throws InterruptedException {
        waitForVisibility(element);
        element.click();
        element.clear();
        element.click();
        element.sendKeys(value);
        TimeUnit.SECONDS.sleep(1);
    }

    public String getAttribute(MobileElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public String getAttribute(By by, String attribute) {
        waitForVisibility(by);
        return driver.findElement(by).getAttribute(attribute);
    }

    public void swipeScreen(String dir) throws Exception {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions
        Dimension dimension = driver.manage().window().getSize();
        int startX = (int) (dimension.width * 0.5);
        int endX = (int) (dimension.width * 0.5);
        int startY = 0;
        int endY = 0;

        switch (dir) {
            case "up":
                endY = (int) (dimension.height * 0.6);
                startY = (int) (dimension.height * 0.9);
                break;
            case "down":
                endY = (int) (dimension.height * 0.9);
                startY = (int) (dimension.height * 0.6);
                break;
            case "left":
                startX = (int) (dimension.width * 0.95);
                endX = (int) (dimension.width * 0.05);
                startY = dimension.height / 2;
                break;
            case "right":
                startX = (int) (dimension.width * 0.05);
                endX = (int) (dimension.width * 0.95);
                startY = dimension.height / 2;
                break;
        }
        if (dir.contains("left") || dir.contains("right")) {
            swipe(startX, startY, endX, startY, 1000);
        } else {
            swipe(startX, startY, endX, endY, 1000);
        }
    }

    public MobileElement scrollToElement(MobileElement element, String direction) throws Exception {
        System.out.println("swipeScreen(): dir: '" + direction + "'");
        Dimension dimension = driver.manage().window().getSize();
        int screenWidth = driver.manage().window().getSize().getWidth();
        int startX = (int) (dimension.width * 0.5);
        int endX = (int) (dimension.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;
        switch (direction) {
            case "up":
                endY = (int) (dimension.height * 0.4);
                startY = (int) (dimension.height * 0.6);
                break;
            case "down":
                endY = (int) (dimension.height * 0.6);
                startY = (int) (dimension.height * 0.4);
                break;
            case "right":
                startX = element.getCenter().getX();
                startY = element.getCenter().getY();
                endX = (int) (screenWidth * 0.9);
                endY = startY;
                break;
            case "left":
                startX = element.getCenter().getX();
                startY = element.getCenter().getY();
                endX = screenWidth - (int) (screenWidth * 0.9);
                endY = startY;
                break;
        }

        for (int i = 0; i <= 10; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }

        if (!isFound) {
            throw new Exception("Element not found");
        }

        return element;

    }

    public void minimumWait() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public void mediumWait() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    public void maxWait() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
    }

    public void wait(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public void scrollMultipleTimes(String direction, int swipeCount) throws Exception {
        for (int i = 1; i <= swipeCount; i++) {
            swipeScreen(direction);
            minimumWait();
        }
    }

    public void scrollMultipleTimesToFindAnElement(String direction, int swipeCount,MobileElement element) throws Exception {
        for (int i = 1; i <= swipeCount; i++) {
            if(element.isDisplayed()){
                element.click();
                minimumWait();
            }else {
                swipeScreen(direction);
            }
            minimumWait();
        }
    }

    public void scrollingUpAndDown(String direction) {
        System.out.println("swipeScreen(): dir: '" + direction + "'");
        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int x = height / 2;
        int startY;
        int endY;
        TouchAction touchAction;
        switch (direction) {
            case "down":
                startY = (int) (height * 0.20);
                endY = (int) (height * 0.70);
                touchAction = new TouchAction(driver).longPress(PointOption.point(x, startY)).
                        waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).
                        moveTo(PointOption.point(0, endY)).release();
                touchAction.perform();
            case "up":
                startY = (int) (height * 0.70);
                endY = (int) (height * 0.20);
                touchAction = new TouchAction(driver).longPress(PointOption.point(x, startY)).
                        waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).
                        moveTo(PointOption.point(0, endY)).release();
                touchAction.perform();
        }
    }

    public boolean find(MobileElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return element.isDisplayed();
                }
            });

        } catch (Exception e) {
            return false;
        }

    }

    public boolean find(By by, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return driver.findElement(by).isDisplayed();
                }
            });

        } catch (Exception e) {
            return false;
        }

    }

    public boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0) {
            waitForVisibility(by);
            return true;
        } else
            return false;
    }

    public boolean isElementPresent(MobileElement element) {
        boolean elementStatus = false;
        try {
            if (element.isDisplayed()) {
                waitForVisibility(element);
                elementStatus = true;
            } else {
                elementStatus = false;
            }
        } catch (Exception e) {
        }
        return elementStatus;
    }


    public void swipe(int startX, int startY, int endX, int endY, int mills) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(mills))).
                moveTo(PointOption.point(endX, endY)).release().perform();
    }

    public void waitForVisibility(MobileElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickOnScreen() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickOnKeyboardBackButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void clickOnKeyboardForwardButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.FORWARD));
    }

    public void keyEventAsSendKey(String keyValue) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        switch (keyValue) {
            case "0":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));
                break;
            case "1":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
                break;
            case "2":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
                break;
            case "3":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
                break;
            case "4":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
                break;
            case "5":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
                break;
            case "6":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
                break;
            case "7":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_7));
                break;
            case "8":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_8));
                break;
            case "9":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_9));
                break;
            case "a":
            case "A":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.A));//if need we can add other alphabets
                break;
            default:
                System.out.println("Key value not matched");
        }
    }

    public void scrollToTextAndClick(String scrollToText) {
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                "scrollIntoView(new UiSelector().textContains(\"" + scrollToText + "\").instance(0))").click();
    }

    public void tapOnElement(MobileElement element) throws InterruptedException {
        waitForVisibility(element);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
        minimumWait();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationFilePath = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator +
                "screenshots" + File.separator + System.nanoTime()+".PNG");
        FileUtils.copyFile(scrFile, destinationFilePath);

    }
}
