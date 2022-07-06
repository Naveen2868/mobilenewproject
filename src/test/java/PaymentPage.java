import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utils.LocatorReaderJSON;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;

public class PaymentPage {

    public Swipee swipee;
    public AppiumDriver<MobileElement> driver;
    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap =
            new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
    final String locatorPath = "paymentpage.json";

    public PaymentPage(AppiumDriver<MobileElement> driver) throws IOException, ParseException {
        PaymentPage.localMap = LocatorReaderJSON.fetchLocalVal(locatorPath);
        this.driver = driver;
        swipee = new Swipee(driver);
        swipee.takeScreenshot();
    }

    public String verifyEstimateText() {
        String val = null;
        MobileElement element = driver.findElement(By.xpath("//android.view.View[@text='Payment']"));
        if (element.isDisplayed()) {
            val = element.getText().trim();
        }
        return val;
    }

    public void enterCCDetails() throws InterruptedException {
        enterCCNumber( PropertiesUtils.getProperty("cc_16_digit_number"));
        enterMonth(PropertiesUtils.getProperty("cc_month"));
        enterYear(PropertiesUtils.getProperty("cc_year"));
        enterCVV(PropertiesUtils.getProperty("cc_cvv"));
    }

    private void enterCCNumber(String cc_value) throws InterruptedException {
        MobileElement cc_element = driver.findElement(LocatorReaderJSON.getLocator("credit_card_input_field", "android", "", localMap));
        if (swipee.find(cc_element, 10)) {
            swipee.sendKeys(cc_element, cc_value);
        }

    }

    private void enterMonth(String cc_month) throws InterruptedException {
        MobileElement cc_element = driver.findElement(LocatorReaderJSON.getLocator("month", "android", "", localMap));
        if (swipee.find(cc_element, 10)) {
            swipee.sendKeys(cc_element, cc_month);
        }

    }

    private void enterYear(String cc_year) throws InterruptedException {
        MobileElement cc_element = driver.findElement(LocatorReaderJSON.getLocator("year", "android", "", localMap));
        if (swipee.find(cc_element, 10)) {
            swipee.sendKeys(cc_element, cc_year);
        }

    }

    private void enterCVV(String cc_cvv) throws InterruptedException {
        MobileElement cc_element = driver.findElement(LocatorReaderJSON.getLocator("cvv", "android", "", localMap));
        if (swipee.find(cc_element, 10)) {
            swipee.sendKeys(cc_element, cc_cvv);
        }
    }

    public CompleteYourProfilePage clickOnContinueButton() throws InterruptedException, IOException, ParseException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("continue", "android", "", localMap));
        if (swipee.find(element, 10)) {
            swipee.click(element);
            swipee.minimumWait();
            swipee.takeScreenshot();
        }
        MobileElement agree_ele = driver.findElement
                (LocatorReaderJSON.getLocator("agree_and_continue", "android", "", localMap));
        if (swipee.find(agree_ele, 10)) {
            swipee.click(agree_ele);
            swipee.mediumWait();
            swipee.takeScreenshot();
        }
        swipee.wait(6);
        return new CompleteYourProfilePage(driver);
    }


    public void clickOnDisclaimersButton() throws InterruptedException, IOException, ParseException {
        MobileElement payment_disclaimer = driver.findElement(LocatorReaderJSON.getLocator("payment_disclaimer", "android", "", localMap));
        if (swipee.find(payment_disclaimer, 10)) {
            swipee.tapOnElement(payment_disclaimer);
        }
        swipee.wait(5);
    }




}
