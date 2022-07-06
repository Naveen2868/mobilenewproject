import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utils.LocatorReaderJSON;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;

public class WelcomePage {
    public Swipee swipee;
    public AppiumDriver<MobileElement> driver;
    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap =
            new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
    final String locatorPath = "welcomepage.json";

    public WelcomePage(AppiumDriver<MobileElement> driver) throws IOException, ParseException {
        WelcomePage.localMap = LocatorReaderJSON.fetchLocalVal(locatorPath);
        this.driver = driver;
        swipee = new Swipee(driver);
        swipee.takeScreenshot();
    }

    public void selectCountry() throws InterruptedException, IOException {
        String country = PropertiesUtils.getProperty("from_country");
        MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='" + country + "']"));
        element.click();
        swipee.minimumWait();
        swipee.takeScreenshot();
    }

    public void clickOnNextButton() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("next_button", "android", "", localMap));
        swipee.click(element);
        swipee.minimumWait();
    }

    public void selectLanguage() throws InterruptedException, IOException {
        String language = PropertiesUtils.getProperty("language");
        MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='" + language + "']"));
        element.click();
        swipee.minimumWait();
        swipee.takeScreenshot();
    }

    public void clickOnDoneButton() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Done']"));
        swipee.click(element);
        swipee.wait(8);
        //MobileElement welcome = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome']"));
        MobileElement welcome = driver.findElement(By.xpath("//*[@text='Welcome']"));
        swipee.find(welcome, 10);
    }

    public void clickOnPreviousButton() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Previous']"));
        element.click();
        swipee.mediumWait();
    }

    public String verifyText(String value) throws IOException {
        String val = null;
        MobileElement element = driver.findElement(By.xpath("//*[@text='" + value + "']"));
        if (element.isDisplayed()) {
            val = element.getText().trim();
        }
        swipee.takeScreenshot();
        return val;
    }

    public void clickOnMenuButton() throws InterruptedException, IOException {
        MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='menuBtn']"));
        element.click();
        swipee.mediumWait();
        swipee.takeScreenshot();
    }

    public void clickOnSendMoneyButton() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//android.widget.Button[@resource-id='home_smo_btn']"));
        element.click();
        swipee.mediumWait();
    }

    public String getLoginSignupText() {
        String loginSignupText = null;
        MobileElement element = driver.findElement(By.xpath("/android.widget.Button[@resource-id='home_login_btn']"));
        if (element.isDisplayed()) {
            loginSignupText = element.getText().trim();
        }
        return loginSignupText;
    }

    public void clickOnQuickResendLink() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//android.view.View[@resource-id='link-quick-resend']"));
        element.click();
        swipee.mediumWait();
    }

    public void clickOnTrackTransferLink() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//android.view.View[@resource-id='link-track-transfer']"));
        element.click();
        swipee.mediumWait();
    }

    public boolean verifyQuickResendAndTrackTransferImages() {
        boolean flag = false;
        MobileElement quickResend = driver.findElement(By.
                xpath("//android.view.View[@resource-id='link-quick-resend']//android.widget.TextView[1]"));
        // MobileElement trackTransfer = driver.findElement(By.
        // xpath("/android.view.View[@resource-id='link-track-transfer']//android.widget.TextView[1]"));

        if (quickResend.isDisplayed() && quickResend.isEnabled()) {
            flag = true;
        }
        return flag;
    }

    public LoginPage clickOnLoginOrSignupButton() throws InterruptedException, IOException, ParseException {
        MobileElement element = driver.findElement(By.xpath("//android.widget.Button[@resource-id='home_login_btn']"));
        swipee.find(element, 10);
        swipee.click(element);
        swipee.mediumWait();
        swipee.takeScreenshot();
        return new LoginPage(driver);
    }

}
