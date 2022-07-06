import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utils.LocatorReaderJSON;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginPage {

    public Swipee swipee;
    public AppiumDriver<MobileElement> driver;
    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap =
            new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
    final String locatorPath = "receiverpage.json";
    public String email_id;
    public String pass_word;
    LocatorReaderJSON json;

    public LoginPage(AppiumDriver<MobileElement> driver) throws IOException, ParseException {
        ReceiverPage.localMap = LocatorReaderJSON.fetchLocalVal(locatorPath);
        this.driver = driver;
        swipee = new Swipee(driver);
    }

    public boolean verifyBackButton() {
        boolean flag = false;
        MobileElement backButton = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='backBtn']"));
        if (backButton.isDisplayed())
            flag = true;

        return flag;
    }

    public boolean verifyForgotPasswordLink() {
        boolean flag = false;
        MobileElement fpassword = driver.findElement(By.
                xpath("//android.view.View[@content-desc='Forgot password?' or @resource-id='forgot-password']"));
        if (fpassword.isDisplayed())
            flag = true;

        return flag;
    }

    private void enterUserName(String user) throws InterruptedException {
        MobileElement email = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='email']"));
        if (email.isDisplayed()) {
            swipee.sendKeys(email, user);
        }

    }

    private void enterPassword(String password) throws InterruptedException {
        MobileElement pass_word = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='password']"));
        if (pass_word.isDisplayed()) {
            swipee.sendKeys(pass_word, password);
        }
    }

    public EstimatePage clickOnSignInButton() throws InterruptedException, IOException, ParseException {
        MobileElement signIn = driver.findElement(By.xpath("//android.widget.Button[@resource-id='signin_btn']"));
        swipee.find(signIn, 10);
        swipee.click(signIn);
        fingerPrintCancelButton();
        swipee.wait(5);
        MobileElement history = driver.findElement
                (By.xpath("//android.widget.TextView[@text='History' or @resource-id='page-title']"));
        swipee.find(history, 10);
        if (history.isDisplayed()) {
            MobileElement start_new_transfer = driver.findElement
                    (By.xpath("//android.widget.Button[@text='Start new transfer' or @resource-id='startNewTransfer']"));
            swipee.find(start_new_transfer, 10);
            swipee.tapOnElement(start_new_transfer);
        }
        return new EstimatePage(driver);
    }

    public void enterUserAndPassword(String user, String pass) throws InterruptedException {
        enterUserName(user);
        enterPassword(pass);
    }

    public void fingerPrintCancelButton() throws InterruptedException {
        MobileElement element_Cancel = driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL']"));
        swipee.find(element_Cancel, 10);
        swipee.tapOnElement(element_Cancel);
    }

    public void clickOnSignUp() throws InterruptedException {
        MobileElement signup = driver.findElement(By.xpath("//android.widget.Button[@resource-id='sign-up']"));
        if (swipee.find(signup, 10)) {
            swipee.click(signup);
        }
        MobileElement allow_btn = driver.findElement(By.xpath("//*[@text='ALLOW' or @text='Allow']"));
        if (swipee.find(allow_btn, 10)) {
            swipee.click(allow_btn);
        }
    }

    public void registration() throws Exception {
        json = new LocatorReaderJSON();
        email_id = json.getRandomEmailId();
        pass_word = "Welcome@123!";
        List<MobileElement> elements = driver.findElements(By.xpath("//android.widget.EditText"));
        swipee.sendKeys(elements.get(0), json.generateUserInfo().get("firstName"));
        swipee.sendKeys(elements.get(1), json.generateUserInfo().get("middleName"));
        swipee.sendKeys(elements.get(2), json.generateUserInfo().get("lastName"));
        swipee.sendKeys(elements.get(3), email_id);
        swipee.sendKeys(elements.get(4), pass_word);

        MobileElement first_checkbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Keep me up')]"));
        MobileElement second_checkbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'You')]"));
        MobileElement third_checkbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'I have ')]"));

        if (swipee.find(first_checkbox, 10)) {
            swipee.tapOnElement(first_checkbox);
        }
        if (swipee.find(second_checkbox, 10)) {
            swipee.tapOnElement(second_checkbox);
        }
        if (swipee.find(third_checkbox, 10)) {
            swipee.tapOnElement(third_checkbox);
        }
    }

    public EstimatePage clickOnSignUpButton() throws InterruptedException, IOException, ParseException {
        MobileElement signup = driver.findElement(
                By.xpath("//android.widget.Button[@resource-id='progressive_signup_privacy_btn']"));
        if (swipee.find(signup, 10)) {
            swipee.click(signup);
        }
        swipee.wait(10);
        MobileElement maybe_later = driver.findElement(
                By.xpath("//android.widget.Button[@text='Maybe later' or @resource-id='btn-may-be-later']"));
        swipee.click(maybe_later);
        swipee.wait(10);
        return new EstimatePage(driver);
    }


}
