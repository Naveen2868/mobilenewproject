import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utils.LocatorReaderJSON;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReceiverPage {
    public Swipee swipee;
    public AppiumDriver<MobileElement> driver;
    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap =
            new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
    final String locatorPath = "receiverpage.json";
    LocatorReaderJSON json;
    public ReceiverPage(AppiumDriver<MobileElement> driver) throws IOException, ParseException {
        ReceiverPage.localMap = LocatorReaderJSON.fetchLocalVal(locatorPath);
        this.driver = driver;
        swipee = new Swipee(driver);
        swipee.takeScreenshot();
    }

    public String verifyEstimateText() {
        String val = null;
        MobileElement element = driver.findElement(By.xpath("//android.view.View[@text='Receiver']"));
        if (element.isDisplayed()) {
            val = element.getText().trim();
        }
        return val;
    }

    public void clickOnAddReceiverButton() throws InterruptedException {
        MobileElement element = driver.findElement
                (LocatorReaderJSON.getLocator("add_receiver", "android", "", localMap));
        if (swipee.find(element, 10)) {
            swipee.click(element);
        }
        MobileElement allowElement = driver.findElement
                (LocatorReaderJSON.getLocator("allow_btn", "android", "", localMap));
        if (swipee.find(allowElement, 10)) {
            swipee.click(allowElement);
        }
        swipee.mediumWait();
    }

    public void selectExistingReceiver(int index) throws InterruptedException {
        List<MobileElement> elements = driver.findElements
                (LocatorReaderJSON.getLocator("existing_users", "android", "", localMap));
        if (swipee.find(elements.get(index), 10)) {
            swipee.click(elements.get(index));
        }
        swipee.minimumWait();

    }

    private void enterFirstName(String first_name) throws InterruptedException {
        MobileElement firstName = driver.findElement(LocatorReaderJSON.getLocator("first_name", "android", "", localMap));
        if (swipee.find(firstName, 10)) {
            swipee.sendKeys(firstName, first_name);
        }
    }

    private void enterSurName(String sur_name) throws InterruptedException {
        MobileElement surName = driver.findElement(LocatorReaderJSON.getLocator("sur_name", "android", "", localMap));
        if (swipee.find(surName, 10)) {
            swipee.sendKeys(surName, sur_name);
        }

    }

    private void enterMiddleName(String middle_name) throws InterruptedException {
        MobileElement middleName = driver.findElement(LocatorReaderJSON.getLocator("middle_name", "android", "", localMap));
        if (swipee.find(middleName, 10)) {
            swipee.sendKeys(middleName, middle_name);
        }

    }

    private void enterEmail(String email_address) throws InterruptedException {
        MobileElement email = driver.findElement(LocatorReaderJSON.getLocator("email", "android", "", localMap));
        if (swipee.find(email, 10)) {
            swipee.sendKeys(email, email_address);
        }

    }

    private void enterMobileNumber(String mobile_number) throws InterruptedException {
        MobileElement mobileNumber = driver.findElement(LocatorReaderJSON.getLocator("mobile_number", "android", "", localMap));
        if (swipee.find(mobileNumber, 10)) {
            swipee.sendKeys(mobileNumber, mobile_number);
        }
    }

    public void enterReceiverDetails() throws Exception {
        json = new LocatorReaderJSON();
        enterFirstName(json.generateUserInfo().get("firstName"));
        enterSurName(json.generateUserInfo().get("lastName"));
        enterMiddleName(json.generateUserInfo().get("middleName"));
        enterEmail(json.getRandomEmailId());
        enterMobileNumber(json.getRandomMobileNumber());
        ((AndroidDriver) driver).hideKeyboard();
    }

    public void selectPurposeOfTransfer() throws InterruptedException {
        MobileElement selectPurposeOfTransfer = driver.findElement(LocatorReaderJSON.getLocator("purpose_of_transfer_dropdown", "android", "", localMap));
        if (swipee.find(selectPurposeOfTransfer, 10)) {
            swipee.tapOnElement(selectPurposeOfTransfer);
        }
        MobileElement select_rent = driver.findElement(LocatorReaderJSON.getLocator("purpose_rent", "android", "Rent", localMap));
        if (swipee.find(select_rent, 10)) {
            swipee.tapOnElement(select_rent);
        }
    }

    public void selectSourceOfFunds() throws InterruptedException {
        MobileElement selectSourceOfFunds = driver.findElement(LocatorReaderJSON.getLocator("source_of_funds_dropdown", "android", "", localMap));
        if (swipee.find(selectSourceOfFunds, 10)) {
            swipee.tapOnElement(selectSourceOfFunds);
        }
        MobileElement select_gift = driver.findElement(LocatorReaderJSON.getLocator("source_gift", "android", "Gift", localMap));
        if (swipee.find(select_gift, 10)) {
            swipee.tapOnElement(select_gift);
        }

    }

    public PaymentPage clickOnAddButton() throws InterruptedException, IOException, ParseException {
        MobileElement add_btn = driver.findElement(LocatorReaderJSON.getLocator("add_button", "android", "", localMap));
        if (swipee.find(add_btn, 10)) {
            swipee.tapOnElement(add_btn);
        }
        swipee.wait(5);
        return new PaymentPage(driver);
    }
}
