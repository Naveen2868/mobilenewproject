import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{

    @Test
    public void firstMethod() throws Exception {
        //CalcEvents calcEvents = new CalcEvents(getDriver());
        //Assert.assertEquals(calcEvents.onePlusMul(),"15");
        //Swipee swipee = new Swipee(getDriver());
        CcbuzPage ccbuzPage = new CcbuzPage(getDriver());
        ccbuzPage.clickOnCrickBuzzPlus();
        ccbuzPage.clickOnLoginButton();
        ccbuzPage.clickAndSendKeys("naveenreddyaleti@gmail.com");
        ccbuzPage.clickOnContinueButton();
        String value = ccbuzPage.getText();
        System.out.println("Email text value is - "+value);
        ccbuzPage.enterOTP("123456");
        ccbuzPage.clickOnBackButton();


    }
}
