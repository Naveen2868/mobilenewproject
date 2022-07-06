import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CalcEvents {

    public AppiumDriver<MobileElement> driver;

    public CalcEvents(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void waitForFewSeconds(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String onePlusMul() {
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
        System.out.println("actual mul values is " + actual);
        return actual;
    }

    public String add() {
        MobileElement five = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
        MobileElement six = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06"));
        MobileElement add = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        MobileElement res = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_tv_result"));
        res.clear();
        waitForFewSeconds(5);
        five.click();
        add.click();
        six.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actual = res.getText();
        System.out.println("actual add values is " + actual);
        return actual;
    }
}
