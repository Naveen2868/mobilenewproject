import org.testng.Assert;
import org.testng.annotations.Test;
import utils.VideoRecord;

public class RegistrationTest extends BaseTest {

    String welcome;
    WelcomePage welcomePage;
    LoginPage loginPage;
    EstimatePage estimatePage;
    ReceiverPage receiverPage;
    PaymentPage paymentPage;
    CompleteYourProfilePage completeYourProfilePage;
    VideoRecord videoRecord;

    @Test
    public void westernRegistrationTest() throws Exception {
        videoRecord = new VideoRecord();
        videoRecord.startRecording();

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

        loginPage.clickOnSignUp();
        loginPage.registration();
        estimatePage = loginPage.clickOnSignUpButton();

        System.out.println("Registration user and password as below-------------");
        System.out.println("Username - " + loginPage.email_id + " and Password - " + loginPage.pass_word);
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
        //receiverPage.clickOnAddReceiverButton(); this for existing user flow

        receiverPage.enterReceiverDetails();
        receiverPage.selectPurposeOfTransfer();
        receiverPage.selectSourceOfFunds();
        paymentPage = receiverPage.clickOnAddButton();
        /*paymentPage.enterCCDetails();
        completeYourProfilePage = paymentPage.clickOnContinueButton();
        completeYourProfilePage.fillCompleteYourProfile();
        completeYourProfilePage.clickOnContinueButton();
        completeYourProfilePage.logout();*/

        videoRecord.stopRecording();

    }
}
