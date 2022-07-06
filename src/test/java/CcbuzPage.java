import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class CcbuzPage {
    public Swipee swipee;
    public AppiumDriver<MobileElement> driver;

    public CcbuzPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        swipee = new Swipee(driver);
    }

    public MobileElement getLocator() throws Exception {
        MobileElement element = driver.findElement(By.
                xpath("//*[@resource-id='com.cricbuzz.android:id/txt_match_desc' and @index='8']"));
        return element;
    }

    public void scrollMultipleTimesToFindAnElement(String direction, int swipeCount) throws Exception {
        for (int i = 1; i <= swipeCount; i++) {
            if(getLocator().isDisplayed()){
                getLocator().click();
                swipee.mediumWait();
                break;
            }else {
                swipee.swipeScreen(direction);
            }
            swipee.mediumWait();
        }
    }

    public void clickOnMatch() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[contains(@text,'Indian Premier League 2022')]"));
        System.out.println("How manyth match is - " + element.getText());
        swipee.waitForVisibility(element);
        swipee.click(element);
        swipee.minimumWait();
    }

    public void clickOnScoreBoard() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@text='SCORECARD']"));
        swipee.waitForVisibility(element);
        swipee.click(element);
    }

    //2,3
    public void clickOnDropdown(int index) throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@resource-id='com.cricbuzz.android:id/imgarrow' and @index='" + index + "']"));
        swipee.waitForVisibility(element);
        swipee.click(element);
        swipee.mediumWait();
    }

    public void verifyTopTeamLayOuts() {
        int teams_list = driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @index='1']")).size();
        if (teams_list == 2) {
            System.out.println("Verified displaying two teams on the page.");
        } else {
            System.out.println("They are no teams displaying on the page.");
        }
    }

    //0,1
    public void clickOnTeamsTopLayout(int index) throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@resource-id='com.cricbuzz.android:id/topLayout' and @index='" + index + "']"));
        swipee.waitForVisibility(element);
        swipee.click(element);
    }

    public String verifyHeader() {
        MobileElement element = driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @index='1']")).get(0);
        swipee.waitForVisibility(element);
        return element.getText();
    }

    public void enterOTP(String otp) throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@resource-id='com.cricbuzz.android:id/etOtp']"));
        swipee.waitForVisibility(element);
        swipee.sendKeys(element,otp);
    }

    public void getTheDetailsOfTeam() {

        List rowDetails_column1 = new ArrayList();
        List rowDetails_column2 = new ArrayList();
        List rowDetails_column3 = new ArrayList();
        List rowDetails_column4 = new ArrayList();
        List rowDetails_column5 = new ArrayList();
        List rowDetails_column6 = new ArrayList();
        List rowDetails_column7 = new ArrayList();

        int batsmenListSize = driver.findElements(By.xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']")).size();
        System.out.println("batsmenListSize - " + batsmenListSize);

        for (int j = 0; j <= batsmenListSize - 1; j++) {

            int rowDataSize = driver.findElements(By.
                    xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='0']")).size();
            System.out.println("rowData size - " + rowDataSize);

            for (int i = 0; i <= rowDataSize - 1; i++) {

                List<MobileElement> col1 = driver.findElements(By.
                        xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='0']"));
                System.out.println("col1 size - " + col1.size());

                List<MobileElement> col2 = driver.findElements(By.
                        xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='1']"));
                System.out.println("col2 size - " + col2.size());

                List<MobileElement> col3 = driver.findElements(By.
                        xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='2']"));
                System.out.println("col3 size - " + col3.size());

                List<MobileElement> col4 = driver.findElements(By.
                        xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='3']"));
                System.out.println("col4 size - " + col4.size());

                List<MobileElement> col5 = driver.findElements(By.
                        xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='4']"));
                System.out.println("col5 size - " + col5.size());

                List<MobileElement> col6 = driver.findElements(By.
                        xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='5']"));
                System.out.println("col6 size - " + col6.size());

                List<MobileElement> col7 = driver.findElements(By.
                        xpath("//*[@resource-id='com.cricbuzz.android:id/batsmanTopLayout']//*[@class='android.widget.TextView' and @index='6']"));
                System.out.println("col7 size - " + col7.size());

                rowDetails_column1.add(col1.get(i).getText());
                rowDetails_column1.add(col2.get(i).getText());
                rowDetails_column1.add(col3.get(i).getText());
                rowDetails_column1.add(col4.get(i).getText());
                rowDetails_column1.add(col5.get(i).getText());
                rowDetails_column1.add(col6.get(i).getText());
                rowDetails_column1.add(col7.get(i).getText());
                rowDetails_column1.add("------");
            }

        }

        System.out.println("list of data rowDetails_column1 -----------------" + rowDetails_column1);
       /* System.out.println("list of data rowDetails_column2 -----------------" + rowDetails_column2);
        System.out.println("list of data rowDetails_column3 -----------------" + rowDetails_column3);
        System.out.println("list of data rowDetails_column4 -----------------" + rowDetails_column4);
        System.out.println("list of data rowDetails_column5 -----------------" + rowDetails_column5);
        System.out.println("list of data rowDetails_column6 -----------------" + rowDetails_column6);
        System.out.println("list of data rowDetails_column7 -----------------" + rowDetails_column7);*/

    }

    public void clickOnCrickBuzzPlus() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@text='CRICBUZZ PLUS']"));
        swipee.waitForVisibility(element);
        swipee.click(element);
    }

    public void clickOnLoginButton() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@text='Log In']"));
        swipee.waitForVisibility(element);
        swipee.click(element);
    }

    public void clickAndSendKeys(String value) throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@resource-id='com.cricbuzz.android:id/etEmail']"));
        swipee.waitForVisibility(element);
        swipee.sendKeys(element, value);
    }

    public void clickOnContinueButton() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@text='CONTINUE']"));
        swipee.waitForVisibility(element);
        swipee.click(element);
        swipee.mediumWait();
    }

    public String getText() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@text='Enter the 6 digit OTP']"));
        swipee.waitForVisibility(element);
        return element.getText().trim();
    }

    public void clickOnBackButton() throws InterruptedException {
        MobileElement element = driver.findElement(By.xpath("//*[@content-desc=\"Navigate up\"]"));
        swipee.waitForVisibility(element);
        swipee.click(element);
        swipee.mediumWait();
    }
}
