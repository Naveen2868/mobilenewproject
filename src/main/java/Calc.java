
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class Calc {

    public static AppiumDriver<MobileElement> driver;
    public WebDriver webDriver ;

    public void openCalc() throws MalformedURLException {
        startAppiumService("4723");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        //cap.setCapability(MobileCapabilityType.UDID, "RZ8R60K7Z1Z");
        cap.setCapability(MobileCapabilityType.UDID, "9f2a470a");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability(MobileCapabilityType.APP,"D:\\cbuz.apk");
        /*cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");*/
       /* cap.setCapability("appPackage", "com.oneplus.calculator");
        cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");*/
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, cap);
        System.out.println("Application has started................");

    }


    public void openBrowser() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy M31s");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        cap.setCapability(MobileCapabilityType.UDID, "RZ8R60K7Z1Z");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        // cap.setCapability(MobileCapabilityType.ORIENTATION,"LANDSCAPE"); WORKING
        //cap.setCapability("unlockType", "password"); //Trying to unlock the device using pin
        // cap.setCapability("unlockKey", "1997");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //driver = new AppiumDriver<MobileElement>(url, cap);
        webDriver = new RemoteWebDriver(url, cap);
        System.out.println("Application browser has started................");
    }

    AppiumDriverLocalService service;

    public void startAppiumService(String portNumber) {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("");
        builder.usingPort(Integer.parseInt(portNumber));
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Service has been started with port number :" + 4723);
    }

    public void stopAppiumServer() {
        service.stop();
    }

    public MobileElement getElement(){
        return driver.findElement(By.xpath(""));
    }

    public void search() {
        webDriver.get("https://www.google.com");
        waitForFewSeconds(5);
        webDriver.findElement(By.name("q")).sendKeys("Automation");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        waitForFewSeconds(5);

    }

    public void waitForFewSeconds(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        webDriver.close();
        webDriver.quit();
    }

    public String mul() {
        MobileElement five = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
        MobileElement six = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06"));
        MobileElement mul = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul"));
        MobileElement res = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_tv_result"));

        five.click();
        mul.click();
        six.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actual = res.getText();
        System.out.println("actual values is " + actual);
        return actual;
    }

    public String oneplusmul() {
        MobileElement nine = driver.findElement(By.id("com.oneplus.calculator:id/digit_9"));
        MobileElement six = driver.findElement(By.id("com.oneplus.calculator:id/digit_6"));
        MobileElement add = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
        MobileElement res = driver.findElement(By.id("com.oneplus.calculator:id/result"));

        nine.click();
        add.click();
        six.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actual = res.getText();
        System.out.println("actual values is " + actual);
        return actual;
    }

    public void clearCalc() {
        MobileElement clear = driver.findElement(By.id("com.oneplus.calculator:id/clr"));
        clear.click();
    }



}
