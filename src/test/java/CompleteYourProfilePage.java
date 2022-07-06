import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utils.LocatorReaderJSON;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;

public class CompleteYourProfilePage {
    public Swipee swipee;
    public AppiumDriver<MobileElement> driver;
    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap =
            new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
    final String locatorPath = "completeyourprofilepage.json";

    public CompleteYourProfilePage(AppiumDriver<MobileElement> driver) throws IOException, ParseException {
        CompleteYourProfilePage.localMap = LocatorReaderJSON.fetchLocalVal(locatorPath);
        this.driver = driver;
        swipee = new Swipee(driver);
        swipee.takeScreenshot();
    }

    public String verifyText(String value) {
        String val = null;
        MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='" + value + "']"));
        if (element.isDisplayed()) {
            val = element.getText().trim();
        }
        return val;
    }

    private void enterMobileNumber(String mobileNumber) throws InterruptedException, IOException {
        MobileElement mobileNumber_element = driver.findElement(LocatorReaderJSON.getLocator("mobile_number", "android", "", localMap));
        if (swipee.find(mobileNumber_element, 10)) {
            swipee.sendKeys(mobileNumber_element, mobileNumber);
        }
        swipee.takeScreenshot();
    }

    private void enterDate(String date) throws InterruptedException, IOException {
        MobileElement date_element = driver.findElement(LocatorReaderJSON.getLocator("date", "android", "", localMap));
        if (swipee.find(date_element, 10)) {
            swipee.sendKeys(date_element, date);
        }
        swipee.takeScreenshot();
    }

    private void enterMonth(String month) throws InterruptedException, IOException {
        MobileElement month_element = driver.findElement(LocatorReaderJSON.getLocator("month", "android", "", localMap));
        if (swipee.find(month_element, 10)) {
            swipee.sendKeys(month_element, month);
        }
        swipee.takeScreenshot();
    }

    private void enterYear(String year) throws InterruptedException, IOException {
        MobileElement year_element = driver.findElement(LocatorReaderJSON.getLocator("year", "android", "", localMap));
        if (swipee.find(year_element, 10)) {
            swipee.sendKeys(year_element, year);
        }
        swipee.takeScreenshot();
    }

    private void enterAddressLine1(String addrLine1) throws InterruptedException, IOException {
        MobileElement addressLine1 = driver.findElement(LocatorReaderJSON.getLocator("addrLine1", "android", "", localMap));
        if (swipee.find(addressLine1, 10)) {
            swipee.sendKeys(addressLine1, addrLine1);
        }
        swipee.takeScreenshot();
    }

    private void enterAddressLine2(String addrLine2) throws InterruptedException, IOException {
        MobileElement addressLine2 = driver.findElement(LocatorReaderJSON.getLocator("addrLine2", "android", "", localMap));
        if (swipee.find(addressLine2, 10)) {
            swipee.sendKeys(addressLine2, addrLine2);
        }
        swipee.takeScreenshot();
    }


    private void enterCity(String city) throws InterruptedException, IOException {
        MobileElement city_element = driver.findElement(LocatorReaderJSON.getLocator("city", "android", "", localMap));
        if (swipee.find(city_element, 10)) {
            swipee.sendKeys(city_element, city);
        }
        swipee.takeScreenshot();
    }

    private void enterPostalCode(String postalCode) throws InterruptedException, IOException {
        MobileElement postalCode_element = driver.findElement(LocatorReaderJSON.getLocator("postalCode", "android", "", localMap));
        if (swipee.find(postalCode_element, 10)) {
            swipee.sendKeys(postalCode_element, postalCode);
        }
        swipee.takeScreenshot();
    }

    private void clickOnCountry() throws InterruptedException, IOException {
        MobileElement select_country = driver.findElement(LocatorReaderJSON.getLocator("select_country", "android", "", localMap));
        if (swipee.find(select_country, 10)) {
            swipee.tapOnElement(select_country);
        }
        swipee.takeScreenshot();
    }

    private void enterSearchCountry(String country) throws InterruptedException, IOException {
        MobileElement search_value_for_country = driver.findElement(LocatorReaderJSON.getLocator("search_value_for_country", "android", "", localMap));
        if (swipee.find(search_value_for_country, 10)) {
            swipee.sendKeys(search_value_for_country, country);
        }
        swipee.takeScreenshot();
    }

    private void clickOnCountryOfBirthDropDown(String countryOfBirth) throws InterruptedException, IOException {
        MobileElement countryOfBirthDropDown = driver.findElement(LocatorReaderJSON.getLocator("country_of_birth", "android", "", localMap));
        if (swipee.find(countryOfBirthDropDown, 10)) {
            swipee.click(countryOfBirthDropDown);
        }
        selectTheCountryOfBirth(countryOfBirth);
    }

    private void selectTheCountryOfBirth(String country) throws InterruptedException, IOException {
        enterSearchCountry(country);
        clickOnCountry();
    }

    private void clickOnNationalityDropDown(String nationality) throws InterruptedException, IOException {
        MobileElement nationality_ele = driver.findElement(LocatorReaderJSON.getLocator("nationality", "android", "", localMap));
        if (swipee.find(nationality_ele, 10)) {
            swipee.click(nationality_ele);
        }
        selectTheCountryOfBirth(nationality);
    }

    private void clickOnMaleRadioButton() throws InterruptedException, IOException {
        MobileElement male = driver.findElement(LocatorReaderJSON.getLocator("male", "android", "", localMap));
        if (swipee.find(male, 10)) {
            swipee.click(male);
        }
        swipee.takeScreenshot();
    }

    private void clickOnFeMaleRadioButton() throws InterruptedException, IOException {
        MobileElement female = driver.findElement(LocatorReaderJSON.getLocator("female", "android", "", localMap));
        if (swipee.find(female, 10)) {
            swipee.click(female);
        }
        swipee.takeScreenshot();
    }


    private void clickOnFirstCheckBox() throws InterruptedException, IOException {
        MobileElement firstCheckBox = driver.findElement(LocatorReaderJSON.getLocator("first_checkbox", "android", "", localMap));
        if (swipee.find(firstCheckBox, 10)) {
            swipee.click(firstCheckBox);
        }
        swipee.takeScreenshot();
    }

    private void clickOnSecondCheckBox() throws InterruptedException, IOException {
        MobileElement secondCheckBox = driver.findElement(LocatorReaderJSON.getLocator("second_checkbox", "android", "", localMap));
        if (swipee.find(secondCheckBox, 10)) {
            swipee.click(secondCheckBox);
        }
        swipee.takeScreenshot();
    }

    public void logout() throws InterruptedException, IOException {
        clickOnMenuButton();
        clickOnLogOutButton();
        clickOnOkButton();
    }

    private void clickOnLogOutButton() throws InterruptedException, IOException {
        MobileElement logout = driver.findElement(LocatorReaderJSON.getLocator("logout", "android", "", localMap));
        if (swipee.find(logout, 10)) {
            swipee.click(logout);
        }
        swipee.takeScreenshot();
    }


    private void clickOnMenuButton() throws InterruptedException, IOException {
        MobileElement menu = driver.findElement(LocatorReaderJSON.getLocator("menu", "android", "", localMap));
        if (swipee.find(menu, 10)) {
            swipee.click(menu);
        }
        swipee.takeScreenshot();
    }


    private void clickOnOkButton() throws InterruptedException, IOException {
        MobileElement ok_button = driver.findElement(By.xpath("//android.widget.Button[@resource-id='singout_link' or @text='OK']"));
        if (swipee.find(ok_button, 10)) {
            swipee.click(ok_button);
        }
        swipee.takeScreenshot();
    }

    public void clickOnContinueButton() throws InterruptedException, IOException {
        MobileElement continueButton = driver.findElement(LocatorReaderJSON.getLocator("continue_button", "android", "", localMap));
        if (swipee.find(continueButton, 10)) {
            swipee.click(continueButton);
        }
        swipee.takeScreenshot();
        swipee.wait(10);
    }

    public void fillCompleteYourProfile() throws Exception {
        enterMobileNumber(PropertiesUtils.getProperty("mobile_number"));
        enterDate(PropertiesUtils.getProperty("date"));
        enterMonth(PropertiesUtils.getProperty("month"));
        enterYear(PropertiesUtils.getProperty("year"));
        enterAddressLine1(PropertiesUtils.getProperty("address_line1"));
        enterAddressLine2(PropertiesUtils.getProperty("address_line2"));
        enterCity(PropertiesUtils.getProperty("city"));
        enterPostalCode(PropertiesUtils.getProperty("postal_code"));
        if (PropertiesUtils.getProperty("gender").equalsIgnoreCase("male")) {
            clickOnMaleRadioButton();
        } else if (PropertiesUtils.getProperty("gender").equalsIgnoreCase("female")) {
            clickOnFeMaleRadioButton();
        }
        clickOnCountryOfBirthDropDown(PropertiesUtils.getProperty("country_of_birth"));
        clickOnNationalityDropDown(PropertiesUtils.getProperty("nationality"));
        swipee.swipeScreen("up");
        clickOnFirstCheckBox();
        clickOnSecondCheckBox();
    }

}
