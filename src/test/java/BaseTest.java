import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public void setDriver(AppiumDriver driver) {
        this.driver.set(driver);
    }

    AppiumDriverLocalService service;

    public AppiumDriver getDriver() {
        return this.driver.get();
    }

    public void startAppiumService(String portNumber) {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("");
        builder.usingPort(Integer.parseInt(portNumber));
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        } else
            System.out.println("Service has been started with port number :" + portNumber);
    }

    @AfterMethod
    public void closeDriver() {
        getDriver().quit();
        service.stop();
    }

    @BeforeMethod
    @Parameters({"platformType", "deviceName", "platformVersion", "udid", "portNumber"})
    public void initiateDriver(String platformType, String deviceName, String platformVersion, String udid, String portNumber)
            throws MalformedURLException {
        startAppiumService(portNumber);
        DesiredCapabilities cap = new DesiredCapabilities();
        if (platformType.equalsIgnoreCase("Android")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformType);
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            cap.setCapability(MobileCapabilityType.UDID, udid);
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            //cap.setCapability(MobileCapabilityType.APP, "D:\\apks\\wu.eu_2022-04-01.apk");
            cap.setCapability(MobileCapabilityType.APP,"D:\\apks\\cbuz.apk");
            setDriver(new AndroidDriver(new URL("http://127.0.0.1:" + portNumber + "/wd/hub"), cap));
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("Application has started in android platform with port number -- " + portNumber);

        } else if (platformType.equalsIgnoreCase("IOS")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformType);
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            cap.setCapability(MobileCapabilityType.UDID, udid);
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            // cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
            // cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
            /* cap.setCapability("appPackage", "com.oneplus.calculator");
            cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");*/
            /*cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
            cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");*/
            setDriver(new IOSDriver(new URL("http://127.0.0.1:" + portNumber + "/wd/hub"), cap));
            System.out.println("Application started in IOS  platform ................");
        }

    }

    public void switchApp() {
        Activity activity = new Activity("apppkg", "appactivity");
        ((AndroidDriver<?>) getDriver()).startActivity(activity);
    }

}
