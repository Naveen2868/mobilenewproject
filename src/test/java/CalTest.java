import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CalTest {

    Calc cal = new Calc();

   // @Test
    public void appLaunching() throws MalformedURLException {
        cal.openCalc();
        Assert.assertEquals(cal.mul(),"30");
    }

    //@Test
    public void appLaunchingForOneplus() throws MalformedURLException {
        cal.openCalc();
        Assert.assertEquals(cal.oneplusmul(),"15");
        cal.clearCalc();
        cal.stopAppiumServer();
    }

    @Test
    public void cbuz() throws Exception {
        cal.openCalc();
        //Swipee swipee = new Swipee()
               // swipeScreen("up");
        //MobileElement element = cal.getElement();
        //MobileElement element1 = new Swipee().scrollToElement(element,"left");

    }

}
