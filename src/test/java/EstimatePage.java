import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utils.LocatorReaderJSON;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;

public class EstimatePage {
    public Swipee swipee;
    public AppiumDriver<MobileElement> driver;
    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap =
            new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
    final String locatorPath = "estimatepage.json";

    public EstimatePage(AppiumDriver<MobileElement> driver) throws IOException, ParseException {
        EstimatePage.localMap = LocatorReaderJSON.fetchLocalVal(locatorPath);
        this.driver = driver;
        swipee = new Swipee(driver);
        swipee.takeScreenshot();
    }

    public String verifyEstimateText() {
        String val = null;
        MobileElement element = driver.findElement(By.xpath("//android.view.View[@text='Estimate']"));
        if (element.isDisplayed()) {
            val = element.getText().trim();
        }
        return val;
    }

    public void clickOnCountry() throws InterruptedException {
        MobileElement country_dropdown = driver.findElement(By.xpath("//android.widget.Button[@resource-id='country']"));
        swipee.find(country_dropdown, 10);
        swipee.tapOnElement(country_dropdown);
    }

    public void enterSearchCountry() throws InterruptedException {
        String to_country = PropertiesUtils.getProperty("to_country");
        MobileElement country_dropdown = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='searchText']"));
        swipee.find(country_dropdown, 10);
        if(to_country!=null){
            swipee.sendKeys(country_dropdown,to_country);
        }
    }

    public void clickOnCountryDropDown() throws InterruptedException {
        MobileElement country_dropdown = driver.findElement(By.xpath("//android.widget.Button[@text='Send to Choose country']"));
        swipee.find(country_dropdown, 10);
        swipee.tapOnElement(country_dropdown);
    }

    public void enterTransferAmount() throws InterruptedException {
        String transfer_amt = PropertiesUtils.getProperty("transfer_amount");
        MobileElement country_dropdown = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='sendAmt']"));
        swipee.find(country_dropdown, 10);
        swipee.sendKeys(country_dropdown,transfer_amt);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        swipee.wait(5);
    }

    public void to_SelectCashPickupOption() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("cash_pickup", "android", "", localMap));
        swipee.find(element, 10);
        swipee.tapOnElement(element);
        swipee.minimumWait();
    }

    public void to_SelectBankAccountOption() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("to_bank_account", "android", "", localMap));
        swipee.find(element, 10);
        swipee.tapOnElement(element);
        swipee.minimumWait();
    }


    public void from_SelectCCOption() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("from_credit_card", "android", "", localMap));
        swipee.find(element, 10);
        swipee.tapOnElement(element);
        swipee.minimumWait();
    }

    public void from_SelectBankTransferOption() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("from_bank_transfer", "android", "", localMap));
        swipee.find(element, 10);
        swipee.tapOnElement(element);
        swipee.minimumWait();
    }

    public void from_SelectOnlineBankTransferOption() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("from_online_transfer", "android", "", localMap));
        swipee.find(element, 10);
        swipee.tapOnElement(element);
        swipee.minimumWait();

    }

    public void clickOnNextButton() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("next_button", "android", "", localMap));
        swipee.click(element);
        swipee.minimumWait();
    }


    public ReceiverPage clickOnAcceptButton() throws InterruptedException, IOException, ParseException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("accept_button", "android", "", localMap));
        swipee.click(element);
        swipee.minimumWait();
        return new ReceiverPage(driver);
    }





















}
