import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WULoginTest extends BaseTest {
    String welcome;
    WelcomePage welcomePage;
    LoginPage loginPage;
    EstimatePage estimatePage;
    ReceiverPage receiverPage;
    String email_id ="naveenreddyaleti@gmail.com";
    String password="Work@123!";

    @Test
    public void westernUnionLoginForExistingUser() throws Exception {

        System.out.println("Current thread name -> " + Thread.currentThread());
        welcomePage = new WelcomePage(getDriver());
        welcomePage.selectCountry();
        welcomePage.clickOnNextButton();
        welcomePage.selectLanguage();
        welcomePage.clickOnDoneButton();

        welcome = welcomePage.verifyText("Welcome");
        Assert.assertEquals(welcome, "Welcome");

        loginPage = welcomePage.clickOnLoginOrSignupButton();
        Assert.assertTrue(loginPage.verifyBackButton(), "Back button not present");

        //This is for existing user
        loginPage.enterUserAndPassword(email_id, password);
        estimatePage = loginPage.clickOnSignInButton();
        Assert.assertEquals(estimatePage.verifyEstimateText(), "Estimate");

        estimatePage.clickOnCountryDropDown();
        estimatePage.enterSearchCountry();
        estimatePage.clickOnCountry();
        estimatePage.enterTransferAmount();

        estimatePage.to_SelectCashPickupOption();
        estimatePage.from_SelectCCOption();
        estimatePage.clickOnNextButton();
        receiverPage = estimatePage.clickOnAcceptButton();

        String receiver = receiverPage.verifyEstimateText();
        Assert.assertEquals(receiver, "Receiver");
        receiverPage.clickOnAddReceiverButton();

        receiverPage.enterReceiverDetails();
        receiverPage.selectPurposeOfTransfer();
        receiverPage.selectSourceOfFunds();
        receiverPage.clickOnAddButton();


    }
}
