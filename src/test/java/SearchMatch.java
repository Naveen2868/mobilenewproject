import org.testng.annotations.Test;

public class SearchMatch extends BaseTest{



    @Test
    public void searchTest() throws Exception {
        Swipee swipee = new Swipee(getDriver());
        swipee.scrollMultipleTimes("left",6);
       // swipee.scrollMultipleTimes("left",6);
       CcbuzPage ccbuzPage = new CcbuzPage(getDriver());
       //ccbuzPage.scrollMultipleTimesToFindAnElement("left",6);
        ccbuzPage.clickOnMatch();
        System.out.println("Page header value - "+ccbuzPage.verifyHeader());
        ccbuzPage.clickOnScoreBoard();
        ccbuzPage.clickOnDropdown(3);//closed dropdown which is open by default 2nd one
        ccbuzPage.verifyTopTeamLayOuts();
        ccbuzPage.clickOnDropdown(2);//open drop down
        ccbuzPage.getTheDetailsOfTeam();
        ccbuzPage.clickOnBackButton();

        /* CcbuzPage ccbuzPage = new CcbuzPage(getDriver());
        ccbuzPage.clickOnCrickBuzzPlus();
        ccbuzPage.clickOnLoginButton();
        ccbuzPage.clickAndSendKeys("naveenreddyaleti@gmail.com");
        ccbuzPage.clickOnContinueButton();
        String value = ccbuzPage.getText();
        System.out.println("Email text value is - "+value);
        ccbuzPage.clickOnBackButton();*/


    }
}
